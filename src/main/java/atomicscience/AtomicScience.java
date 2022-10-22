package atomicscience;

import atomicscience.api.BlockRadioactive;
import atomicscience.api.ISteamReceptor;
import atomicscience.api.Plasma;
import atomicscience.api.poison.PoisonRadiation;
import atomicscience.api.poison.PotionRadiation;
import atomicscience.fanwusu.BAccelerator;
import atomicscience.fanwusu.BFulminationGenerator;
import atomicscience.fanwusu.EMatter;
import atomicscience.fanwusu.FulminationEventHandler;
import atomicscience.fanwusu.ItAntimatterCell;
import atomicscience.fanwusu.TAccelerator;
import atomicscience.fanwusu.TFulminationGenerator;
import atomicscience.fenlie.BCentrifuge;
import atomicscience.fenlie.BControlRod;
import atomicscience.fenlie.BFissionReactor;
import atomicscience.fenlie.BNuclearBoiler;
import atomicscience.fenlie.BReactorTap;
import atomicscience.fenlie.BSiren;
import atomicscience.fenlie.BUraniumOre;
import atomicscience.fenlie.ItRadioactive;
import atomicscience.fenlie.ItStrangeMatter;
import atomicscience.fenlie.ItUranium;
import atomicscience.fenlie.TCentrifuge;
import atomicscience.fenlie.TFissionReactor;
import atomicscience.fenlie.TNuclearBoiler;
import atomicscience.fenlie.TReactorTap;
import atomicscience.hecheng.BElectromagnet;
import atomicscience.hecheng.BElectromagnetGlass;
import atomicscience.hecheng.BFusionReactor;
import atomicscience.hecheng.BPlasma;
import atomicscience.hecheng.IBAccelerator;
import atomicscience.hecheng.IBPlasma;
import atomicscience.hecheng.IBSiren;
import atomicscience.hecheng.TElectromagnet;
import atomicscience.hecheng.TFusionReactor;
import atomicscience.jiqi.BChemicalExtractor;
import atomicscience.jiqi.BFunnel;
import atomicscience.jiqi.BThermometer;
import atomicscience.jiqi.BTurbine;
import atomicscience.jiqi.ItHazmatSuite;
import atomicscience.jiqi.ItThermometer;
import atomicscience.jiqi.TChemicalExtractor;
import atomicscience.jiqi.TFunnel;
import atomicscience.jiqi.TThermometer;
import atomicscience.jiqi.TTurbine;
import atomicscience.wujian.ItBreederFuel;
import atomicscience.wujian.ItCell;
import atomicscience.wujian.ItFissileFuel;
import calclavia.lib.UniversalRecipes;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Arrays;
import java.util.logging.Logger;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.event.TextureStitchEvent.Post;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.common.ForgeChunkManager.Ticket;
import net.minecraftforge.common.ForgeChunkManager.Type;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import universalelectricity.core.item.ElectricItemHelper;
import universalelectricity.core.item.ItemElectric;
import universalelectricity.core.vector.Vector3;
import universalelectricity.prefab.TranslationHelper;
import universalelectricity.prefab.ore.OreGenBase;
import universalelectricity.prefab.ore.OreGenReplaceStone;
import universalelectricity.prefab.ore.OreGenerator;

@Mod(modid = "AtomicScience", name = "Atomic Science", version = "0.6.2",
     dependencies = "required-after:basiccomponents")
public class AtomicScience {
  public static Configuration CONFIGURATION =
      new Configuration(Loader.instance().getConfigDir(), "AtomicScience.cfg");
  public static final String ID = "AtomicScience";
  public static final String CHANNEL = "AtomicScience";
  public static final String PREFIX = "atomicscience:";
  @Instance("AtomicScience") public static AtomicScience instance;
  @SidedProxy(clientSide = "atomicscience.ClientProxy",
              serverSide = "atomicscience.CommonProxy")
  public static CommonProxy proxy;
  @Metadata("AtomicScience") public static ModMetadata metadata;
  private static final String[] LANGUAGES = new String[] {"en_US"};
  public static float WOLUN_MULTIPLIER_OUTPUT = 30.0F;
  public static boolean ALLOW_LAYERED_TURBINES = true;
  public static boolean ALLOW_TOXIC_WASTE = true;
  public static boolean ALLOW_RADIOACTIVE_ORES = true;
  public static final int BLOCK_ID_PREFIX = 3768;
  public static final int ENTITY_ID_PREFIX = 49;
  public static Block blockRadioactive;
  public static Block bCentrifuge;
  public static Block bTurbine;
  public static Block bNuclearBoiler;
  public static Block bControlRod;
  public static Block bThermometer;
  public static Block bFusionReactor;
  public static BPlasma bPlasma;
  public static Block bElectromagnet;
  public static Block bChemicalExtractor;
  public static Block bSiren;
  public static Block bElectromagnetGlass;
  public static Block bFunnel;
  public static Block bAccelerator;
  public static Block bAutoBuilder;
  public static Block bFulminationGenerator;
  public static Block bAtomicAssembler;
  public static Block bFissionReactor;
  public static Block bReactorTap;
  public static Block bSuperConductor;
  public static final int ITEM_ID_PREFIX = 13768;
  public static Item itCell;
  public static Item itCellUranium;
  public static Item itCellBreederFuel;
  public static Item itCellStrangeMatter;
  public static Item itCellAntimatter;
  public static Item itCellDeuterium;
  public static Item itCellWater;
  public static Item itBucketToxic;
  public static Block bUraniumOre;
  public static Item itYellowcake;
  public static Item itUranium;
  public static ItemElectric itThermometer;
  public static Item itHazmatHelmet;
  public static Item itHazmatChestplate;
  public static Item itHazmanLeggings;
  public static Item itHazmatBoots;
  public static Block bToxicWaste;
  public static Fluid FLUID_URANIUM_HEXAFLOURIDE;
  public static Fluid FLUID_STEAM;
  public static Fluid FLUID_TOXIC_WASTE;
  public static final ArmorMaterial hazmatArmorMaterial =
      EnumHelper.addArmorMaterial("HAZMAT", 0, new int[] {0, 0, 0, 0}, 0);
  public static OreGenBase uraniumOreGeneration;
  public static int URANIUM_HEXAFLOURIDE_RATIO = 200;
  public static int STEAM_RATIO = 40;
  // public static final String QIZI_FAN_WU_SU_BAO_ZHA =
  // FlagRegistry.registerFlag("ban_antimatter_power");
  public static final Logger LOGGER = Logger.getLogger("AtomicScience");

  public static SimpleNetworkWrapper channel;

  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    instance = this;
    MinecraftForge.EVENT_BUS.register(this);
    AtomicScience.CONFIGURATION.load();
    WOLUN_MULTIPLIER_OUTPUT = (float)AtomicScience.CONFIGURATION
                                  .get("general", "Turbine Output Multiplier",
                                       (double)WOLUN_MULTIPLIER_OUTPUT)
                                  .getDouble((double)WOLUN_MULTIPLIER_OUTPUT);
    ALLOW_LAYERED_TURBINES =
        AtomicScience.CONFIGURATION
            .get("general", "Allow Layered Turbines", ALLOW_LAYERED_TURBINES)
            .getBoolean(ALLOW_LAYERED_TURBINES);
    ALLOW_TOXIC_WASTE =
        AtomicScience.CONFIGURATION
            .get("general", "Allow Toxic Waste", ALLOW_TOXIC_WASTE)
            .getBoolean(ALLOW_TOXIC_WASTE);
    ALLOW_RADIOACTIVE_ORES =
        AtomicScience.CONFIGURATION
            .get("general", "Allow Radioactive Ores", ALLOW_RADIOACTIVE_ORES)
            .getBoolean(ALLOW_RADIOACTIVE_ORES);
    PoisonRadiation.disabled =
        AtomicScience.CONFIGURATION
            .get("general", "Disable Radiation", PoisonRadiation.disabled)
            .getBoolean(PoisonRadiation.disabled);
    URANIUM_HEXAFLOURIDE_RATIO =
        AtomicScience.CONFIGURATION
            .get("general", "Uranium Hexafluoride Ratio",
                 URANIUM_HEXAFLOURIDE_RATIO)
            .getInt(URANIUM_HEXAFLOURIDE_RATIO);
    STEAM_RATIO =
        AtomicScience.CONFIGURATION.get("general", "Steam Ratio", STEAM_RATIO)
            .getInt(STEAM_RATIO);
    PotionRadiation.INSTANCE.getId();
    blockRadioactive = (new BlockRadioactive()
                            .setBlockName("atomicscience:radioactive")
                            .setCreativeTab(TabAS.INSTANCE));
    bUraniumOre = new BUraniumOre();
    bCentrifuge = new BCentrifuge();
    bFissionReactor = new BFissionReactor();
    bTurbine = new BTurbine();
    bNuclearBoiler = new BNuclearBoiler();
    bControlRod = new BControlRod();
    bThermometer = new BThermometer();
    bFusionReactor = new BFusionReactor();
    bPlasma = new BPlasma();
    bElectromagnet = new BElectromagnet();
    bChemicalExtractor = new BChemicalExtractor();
    bSiren = new BSiren();
    bElectromagnetGlass = new BElectromagnetGlass();
    bFunnel = new BFunnel();
    bAccelerator = new BAccelerator();
    bAutoBuilder = new BAutoBuilder();
    bFulminationGenerator = new BFulminationGenerator();
    bAtomicAssembler = new BAtomicAssembler();
    bReactorTap = new BReactorTap();
    bSuperConductor = new BSuperconductor();
    itHazmatHelmet =
        (new ItHazmatSuite(

             hazmatArmorMaterial, proxy.getArmorIndex("hazmat"), 0))
            .setUnlocalizedName("atomicscience:hazmatMask");
    itHazmatChestplate = (new ItHazmatSuite(hazmatArmorMaterial,
                                            proxy.getArmorIndex("hazmat"), 1))
                             .setUnlocalizedName("atomicscience:hazmatBody");
    itHazmanLeggings = (new ItHazmatSuite(hazmatArmorMaterial,
                                          proxy.getArmorIndex("hazmat"), 2))
                           .setUnlocalizedName("atomicscience:hazmatLeggings");
    itHazmatBoots = (new ItHazmatSuite(hazmatArmorMaterial,
                                       proxy.getArmorIndex("hazmat"), 3))
                        .setUnlocalizedName("atomicscience:hazmatBoots");
    itThermometer = new ItThermometer(1);
    itCell = new ItCell("cellEmpty");
    itCellUranium = new ItFissileFuel();
    itCellDeuterium = new ItCell("cellDeuterium");
    itCellStrangeMatter = new ItStrangeMatter();
    itCellAntimatter = new ItAntimatterCell();
    itCellWater = new ItCell("cellWater");
    itCellBreederFuel = new ItBreederFuel();
    itYellowcake = new ItRadioactive("yellowcake")
                       .setTextureName("atomicscience:yellowcake");
    itUranium = new ItUranium(0);
    FLUID_URANIUM_HEXAFLOURIDE = getOrRegisterFluid("uranium_hexafluoride");
    FLUID_STEAM = getOrRegisterFluid("steam");
    FLUID_TOXIC_WASTE = getOrRegisterFluid("toxic_waste");
    bToxicWaste =
        (new BToxicWaste("toxicWaste")).setCreativeTab((CreativeTabs)null);
    itBucketToxic = (new ItemBucket(bToxicWaste))
                        .setCreativeTab(TabAS.INSTANCE)
                        .setUnlocalizedName("atomicscience:bucketToxicWaste")
                        .setTextureName("atomicscience:bucketToxicWaste")
                        .setContainerItem(Items.bucket);
    FluidContainerRegistry.registerFluidContainer(new FluidContainerData(
        new FluidStack(FLUID_TOXIC_WASTE, 1000), new ItemStack(itBucketToxic),
        new ItemStack(Items.bucket)));
    NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);

    GameRegistry.registerItem(itCell, "itCell");
    GameRegistry.registerItem(itCellUranium, "itCellUranium");
    GameRegistry.registerItem(itCellBreederFuel, "itCellBreederFuel");
    GameRegistry.registerItem(itCellStrangeMatter, "itCellStrangeMatter");
    GameRegistry.registerItem(itCellAntimatter, "itCellAntimatter");
    GameRegistry.registerItem(itCellDeuterium, "itCellDeuterium");
    GameRegistry.registerItem(itCellWater, "itCellWater");
    GameRegistry.registerItem(itBucketToxic, "itBucketToxic");
    GameRegistry.registerItem(itYellowcake, "itYellowcake");
    GameRegistry.registerItem(itUranium, "itUranium");
    GameRegistry.registerItem(itThermometer, "itThermometer");
    GameRegistry.registerItem(itHazmatHelmet, "itHazmatHelmet");
    GameRegistry.registerItem(itHazmatChestplate, "itHazmatChestplate");
    GameRegistry.registerItem(itHazmanLeggings, "itHazmanLeggings");
    GameRegistry.registerItem(itHazmatBoots, "itHazmatBoots");

    GameRegistry.registerBlock(blockRadioactive, "blockRadioactive");
    GameRegistry.registerBlock(bUraniumOre, "bUraniumOre");
    GameRegistry.registerBlock(bCentrifuge, "bCentrifuge");
    GameRegistry.registerBlock(bFissionReactor, "bFissionReactor");
    GameRegistry.registerBlock(bTurbine, "bTurbine");
    GameRegistry.registerBlock(bNuclearBoiler, "bNuclearBoiler");
    GameRegistry.registerBlock(bControlRod, "bControlRod");
    GameRegistry.registerBlock(bThermometer, "bThermometer");
    GameRegistry.registerBlock(bFusionReactor, "bFusionReactor");
    GameRegistry.registerBlock(bPlasma, IBPlasma.class, "bPlasma");
    GameRegistry.registerBlock(bElectromagnet, "bElectromagnet");
    GameRegistry.registerBlock(bChemicalExtractor, "bChemicalExtractor");
    GameRegistry.registerBlock(bSiren, IBSiren.class, "bSiren");
    GameRegistry.registerBlock(bElectromagnetGlass, "bElectromagnetGlass");
    GameRegistry.registerBlock(bFunnel, "bFunnel");
    GameRegistry.registerBlock(bAccelerator, IBAccelerator.class,
                               "bAccelerator");
    GameRegistry.registerBlock(bAutoBuilder, "bAutoBuilder");
    GameRegistry.registerBlock(bFulminationGenerator, "bFulminationGenerator");
    GameRegistry.registerBlock(bAtomicAssembler, "bAtomicAssembler");
    GameRegistry.registerBlock(bToxicWaste, "bToxicWaste");
    GameRegistry.registerBlock(bReactorTap, "bReactorTap");
    GameRegistry.registerBlock(bSuperConductor, "bSuperConductor");
    uraniumOreGeneration = new OreGenReplaceStone("Uranium Ore", "oreUranium",
                                                  new ItemStack(bUraniumOre), 0,
                                                  25, 9, 3, "pickaxe", 2);
    if (OreDictionary.getOres("oreUranium").size() > 1 &&
        AtomicScience.CONFIGURATION
            .get("general", "Auto Disable Uranium If Exist", false)
            .getBoolean(false)) {
      LOGGER.fine(
          "Disabled Uranium Generation. Detected another uranium being generated: " +
          OreDictionary.getOres("oreUranium").size());
    } else {
      uraniumOreGeneration.enable(AtomicScience.CONFIGURATION);
      OreGenerator.addOre(uraniumOreGeneration);
      LOGGER.fine("Added Atomic Science uranium to ore generator.");
    }

    AtomicScience.CONFIGURATION.save();
    MinecraftForge.EVENT_BUS.register(itCellAntimatter);
    MinecraftForge.EVENT_BUS.register(FulminationEventHandler.INSTANCE);
    OreDictionary.registerOre("ingotUranium", itUranium);
    OreDictionary.registerOre("breederUranium", new ItemStack(itUranium, 1, 1));
    OreDictionary.registerOre("blockRadioactive", blockRadioactive);
    OreDictionary.registerOre("cellEmpty", itCell);
    OreDictionary.registerOre("cellUranium", itCellUranium);
    OreDictionary.registerOre("cellDeuterium", itCellDeuterium);
    OreDictionary.registerOre("cellWater", itCellWater);
    OreDictionary.registerOre("strangeMatter", itCellStrangeMatter);
    OreDictionary.registerOre("antimatterMilligram",
                              new ItemStack(itCellAntimatter, 1, 0));
    OreDictionary.registerOre("antimatterGram",
                              new ItemStack(itCellAntimatter, 1, 1));
    FluidContainerRegistry.registerFluidContainer(new FluidContainerData(
        new FluidStack(FluidRegistry.WATER, 1000), new ItemStack(itCellWater),
        new ItemStack(itCell)));
    ForgeChunkManager.setForcedChunkLoadingCallback(this, (tickets, world) -> {
      for (Ticket ticket : tickets) {
        if (ticket.getType() == Type.ENTITY && ticket.getEntity() != null &&
            ticket.getEntity() instanceof EMatter) {
          ((EMatter)ticket.getEntity()).youPiao = ticket;
        }
      }
    });
    Plasma.blockPlasma = bPlasma;
    GameRegistry.registerTileEntity(TCentrifuge.class, "ASCentrifuge");
    GameRegistry.registerTileEntity(TFusionReactor.class, "ASFusionReactor");
    GameRegistry.registerTileEntity(TTurbine.class, "ASTurbine");
    GameRegistry.registerTileEntity(TNuclearBoiler.class, "ASNuclearBoiler");
    GameRegistry.registerTileEntity(TThermometer.class, "ASThermometer");
    GameRegistry.registerTileEntity(TElectromagnet.class, "ASElectromagnet");
    GameRegistry.registerTileEntity(TChemicalExtractor.class,
                                    "ASChemicalExtractor");
    GameRegistry.registerTileEntity(TFunnel.class, "ASFunnel");
    GameRegistry.registerTileEntity(TAccelerator.class, "ASAccelerator");
    GameRegistry.registerTileEntity(TFulminationGenerator.class,
                                    "ASFulminationGenerator");
    GameRegistry.registerTileEntity(TAtomicAssembler.class,
                                    "ASAtomicAssembler");
    GameRegistry.registerTileEntity(TAutoBuilder.class, "ASAutoBuilder");
    GameRegistry.registerTileEntity(TFissionReactor.class, "ASFissionReactor");
    GameRegistry.registerTileEntity(TReactorTap.class, "ASReactorTap");
    GameRegistry.registerTileEntity(TSuperconductor.class, "ASSuperconductor");
    proxy.preInit();

    channel = NetworkRegistry.INSTANCE.newSimpleChannel("AtomicScience");
    channel.registerMessage(PHAutoBuilder.class, PAutoBuilder.class, 0,
                            Side.SERVER);
  }

  @EventHandler
  public void load(FMLInitializationEvent evt) {
    metadata.modId = "AtomicScience";
    metadata.name = "Atomic Science";
    metadata.description =
        "Electricity generation is always a burden. That\'s why we are here to bring in high tech nuclear power to solve all your electricity-lack problems. With our fission reactors, fusion reactors, and antimatter generators, you won\'t be lacking electricity ever again!";
    metadata.url = "http://www.universalelectricity.com/atomicscience";
    metadata.logoFile = "/as_logo.png";
    metadata.version = "0.6.2.117";
    metadata.authorList = Arrays.asList(new String[] {"Calclavia"});
    metadata.credits = "Please visit the website.";
    metadata.autogenerated = false;
    LOGGER.fine("Loaded Languages: " +
                TranslationHelper.loadLanguages("/assets/atomicscience/lang/",
                                                LANGUAGES));

    proxy.init();
  }

  @EventHandler
  public void postInit(FMLPostInitializationEvent event) {
    UniversalRecipes.init();
    if (Loader.isModLoaded("IC2")) {
      OreDictionary.registerOre("cellEmpty", itCell);
      GameRegistry.addRecipe(new ShapelessOreRecipe(
          itYellowcake, GameRegistry.findItem("IC2", "reactorUraniumSimple")));
      Item ic2FluidCell = GameRegistry.findItem("IC2", "itemFluidCell");
      GameRegistry.addRecipe(new ShapelessOreRecipe(ic2FluidCell, itCell));
      GameRegistry.addRecipe(new ShapelessOreRecipe(itCell, "cellEmpty"));
    }

    GameRegistry.addRecipe(new ShapelessOreRecipe(
        new ItemStack(itCellAntimatter, 1, 1), itCellAntimatter,
        itCellAntimatter, itCellAntimatter, itCellAntimatter, itCellAntimatter,
        itCellAntimatter, itCellAntimatter, itCellAntimatter));
    GameRegistry.addRecipe(new ShapelessOreRecipe(
        new ItemStack(itCellAntimatter, 8, 0),
        new Object[] {new ItemStack(itCellAntimatter, 1, 1)}));
    GameRegistry.addRecipe(new ShapedOreRecipe(
        new ItemStack(bFunnel, 2), " B ", "B B", "B B", 'B', "ingotBronze"));
    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bFunnel, 2), " B ",
                                               "B B", "B B", 'B', "ingotIron"));
    GameRegistry.addRecipe(new ShapedOreRecipe(
        bAtomicAssembler, "CCC", "SXS", "SSS", 'X', bCentrifuge, 'C',
        "calclavia:CIRCUIT_T3", 'S', "plateSteel"));
    GameRegistry.addRecipe(new ShapedOreRecipe(
        bFulminationGenerator, "OSO", "SCS", "OSO", 'O', Blocks.obsidian, 'C',
        "calclavia:CIRCUIT_T2", 'S', "plateSteel"));
    GameRegistry.addRecipe(new ShapedOreRecipe(
        bAccelerator, "SCS", "CMC", "SCS", 'M', "calclavia:MOTOR", 'C',
        "calclavia:CIRCUIT_T3", 'S', "plateSteel"));
    GameRegistry.addRecipe(new ShapelessOreRecipe(
        bElectromagnetGlass, new Object[] {bElectromagnet, Blocks.glass}));
    GameRegistry.addRecipe(new ShapedOreRecipe(
        bCentrifuge,
        new Object[] {"BSB", "MCM", "BSB", Character.valueOf('C'),
                      "calclavia:CIRCUIT_T2", Character.valueOf('S'),
                      "plateSteel", Character.valueOf('B'), "ingotBronze",
                      Character.valueOf('M'), "calclavia:MOTOR"}));
    GameRegistry.addRecipe(new ShapedOreRecipe(
        bNuclearBoiler,
        new Object[] {"S S", "FBF", "SMS", Character.valueOf('F'),
                      Blocks.furnace, Character.valueOf('S'), "plateSteel",
                      Character.valueOf('B'), Items.bucket,
                      Character.valueOf('M'), "calclavia:MOTOR"}));
    GameRegistry.addRecipe(new ShapedOreRecipe(
        bChemicalExtractor,
        new Object[] {"BSB", "MCM", "BSB", Character.valueOf('C'),
                      "calclavia:CIRCUIT_T3", Character.valueOf('S'),
                      "plateSteel", Character.valueOf('B'), "ingotBronze",
                      Character.valueOf('M'), "calclavia:MOTOR"}));
    GameRegistry.addRecipe(new ShapedOreRecipe(
        new ItemStack(bSiren, 2),
        new Object[] {"NPN", Character.valueOf('N'), Blocks.noteblock,
                      Character.valueOf('P'), "plateBronze"}));
    GameRegistry.addRecipe(new ShapedOreRecipe(
        bFissionReactor,
        new Object[] {"SCS", "MEM", "SCS", Character.valueOf('E'), "cellEmpty",
                      Character.valueOf('C'), "calclavia:CIRCUIT_T2",
                      Character.valueOf('S'), "plateSteel",
                      Character.valueOf('M'), "calclavia:MOTOR"}));
    GameRegistry.addRecipe(new ShapedOreRecipe(
        bFusionReactor,
        new Object[] {"CPC", "PFP", "CPC", Character.valueOf('P'), "plateSteel",
                      Character.valueOf('F'), bFissionReactor,
                      Character.valueOf('C'), "calclavia:CIRCUIT_T3"}));
    GameRegistry.addRecipe(new ShapedOreRecipe(
        bTurbine, new Object[] {" B ", "BMB", " B ", Character.valueOf('B'),
                                "plateBronze", Character.valueOf('M'),
                                "calclavia:MOTOR"}));
    GameRegistry.addRecipe(new ShapedOreRecipe(
        bReactorTap,
        new Object[] {"SBS", "TMT", "SBS", Character.valueOf('S'),
                      "plateBronze", Character.valueOf('T'), "ingotBronze",
                      Character.valueOf('M'), "calclavia:MOTOR",
                      Character.valueOf('B'), Items.bucket}));
    GameRegistry.addRecipe(new ShapedOreRecipe(
        new ItemStack(itCell, 16),
        new Object[] {" T ", "TGT", " T ", Character.valueOf('T'), "ingotTin",
                      Character.valueOf('G'), Blocks.glass}));
    GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itCellWater),
                                                  itCell, Items.water_bucket));
    GameRegistry.addRecipe(new ShapedOreRecipe(
        ElectricItemHelper.getUncharged(new ItemStack(itThermometer)),
        new Object[] {"SSS", "GCG", "GSG", Character.valueOf('S'), "ingotSteel",
                      Character.valueOf('G'), Blocks.glass,
                      Character.valueOf('C'), "calclavia:CIRCUIT_T1"}));
    GameRegistry.addRecipe(new ShapedOreRecipe(
        bThermometer, new Object[] {"SSS", "SWS", "SSS", Character.valueOf('S'),
                                    "ingotSteel", Character.valueOf('W'),
                                    ElectricItemHelper.getUncharged(
                                        new ItemStack(itThermometer))}));
    GameRegistry.addRecipe(new ShapedOreRecipe(
        bControlRod, new Object[] {"I", "I", "I", Character.valueOf('I'),
                                   Items.iron_ingot}));
    GameRegistry.addRecipe(new ShapedOreRecipe(
        itCellUranium,
        new Object[] {"CUC", "CUC", "CUC", Character.valueOf('U'),
                      "ingotUranium", Character.valueOf('C'), "cellEmpty"}));
    GameRegistry.addRecipe(new ShapedOreRecipe(
        itCellBreederFuel,
        new Object[] {"CUC", "CUC", "CUC", Character.valueOf('U'),
                      "breederUranium", Character.valueOf('C'), "cellEmpty"}));
    GameRegistry.addRecipe(new ShapedOreRecipe(
        new ItemStack(bElectromagnet, 2),
        new Object[] {"BBB", "BMB", "BBB", Character.valueOf('B'),
                      "ingotBronze", Character.valueOf('M'),
                      "calclavia:MOTOR"}));
    GameRegistry.addRecipe(new ShapedOreRecipe(
        new ItemStack(bElectromagnet, 2),
        new Object[] {"BBB", "BMB", "BBB", Character.valueOf('B'), "ingotIron",
                      Character.valueOf('M'), "calclavia:MOTOR"}));
    GameRegistry.addRecipe(new ShapedOreRecipe(
        itHazmatHelmet,
        new Object[] {"SSS", "BAB", "SCS", Character.valueOf('A'),
                      Items.leather_helmet, Character.valueOf('C'),
                      "calclavia:CIRCUIT_T1", Character.valueOf('S'),
                      Blocks.wool}));
    GameRegistry.addRecipe(new ShapedOreRecipe(
        itHazmatChestplate,
        new Object[] {"SSS", "BAB", "SCS", Character.valueOf('A'),
                      Items.leather, Character.valueOf('C'),
                      "calclavia:CIRCUIT_T1", Character.valueOf('S'),
                      Blocks.wool}));
    GameRegistry.addRecipe(new ShapedOreRecipe(
        itHazmanLeggings,
        new Object[] {"SSS", "BAB", "SCS", Character.valueOf('A'),
                      Items.leather_leggings, Character.valueOf('C'),
                      "calclavia:CIRCUIT_T1", Character.valueOf('S'),
                      Blocks.wool}));
    GameRegistry.addRecipe(new ShapedOreRecipe(
        itHazmatBoots,
        new Object[] {"SSS", "BAB", "SCS", Character.valueOf('A'),
                      Items.leather_boots, Character.valueOf('C'),
                      "calclavia:CIRCUIT_T1", Character.valueOf('S'),
                      Blocks.wool}));
    EntityRegistry.registerGlobalEntityID(
        EMatter.class, "ASParticle", EntityRegistry.findGlobalUniqueEntityId());
    EntityRegistry.registerModEntity(EMatter.class, "ASParticle", 49, this, 80,
                                     3, true);
    AtomicScience.CONFIGURATION.load();
    if (Loader.isModLoaded("IC2") &&
        AtomicScience.CONFIGURATION
            .get("general", "Disable IC2 Uranium Compression (Recommended)",
                 true)
            .getBoolean(true)) {
      try {
        // TODO: WTF
        // if (Recipes.compressor != null) {
        // Map e = Recipes.compressor.getRecipes();
        // Iterator it = e.entrySet().iterator();
        // int i = 0;

        // while (it.hasNext()) {
        // Entry entry = (Entry)it.next();
        // if (isUraniumOre((ItemStack)entry.getKey())) {
        // ++i;
        // it.remove();
        // }
        // }

        // LOGGER.fine(
        // "Removed " + i +
        // " IC2 uranium compression recipe, use centrifuge instead.");
        // }
      } catch (Exception var6) {
        LOGGER.fine("Failed to remove IC2 compressor recipes.");
        var6.printStackTrace();
      }
    }

    AtomicScience.CONFIGURATION.save();
  }

  public static boolean isCell(ItemStack itemStack) {
    return is(itemStack, "cellEmpty");
  }

  public static boolean isCellWater(ItemStack itemStack) {
    return is(itemStack, "cellWater");
  }

  public static boolean isUraniumOre(ItemStack itemStack) {
    return is(itemStack, "dropUranium", "oreUranium");
  }

  public static boolean isFusionFuel(ItemStack itemStack) {
    return is(itemStack, "molecule_1d", "molecule_1h2", "cellDeuterium");
  }

  public static boolean is(ItemStack itemStack, String... names) {
    if (itemStack != null && names != null && names.length > 0) {
      String name = OreDictionary.getOreName(OreDictionary.getOreID(itemStack));
      String[] arr$ = names;
      int len$ = names.length;

      for (int i$ = 0; i$ < len$; ++i$) {
        String compareName = arr$[i$];
        if (name.equals(compareName)) {
          return true;
        }
      }
    }

    return false;
  }

  public static void boilWater(World worldObj, Vector3 pos, int height,
                               int rpm) {
    Block blockID = pos.getBlock(worldObj);
    if (blockID == Blocks.flowing_water || blockID == Blocks.water) {
      if (!ALLOW_LAYERED_TURBINES) {
        height = 1;
      }

      if (worldObj.rand.nextInt(80) == 0) {
        worldObj.playSoundEffect(
            pos.x + 0.5D, pos.y + 0.5D, pos.z + 0.5D, "liquid.lava", 0.5F,
            2.1F + (worldObj.rand.nextFloat() - worldObj.rand.nextFloat()) *
                       0.85F);
      }

      if (worldObj.rand.nextInt(40) == 0) {
        worldObj.playSoundEffect(
            pos.x + 0.5D, pos.y + 0.5D, pos.z + 0.5D, "liquid.lavapop", 0.5F,
            2.6F +
                (worldObj.rand.nextFloat() - worldObj.rand.nextFloat()) * 0.8F);
      }

      worldObj.spawnParticle("bubble", pos.x + 0.5D,
                             pos.y + 0.20000000298023224D, pos.z + 0.5D, 0.0D,
                             0.0D, 0.0D);
      if (worldObj.rand.nextInt(5) == 0) {
        worldObj.spawnParticle("smoke", pos.x + 0.5D, pos.y + 0.5D,
                               pos.z + 0.5D, 0.0D, 0.0D, 0.0D);
      }

      for (int i = 1; i <= height; ++i) {
        TileEntity tileEntity =
            worldObj.getTileEntity(pos.intX(), pos.intY() + i, pos.intZ());
        if (tileEntity != null && tileEntity instanceof ISteamReceptor) {
          ((ISteamReceptor)tileEntity).onReceiveSteam(rpm);
          rpm /= 2;
        }
      }
    }
  }

  @SubscribeEvent
  @SideOnly(Side.CLIENT)
  public void textureHook(Post event) {
    // TODO: WTF
    // if (event.map == Minecraft.getMinecraft().renderEngine.field_94155_m) {

    FLUID_URANIUM_HEXAFLOURIDE.setIcons(
        event.map.registerIcon("atomicscience:uraniumHexafluoride"));
    // TODO: might override railcraft icon?
    FLUID_STEAM.setIcons(event.map.registerIcon("atomicscience:steam"));
    FLUID_TOXIC_WASTE.setIcons(
        event.map.registerIcon("atomicscience:toxicWaste"));
  }

  // TODO: WTF
  // @EventHandler public void serverStarting(FMLServerStartingEvent event) {
  // FlagRegistry.registerModFlag(
  // "ModFlags", new ModFlag(NBTFileLoader.loadData("ModFlags")));
  // ICommandManager commandManager = FMLCommonHandler.instance()
  // .getMinecraftServerInstance()
  // .getCommandManager();
  // ServerCommandManager serverCommandManager =
  // (ServerCommandManager)commandManager;
  // serverCommandManager.registerCommand(
  // new CommandFlag(FlagRegistry.getModFlag("ModFlags")));
  // }

  // TODO: WTF
  // @ForgeSubscribe
  // public void worldSave(Save evt) {
  // if (!evt.world.isRemote) {
  // NBTFileLoader.saveData("ModFlags",
  // FlagRegistry.getModFlag("ModFlags").getNBT());
  // }
  // }

  public static int getLiquidAmount(FluidStack liquid) {
    return liquid != null ? liquid.amount : 0;
  }

  static Fluid getOrRegisterFluid(String id) {
    FluidRegistry.registerFluid(new Fluid(id));

    return FluidRegistry.getFluid(id);
  }
}

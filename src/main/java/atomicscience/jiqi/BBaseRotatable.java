package atomicscience.jiqi;

import atomicscience.TabAS;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import universalelectricity.core.UniversalElectricity;
import universalelectricity.prefab.block.BlockRotatable;

public abstract class BBaseRotatable extends BlockRotatable {
  protected String textureName;

  // TODO: tilera failed porting this in BlockRotatable
  @Override
  public void onBlockPlacedBy(World world, int x, int y, int z,
                           EntityLivingBase entityLiving, ItemStack itemStack) {
    int angle = MathHelper.floor_double(
                    (double)(entityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) &
                3;
    byte change = 3;
    switch (angle) {
    case 0:
      change = 2;
      break;
    case 1:
      change = 5;
      break;
    case 2:
      change = 3;
      break;
    case 3:
      change = 4;
    }

    this.setDirection(world, x, y, z, ForgeDirection.getOrientation(change));
  }

  public BBaseRotatable(String name, Material material) {
    super(material);
    this.textureName = "atomicscience:machine";
    this.setBlockName("atomicscience:" + name);
    this.setCreativeTab(TabAS.INSTANCE);
  }

  public BBaseRotatable(String name) {
    this(name, UniversalElectricity.machine);
  }

  @Override
  public TileEntity createTileEntity(World world, int meta) {
    return this.createNewTileEntity(world, meta);
  }

  @Override
  @SideOnly(Side.CLIENT)
  public void registerBlockIcons(IIconRegister iconRegister) {
    if (this.getRenderType() == 0) {
      super.registerBlockIcons(iconRegister);
    } else {
      this.blockIcon = iconRegister.registerIcon(this.textureName);
    }
  }
}

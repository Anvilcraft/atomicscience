package atomicscience.jiqi;

import atomicscience.TabAS;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import universalelectricity.core.UniversalElectricity;
import universalelectricity.prefab.block.BlockRotatable;

public abstract class BBaseRotatable extends BlockRotatable {
   protected String textureName;

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
   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister iconRegister) {
      if(this.getRenderType() == 0) {
         super.registerBlockIcons(iconRegister);
      } else {
         this.blockIcon = iconRegister.registerIcon(this.textureName);
      }

   }
}

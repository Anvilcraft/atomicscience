package atomicscience.fenlie;

import atomicscience.jiqi.BBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;

public class BControlRod extends BBase {
  public BControlRod() {
    super("controlRod", Material.iron);
    this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 1.0F, 0.7F);
  }

  @Override
  @SideOnly(Side.CLIENT)
  public void registerBlockIcons(IIconRegister iconRegister) {
    this.blockIcon = iconRegister.registerIcon(
        Blocks.iron_block.getUnlocalizedName().replace("tile.", ""));
  }

  @Override
  public boolean renderAsNormalBlock() { return false; }

  @Override
  public boolean isOpaqueCube() { return false; }

  @Override
  public boolean hasTileEntity(int metadata) { return false; }
}

package atomicscience.hecheng;

import atomicscience.api.IElectromagnet;
import atomicscience.jiqi.BBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BElectromagnet extends BBase implements IElectromagnet {
  private IIcon iconTop;

  public BElectromagnet() { super("electromagnet"); }

  @Override
  public IIcon getIcon(int side, int metadata) {
    return side != 0 && side != 1 ? this.blockIcon : this.iconTop;
  }

  @Override
  @SideOnly(Side.CLIENT)
  public void registerBlockIcons(IIconRegister iconRegister) {
    super.registerBlockIcons(iconRegister);
    this.iconTop = iconRegister.registerIcon(
        this.getUnlocalizedName().replace("tile.", "") + "_top");
    this.blockIcon = iconRegister.registerIcon(
        this.getUnlocalizedName().replace("tile.", ""));
  }

  @Override
  public TileEntity createNewTileEntity(World var1, int meta) {
    return new TElectromagnet();
  }

  @Override
  public boolean isRunning(World world, int x, int y, int z) {
    return true;
  }
}

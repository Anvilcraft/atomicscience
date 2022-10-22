package atomicscience;

import basiccomponents.common.block.BlockCopperWire;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BSuperconductor extends BlockCopperWire {
  public BSuperconductor() {
    super();
    this.setBlockName("atomicscience:superconductor");
    this.setCreativeTab(TabAS.INSTANCE);
  }

  @Override
  public TileEntity createNewTileEntity(World var1, int meta) {
    return new TSuperconductor();
  }
}

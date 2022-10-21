package atomicscience.fanwusu;

import atomicscience.fanwusu.TFulminationGenerator;
import atomicscience.jiqi.BBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BFulminationGenerator extends BBase {

   public BFulminationGenerator() {
      super("fulmination");
      this.setHardness(50.0F);
   }

   public TileEntity createNewTileEntity(World world, int meta) {
      return new TFulminationGenerator();
   }
}

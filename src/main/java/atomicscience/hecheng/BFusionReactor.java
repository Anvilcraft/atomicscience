package atomicscience.hecheng;

import atomicscience.AtomicScience;
import atomicscience.jiqi.BBase;
import atomicscience.render.RH;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BFusionReactor extends BBase {

    public BFusionReactor() {
        super("fusionReactor");
    }

    @Override
    public boolean onMachineActivated(World world, int x, int y, int z,
            EntityPlayer entityPlayer, int side,
            float hitX, float hitY, float hitZ) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (entityPlayer.inventory.getCurrentItem() != null &&
                AtomicScience.isFusionFuel(entityPlayer.inventory.getCurrentItem())) {
            if (((TFusionReactor) tileEntity).getStackInSlot(0) != null) {
                ItemStack var10000 = ((TFusionReactor) tileEntity).getStackInSlot(0);
                var10000.stackSize += entityPlayer.inventory.getCurrentItem().stackSize;
            } else {
                ((TFusionReactor) tileEntity)
                        .setInventorySlotContents(0,
                                entityPlayer.inventory.getCurrentItem());
            }

            entityPlayer.inventory.setInventorySlotContents(
                    entityPlayer.inventory.currentItem, (ItemStack) null);
            return true;
        } else {
            return false;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderType() {
        return RH.BLOCK_RENDER_ID;
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int meta) {
        return new TFusionReactor();
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }
}

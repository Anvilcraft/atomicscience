package atomicscience.hecheng;

import atomicscience.AtomicScience;
import atomicscience.jiqi.TInventory;
import calclavia.lib.render.ITagRender;
import com.google.common.io.ByteArrayDataInput;
import java.util.HashMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import universalelectricity.core.block.IElectricityStorage;
import universalelectricity.core.electricity.ElectricityPack;
import universalelectricity.core.vector.Vector3;

public class TFusionReactor extends TInventory
        implements ISidedInventory, IElectricityStorage, ITagRender {

    public static final int YAO_DAO = 1000;
    public static final int YONG_DIAN = 20000;
    private ItemStack deuteriumStack = null;
    public float rotation = 0.0F;

    @Override
    public ElectricityPack getRequest() {
        return this.deuteriumStack != null
                ? new ElectricityPack(20000.0D / this.getVoltage(), this.getVoltage())
                : new ElectricityPack();
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
        if (!this.worldObj.isRemote) {
            if (!this.isDisabled() && super.wattsReceived >= 20000.0D &&
                    this.deuteriumStack != null && super.ticks % 20L == 0L) {
                for (int i = 2; i < 6; ++i) {
                    Vector3 diDian = new Vector3(this);
                    diDian.modifyPositionFromSide(ForgeDirection.getOrientation(i), 2.0D);
                    AtomicScience.bPlasma.spawn(this.worldObj, diDian.intX(),
                            diDian.intY(), diDian.intZ(),
                            (byte) 7);
                }

                this.setJoules(Math.max(super.wattsReceived - 20000.0D, 0.0D));
                if (this.worldObj.rand.nextInt(10) == 0) {
                    this.decrStackSize(0, 1);
                }
            }

            if (super.ticks % 80L == 0L) {
                this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
            }
        }
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setDouble("wattsReceived", super.wattsReceived);
        nbt.setInteger("stackSize", this.deuteriumStack != null
                ? this.deuteriumStack.stackSize
                : 0);

        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord,
                this.getBlockMetadata(), nbt);
    }

    // @Override
    // public void handlePacketData(INetworkManager network, int packetType,
    // Packet250CustomPayload packet,
    // EntityPlayer player,
    // ByteArrayDataInput dataStream) {
    // try {
    // super.wattsReceived = dataStream.readDouble();
    // this.setInventorySlotContents(
    // 0, new ItemStack(AtomicScience.itCellDao,
    // dataStream.readInt()));
    // } catch (Exception var7) {
    // var7.printStackTrace();
    // }
    // }

    @Override
    public void onDataPacket(NetworkManager arg0,
            S35PacketUpdateTileEntity arg1) {
        NBTTagCompound nbt = arg1.func_148857_g();
        super.wattsReceived = nbt.getDouble("wattsReceived");
        this.setInventorySlotContents(0,
                new ItemStack(AtomicScience.itCellDeuterium,
                        nbt.getInteger("stackSize")));
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        super.wattsReceived = nbt.getDouble("wattsReceived");
        this.deuteriumStack = new ItemStack(AtomicScience.itCellDeuterium,
                nbt.getInteger("stackSize"));
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setDouble("wattsReceived", super.wattsReceived);
        nbt.setInteger("stackSize", this.deuteriumStack != null
                ? this.deuteriumStack.stackSize
                : 0);
    }

    @Override
    public double getJoules() {
        return super.wattsReceived;
    }

    @Override
    public void setJoules(double joules) {
        super.wattsReceived = Math.max(Math.min(joules, this.getMaxJoules()), 0.0D);
    }

    @Override
    public double getMaxJoules() {
        return 20000.0D;
    }

    @Override
    public int getSizeInventory() {
        return 1;
    }

    @Override
    public ItemStack getStackInSlot(int var1) {
        return this.deuteriumStack != null && this.deuteriumStack.stackSize <= 0
                ? null
                : this.deuteriumStack;
    }

    @Override
    public ItemStack decrStackSize(int i, int amount) {
        if (this.deuteriumStack != null) {
            ItemStack itemstack;
            if (this.deuteriumStack.stackSize <= amount) {
                itemstack = this.deuteriumStack;
                this.deuteriumStack = null;
                return itemstack;
            } else {
                itemstack = this.deuteriumStack.splitStack(amount);
                if (this.deuteriumStack.stackSize == 0) {
                    this.deuteriumStack = null;
                }

                return itemstack;
            }
        } else {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int var1) {
        return this.deuteriumStack;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemStack) {
        this.deuteriumStack = itemStack;
    }

    @Override
    public int getInventoryStackLimit() {
        return 1000;
    }

    @Override
    public float addInformation(HashMap map, EntityPlayer player) {
        if (this.deuteriumStack != null) {
            map.put("Deuterium: " + this.deuteriumStack.stackSize,
                    Integer.valueOf(16777215));
        } else {
            map.put("No Deuterium", Integer.valueOf(16777215));
        }

        return 1.0F;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int var1) {
        return new int[] { 0 };
    }

    @Override
    public boolean isItemValidForSlot(int slotID, ItemStack itemStack) {
        return itemStack.getItem() == AtomicScience.itCellDeuterium;
    }

    @Override
    public boolean canInsertItem(int i, ItemStack itemstack, int j) {
        return this.isItemValidForSlot(i, itemstack);
    }

    @Override
    public boolean canExtractItem(int i, ItemStack itemstack, int j) {
        return this.isItemValidForSlot(i, itemstack);
    }
}

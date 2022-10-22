package atomicscience;

import basiccomponents.common.tileentity.TileEntityCopperWire;

public class TSuperconductor extends TileEntityCopperWire {
    @Override
    public double getResistance() {
        return 0;
    }

    @Override
    public double getCurrentCapcity() {
        return Double.MAX_VALUE;
    }
}

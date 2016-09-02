package com.paratus_software.emulators.chip8.internals.opcodes;

import com.paratus_software.emulators.chip8.internals.Registers;

/**
 * 8xy6 - SHR Vx {, Vy}
 * Set Vx = Vx SHR 1.
 *
 * If the least-significant bit of Vx is 1, then VF_Flag is set to 1, otherwise 0.
 * Then Vx is divided by 2.
 *
 * Created by arthur on 8/29/16.
 */
public class ShiftRight extends AbstractInstruction{
    @Override
    public void execute(int instruction) {
        if(leastSignificantBit(instruction) == 1){
            Registers.VF_Flag = 1;
        } else {
            Registers.VF_Flag = 0;
        }
        int vxIndex = x_lowestNibbleOfTheHighByte(instruction);
        int vx = Registers.find(vxIndex);
        Registers.setValue(vxIndex, (vx / 2));
    }
}

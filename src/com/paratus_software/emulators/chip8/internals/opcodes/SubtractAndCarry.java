package com.paratus_software.emulators.chip8.internals.opcodes;

import com.paratus_software.emulators.chip8.internals.Registers;

/**
 *
 * 8xy5 - SUB Vx, Vy
 * Set Vx = Vx - Vy, set VF = NOT borrow.
 *
 * If Vx > Vy, then VF is set to 1, otherwise 0.
 * Then Vy is subtracted from Vx, and the results stored in Vx.
 *
 * Created by arthur on 8/29/16.
 */
public class SubtractAndCarry extends AbstractInstruction {
    @Override
    public void execute(int instruction) {
        final int vxRegisterIndex = x_lowestNibbleOfTheHighByte(instruction);
        int vx = Registers.find(vxRegisterIndex);
        int vy = Registers.find(y_upperNibbleOfTheLowByte(instruction));
        int subtractedValue = vx - vy;
        Registers.setValue(vxRegisterIndex, subtractedValue);
        if(subtractedValue > vy){
            Registers.VF = 1;
        } else {
            Registers.VF = 0;
        }
    }
}

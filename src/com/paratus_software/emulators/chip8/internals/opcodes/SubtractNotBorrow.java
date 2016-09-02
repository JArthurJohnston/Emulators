package com.paratus_software.emulators.chip8.internals.opcodes;

import com.paratus_software.emulators.chip8.internals.Registers;

/**
 * 8xy7 - SUBN Vx, Vy
 * Set Vx = Vy - Vx, set VF_Flag = NOT borrow.
 *
 * If Vy > Vx, then VF_Flag is set to 1, otherwise 0.
 * Then Vx is subtracted from Vy, and the results stored in Vx
 *
 * Created by arthur on 8/31/16.
 */
public class SubtractNotBorrow extends AbstractInstruction{
    @Override
    public void execute(int instruction) {
        int xRegisterIndex = x_lowestNibbleOfTheHighByte(instruction);
        int vx = Registers.find(xRegisterIndex);
        int vy = Registers.find(y_upperNibbleOfTheLowByte(instruction));
        if(vy > vx){
            Registers.VF_Flag = 1;
        }
        int subbedValue = vx - vy;
        Registers.setValue(xRegisterIndex, subbedValue);
    }
}

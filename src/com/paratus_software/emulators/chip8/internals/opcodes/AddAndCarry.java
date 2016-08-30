package com.paratus_software.emulators.chip8.internals.opcodes;

import com.paratus_software.emulators.chip8.internals.Registers;

/**
 * 8xy4 - ADD Vx, Vy
 * Set Vx = Vx + Vy, set VF = carry.
 *
 * The values of Vx and Vy are added together.
 * If the result is greater than 8 bits (i.e., > 255,) VF is set to 1, otherwise 0.
 * Only the lowest 8 bits of the result are kept, and stored in Vx.
 *
 * Created by arthur on 8/29/16.
 */
public class AddAndCarry extends AbstractInstruction{
    @Override
    public void execute(int instruction) {
        final int vxRegisterIndex = x_lowestNibbleOfTheHighByte(instruction);
        int vx = Registers.find(vxRegisterIndex);
        int vy = Registers.find(y_upperNibbleOfTheLowByte(instruction));
        int addedValue = vx + vy;
        Registers.setValue(vxRegisterIndex, kk_lowestByte(addedValue));
        if(addedValue > 255){
            Registers.VF = 1;
        } else {
            Registers.VF = 0;
        }
    }
}

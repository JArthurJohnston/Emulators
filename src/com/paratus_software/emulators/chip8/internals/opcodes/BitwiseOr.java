package com.paratus_software.emulators.chip8.internals.opcodes;

import com.paratus_software.emulators.chip8.internals.Registers;

/**
 * 8xy1 - OR Vx, Vy
 * Set Vx = Vx OR Vy.

 * Performs a bitwise OR on the values of Vx and Vy,
 * then stores the result in Vx. A bitwise OR compares the corrseponding bits from two values,
 * and if either bit is 1, then the same bit in the result is also 1. Otherwise, it is 0.

 * Created by arthur on 8/29/16.
 */
public class BitwiseOr extends AbstractInstruction {
    @Override
    public void execute(int instruction) {
        final int vxRegisterIndex = x_lowestNibbleOfTheHighByte(instruction);
        int vx = Registers.find(vxRegisterIndex);
        int vy = Registers.find(y_upperNibbleOfTheLowByte(instruction));
        int oredValue = vx | vy;
        Registers.setValue(vxRegisterIndex, oredValue);
    }
}

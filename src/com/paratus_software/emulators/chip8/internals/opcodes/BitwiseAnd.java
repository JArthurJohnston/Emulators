package com.paratus_software.emulators.chip8.internals.opcodes;

import com.paratus_software.emulators.chip8.internals.Registers;

/**
 * 8xy2 - AND Vx, Vy
 * Set Vx = Vx AND Vy.
 *
 * Performs a bitwise AND on the values of Vx and Vy, then stores the result in Vx.
 * A bitwise AND compares the corrseponding bits from two values, and if both bits are 1,
 * then the same bit in the result is also 1. Otherwise, it is 0.
 *
 * Created by arthur on 8/29/16.
 */
public class BitwiseAnd extends AbstractInstruction {
    @Override
    public void execute(int instruction) {
        final int vxRegisterIndex = x_lowestNibbleOfTheHighByte(instruction);
        int vx = Registers.find(vxRegisterIndex);
        int vy = Registers.find(y_upperNibbleOfTheLowByte(instruction));
        int andedValue = vx & vy;
        Registers.setValue(vxRegisterIndex, andedValue);
    }
}

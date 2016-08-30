package com.paratus_software.emulators.chip8.internals.opcodes;

import com.paratus_software.emulators.chip8.internals.Registers;

/**
 * 8xy3 - XOR Vx, Vy
 * Set Vx = Vx XOR Vy.

 * Performs a bitwise exclusive OR on the values of Vx and Vy, then stores the result in Vx.
 * An exclusive OR compares the corrseponding bits from two values,
 * and if the bits are not both the same, then the corresponding bit in the result is set to 1.
 * Otherwise, it is 0.

 * Created by arthur on 8/29/16.
 */
public class BitwiseXOR extends AbstractInstruction {
    @Override
    public void execute(int instruction) {
        final int vxRegisterIndex = x_lowestNibbleOfTheHighByte(instruction);
        int vx = Registers.find(vxRegisterIndex);
        int vy = Registers.find(y_upperNibbleOfTheLowByte(instruction));
        int xoredValue = vx ^ vy;
        Registers.setValue(vxRegisterIndex, xoredValue);
    }
}

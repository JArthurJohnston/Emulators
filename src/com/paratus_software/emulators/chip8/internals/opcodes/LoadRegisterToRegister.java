package com.paratus_software.emulators.chip8.internals.opcodes;

import com.paratus_software.emulators.chip8.internals.Registers;

/**
 * 8xy0 - LD Vx, Vy
 * Set Vx = Vy.

 * Stores the value of register Vy in register Vx.
 * Created by arthur on 8/29/16.
 */
public class LoadRegisterToRegister extends AbstractInstruction {
    @Override
    public void execute(int instruction) {
        int value = Registers.find(y_upperNibbleOfTheLowByte(instruction));
        Registers.setValue(x_lowestNibbleOfTheHighByte(instruction), value);
    }
}

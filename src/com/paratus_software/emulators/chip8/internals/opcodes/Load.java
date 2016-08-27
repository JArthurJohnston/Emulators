package com.paratus_software.emulators.chip8.internals.opcodes;

import com.paratus_software.emulators.chip8.internals.Registers;

/**
 * 6xkk - LD Vx, byte
 * Set Vx = kk.

 * The interpreter puts the value kk into register Vx.
 * Created by arthur on 8/27/16.
 */
public class Load extends AbstractInstruction {
    @Override
    public void execute(int instruction) {
        Registers.setValue(x_lowestNibbleOfTheHighByte(instruction), kk_lowestByte(instruction));
    }
}

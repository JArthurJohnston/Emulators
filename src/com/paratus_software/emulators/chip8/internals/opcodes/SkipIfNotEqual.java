package com.paratus_software.emulators.chip8.internals.opcodes;

import com.paratus_software.emulators.chip8.internals.Registers;
import com.paratus_software.emulators.chip8.internals.Stack;

/**
 * 4xkk - SNE Vx, byte
 * SkipIfEqual next instruction if Vx = kk.

 * The interpreter compares register Vx to kk, and if they are not equal,
 * increments the program counter by 2.
 * Created by arthur on 8/27/16.
 */
public class SkipIfNotEqual extends AbstractInstruction {
    @Override
    public void execute(int instruction) {
        final int Vx = Registers.find(x_lowestNibbleOfTheHighByte(instruction));
        final int kk = kk_lowestByte(instruction);
        if(Vx != kk){
            Registers.ProgramCouter += 2;
        }
    }
}

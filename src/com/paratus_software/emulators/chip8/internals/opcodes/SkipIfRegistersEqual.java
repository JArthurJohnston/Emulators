package com.paratus_software.emulators.chip8.internals.opcodes;

import com.paratus_software.emulators.chip8.internals.Registers;
import com.paratus_software.emulators.chip8.internals.Stack;

/**
 * 5xy0 - SE Vx, Vy
 * Skip next instruction if Vx = Vy.

 * The interpreter compares register Vx to register Vy,
 * and if they are equal, increments the program counter by 2.
 * Created by arthur on 8/27/16.
 */
public class SkipIfRegistersEqual extends AbstractInstruction {
    @Override
    public void execute(int instruction) {
        final int Vx = Registers.find(x_lowestNibbleOfTheHighByte(instruction));
        final int Vy = Registers.find(y_upperNibbleOfTheLowByte(instruction));
        if(Vx == Vy){
            Registers.ProgramCouter += 2;
        }
    }
}

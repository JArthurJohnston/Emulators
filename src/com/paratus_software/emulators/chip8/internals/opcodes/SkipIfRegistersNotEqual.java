package com.paratus_software.emulators.chip8.internals.opcodes;

import com.paratus_software.emulators.chip8.internals.Registers;

/**
 * 9xy0 - SNE Vx, Vy
 * Skip next instruction if Vx != Vy.
 *
 * The values of Vx and Vy are compared, and if they are not equal, the program counter is increased by 2
 * Created by arthur on 8/31/16.
 */
public class SkipIfRegistersNotEqual extends AbstractInstruction {
    @Override
    public void execute(int instruction) {
        int vx = Registers.find(x_lowestNibbleOfTheHighByte(instruction));
        int vy = Registers.find(y_upperNibbleOfTheLowByte(instruction));

        if(vx != vy){
            Registers.ProgramCouter += 2;
        }

    }
}

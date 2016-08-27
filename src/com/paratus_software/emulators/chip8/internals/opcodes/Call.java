package com.paratus_software.emulators.chip8.internals.opcodes;

import com.paratus_software.emulators.chip8.internals.Registers;
import com.paratus_software.emulators.chip8.internals.Stack;

/**
 * 2nnn - CALL addr
 * Call subroutine at nnn.

 * The interpreter increments the stack pointer,
 * then puts the current PC on the top of the stack.
 * The PC is then set to nnn.
 *
 * Created by arthur on 8/27/16.
 */
public class Call extends AbstractInstruction {
    @Override
    public void execute(int instruction) {
        Stack.increment();
        Stack.setValue(Registers.ProgramCouter);
        Registers.ProgramCouter = nnn_lowest12Bits(instruction);
    }
}

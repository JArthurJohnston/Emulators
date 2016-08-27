package com.paratus_software.emulators.chip8.internals.opcodes;

import com.paratus_software.emulators.chip8.internals.Registers;
import com.paratus_software.emulators.chip8.internals.Stack;

/**
 * 00EE - RET
 * Return from a subroutine.

 * The interpreter sets the program counter to the address at the top of the stack,
 * then subtracts 1 from the stack pointer.
 * Created by arthur on 8/27/16.
 */
public class Return extends AbstractInstruction{

    @Override
    public void execute(int instruction) {
        Registers.ProgramCouter = Stack.getValue();
        Stack.decrement();
    }
}

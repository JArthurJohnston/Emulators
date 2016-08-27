package com.paratus_software.emulators.chip8.internals.opcodes;

import com.paratus_software.emulators.chip8.internals.Registers;

/**
 * 1nnn - JP addr
 * Jump to location nnn.

 * The interpreter sets the program counter to nnn.

 * Created by arthur on 8/27/16.
 */
public class Jump extends AbstractInstruction {
    @Override
    public void execute(int instruction) {
        Registers.ProgramCouter = nnn_lowest12Bits(instruction);
    }
}

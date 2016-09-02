package com.paratus_software.emulators.chip8.internals.opcodes;

import com.paratus_software.emulators.chip8.internals.Registers;

/**
 * Bnnn - JP V0, addr
 * Jump to location nnn + V0.
 *
 * The program counter is set to nnn plus the value of V0
 * Created by arthur on 9/1/16.
 */
public class JumpToAddress extends AbstractInstruction {
    @Override
    public void execute(int instruction) {
        int nnn = nnn_lowest12Bits(instruction);
        int v0Value = Registers.find(0);

        Registers.ProgramCouter = nnn + v0Value;
    }
}

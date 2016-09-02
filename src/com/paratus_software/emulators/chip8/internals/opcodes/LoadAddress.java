package com.paratus_software.emulators.chip8.internals.opcodes;

import com.paratus_software.emulators.chip8.internals.Registers;

/**
 * Annn - LD I, addr
 * Set I = nnn.
 *
 * The value of register I is set to nnn.
 * Created by arthur on 8/31/16.
 */
public class LoadAddress extends AbstractInstruction {
    @Override
    public void execute(int instruction) {
        Registers.I_AddressRegister = nnn_lowest12Bits(instruction);
    }
}

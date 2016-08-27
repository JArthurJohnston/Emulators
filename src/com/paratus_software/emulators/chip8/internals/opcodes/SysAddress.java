package com.paratus_software.emulators.chip8.internals.opcodes;

/**
 * 0nnn - SYS addr
 * SysAddress to a machine code routine at nnn.
 * This instruction is only used on the old computers on which Chip-8 was originally implemented.
 * It is ignored by modern interpreters.
 */
public class SysAddress implements OpcodeInterface {
    @Override
    public void execute(int instruction) {
        //NOP
    }
}

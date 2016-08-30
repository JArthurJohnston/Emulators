package com.paratus_software.emulators.chip8.internals.opcodes;

/**
 * The original implementation of the Chip-8 language includes 36 different instructions,
 * including math, graphics, and flow control functions
 *
 * In these listings, the following variables are used:

 * nnn or addr - A 12-bit value, the lowest 12 bits of the instruction
 * n or nibble - A 4-bit value, the lowest 4 bits of the instruction
 * x - A 4-bit value, the lower 4 bits of the high byte of the instruction
 * y - A 4-bit value, the upper 4 bits of the low byte of the instruction
 * kk or byte - An 8-bit value, the lowest 8 bits of the instruction
 *
 * Created by arthur on 8/23/16.
 */
public abstract class AbstractInstruction implements OpcodeInterface {

    /**
     * nnn or addr - A 12-bit value, the lowest 12 bits of the instruction
     * @param instruction
     * @return nnn
     */
    protected static int nnn_lowest12Bits(int instruction){
        return instruction >> 4;
    }

    /**
     * n or nibble - A 4-bit value, the lowest 4 bits of the instruction
     * @param instruction
     * @return n
     */
    protected static int n_lowestNibble(int instruction){
        return instruction >> 12;
    }

    /**
     * x - A 4-bit value, the lower 4 bits of the high byte of the instruction
     * @param instruction
     * @return x
     */
    protected static int x_lowestNibbleOfTheHighByte(int instruction){
        return (instruction & 0x0F00) >> 8;
    }

    /**
     * y - A 4-bit value, the upper 4 bits of the low byte of the instruction
     * @param instruction
     * @return y
     */
    protected static int y_upperNibbleOfTheLowByte(int instruction){
        return (instruction & 0x00F0) >> 4;
    }

    /**
     * kk or byte - An 8-bit value, the lowest 8 bits of the instruction
     * @param instruction
     * @return kk
     */
    protected static int kk_lowestByte(int instruction){
        return instruction & 0x00FF;
    }

    protected static int leastSignificantBit(int instruction){
        return instruction & 1;
    }
}

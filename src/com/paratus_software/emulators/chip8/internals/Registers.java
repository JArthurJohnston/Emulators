package com.paratus_software.emulators.chip8.internals;

/**
 * This includes all the Chip 8 registers and counters, initialized to their
 * proper starting values
 * Created by arthur on 8/13/16.
 */
public final class Registers {
    private static int[] registers = new int[15];
    /**
     * CHIP-8 has 16 8-bit data registers named from V0 to VF. The VF register doubles as a carry flag.
     */

    public static int find(int index){
        return registers[index];
    }

    public static void setValue(int index, int value){
        registers[index] = value;
    }


    // The 16th register is used  for the ‘carry flag’.
    public static int VF;

    /**
     * The address register,
     * which is named I, is 16 bits wide and is used with several opcodes that involve memory operations.
     */

    public static int I;
    public static int ProgramCouter = 0x200;

    public static int delayTimer;
    public static int soundTimer;

    public static int[] keys = new int[16];

}

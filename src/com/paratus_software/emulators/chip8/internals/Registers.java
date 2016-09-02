package com.paratus_software.emulators.chip8.internals;

/**
 * This includes all the Chip 8 registers and counters, initialized to their
 * proper starting values
 * Created by arthur on 8/13/16.
 */
public final class Registers {

    /**
     * CHIP-8 has 16 8-bit data registers named from V0 to VF. The VF register doubles as a carry flag.
     */
    private static int[] registers = new int[15];
    public static int VF_Flag;

    public static int find(int index){
        return registers[index];
    }

    public static void setValue(int index, int value){
        registers[index] = value;
    }

    /**
     * The address register,
     * which is named I_AddressRegister, is 16 bits wide and is used with several opcodes that involve memory operations.
     */

    public static int I_AddressRegister;
    public static int ProgramCouter = 0x200;

    public static int delayTimer;
    public static int soundTimer;

    public static int[] keys = new int[16];

}

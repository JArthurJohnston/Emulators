package com.paratus_software.emulators.chip8.internals;

/**
 * Created by arthur on 8/13/16.
 */
public final class Registers {
    /**
     * CHIP-8 has 16 8-bit data registers named from V0 to VF. The VF register doubles as a carry flag.
     */
    public static int V0;
    public static int V1;
    public static int V2;
    public static int V3;
    public static int V4;
    public static int V5;
    public static int V6;
    public static int V7;
    public static int V8;
    public static int V9;
    public static int VA;
    public static int VB;
    public static int VC;
    public static int VD;
    public static int VE;

    // The 16th register is used  for the ‘carry flag’.
    public static int VF;

    /**
     * The address register,
     * which is named I, is 16 bits wide and is used with several opcodes that involve memory operations.
     */

    public static int I;
    public static int ProgramCouter;

    public static int delayTimer;
    public static int soundTimer;

    public static int[] keys = new int[16];

    public static void initialize(){
        //all java ints init to 0 by ddefault
        //set program counter to the beginning of memory used by the game

    }
}

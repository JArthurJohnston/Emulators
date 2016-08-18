package com.paratus_software.emulators.chip8.internals;

/**
 * Created by arthur on 8/13/16.
 */
public final class Registers {
    /**
     * CHIP-8 has 16 8-bit data registers named from V0 to VF. The VF register doubles as a carry flag.
     */
    public static short V0;
    public static short V1;
    public static short V2;
    public static short V3;
    public static short V4;
    public static short V5;
    public static short V6;
    public static short V7;
    public static short V8;
    public static short V9;
    public static short VA;
    public static short VB;
    public static short VC;
    public static short VD;
    public static short VE;
    public static short VF;

    /**
     * The address register,
     * which is named I, is 16 bits wide and is used with several opcodes that involve memory operations.
     */

    public static short I;
    public static short ProgramCouter;

    public static short delayTimer;
    public static short soundTimer;

    public static short[] keys = new short[16];
}

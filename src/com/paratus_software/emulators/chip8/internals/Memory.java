package com.paratus_software.emulators.chip8.internals;

/**
 * These machines had 4096 (0x1000) memory locations,
 * all of which are 8 bits (a byte) which is where the term CHIP-8 originated.
 *
 * the CHIP-8 interpreter itself occupies the first 512 bytes of the memory space on these machines.
 * For this reason, most programs written for the original system begin at memory location 512 (0x200)
 * and do not access any of the memory below the location 512 (0x200).
 * The uppermost 256 bytes (0xF00-0xFFF) are reserved for display refresh,
 * and the 96 bytes below that (0xEA0-0xEFF) were reserved for call stack, internal use, and other variables.
 *
 *
 * Created by arthur on 8/13/16.
 */
public class Memory {

    private char[] memory;


    public Memory(){
        memory = new char[4096];
    }

    public char read(int pointer){
        return memory[pointer];
    }

}

package com.paratus_software.emulators.chip8.loop;

import com.paratus_software.emulators.chip8.internals.Memory;
import com.paratus_software.emulators.chip8.internals.Registers;
import com.paratus_software.emulators.chip8.internals.Stack;

/**
 * Created by arthur on 8/13/16.
 */
public class Chip8Emulator {

    private Stack stack;
    private Memory memory;

    public Chip8Emulator(){
        stack = new Stack();
        memory = new Memory();
    }

    public void startGame(){

    }

    /**
     * the system will fetch one opcode from the memory at the location specified by the program counter (pc).
     * In our Chip 8 emulator, data is stored in an array in which each address contains one byte.
     * As one opcode is 2 bytes long,
     * we will need to fetch two successive bytes and merge them to get the actual opcode.
     *
     * In order to merge both bytes we will use the bitwise OR operation
     * @return
     */
    public int fetchOpcode(){
        char firstValue  = memory.read(Registers.ProgramCouter);
        char secondValue = memory.read(Registers.ProgramCouter + 1);
        int opcode = firstValue << 8 | secondValue;
        //firstValue << 8 shifts the bits 8 positions to the left, adding 0 zeroes
        // | secondValue then ORs them together
        return opcode;
    }

}

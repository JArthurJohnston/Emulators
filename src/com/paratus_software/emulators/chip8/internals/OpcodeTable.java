package com.paratus_software.emulators.chip8.internals;

import com.paratus_software.emulators.gameboy.cpu.Register;

import java.util.Map;

/**
 All instructions are 2 bytes long and are stored most-significant-byte first.
 In memory,
 Ignore: <the first byte of each instruction should be located at an even addresses.
 <If a program includes sprite data, it should be padded so any instructions following
 <it will be properly situated in RAM.

 * In these listings, the following variables are used:
    nnn or addr - A 12-bit value, the lowest 12 bits of the instruction
    n or nibble - A 4-bit value, the lowest 4 bits of the instruction
    x - A 4-bit value, the lower 4 bits of the high byte of the instruction
    y - A 4-bit value, the upper 4 bits of the low byte of the instruction
    kk or byte - An 8-bit value, the lowest 8 bits of the instruction

 * Created by arthur on 8/14/16.
 */
public class OpcodeTable {
    private final SubroutineInterface[] opcodes;

    public OpcodeTable(){
        opcodes = new SubroutineInterface[Integer.MAX_VALUE];
        initOpcodes();
    }

    private SubroutineInterface getOpcode(int index){
        return opcodes[index];
    }

    private void initOpcodes(){
        initZeroBasedOpcodes();
        initOneBasedOpcodes();
        initZeroBasedOpcodes();
    }

    private void initZeroBasedOpcodes(){
        opcodes[0x00E0] = new SubroutineInterface() {
            @Override
            public void execute() {
                //clear the display
            }
        };
        opcodes[0x00EE] = new SubroutineInterface() {
            @Override
            public void execute() {
                //return from a subroutine
            }
        };
    }

    /**
     * 3xkk - SE Vx, byte
     SkipIfEqual next instruction if Vx = kk.

     The interpreter compares register Vx to kk, and if they are equal, increments the program counter by 2.
     */
    private void initThreeBasedOpcodes(){

    }

    /**
     *
     1nnn - JP addr
     SysAddress to location nnn.
     */
    private void initOneBasedOpcodes(){
        for(int i = 0x1000; i <= 0x1FFF; i++){
            //need to grab the lowest 12 bits from i and pass it to the JumpSubroutine

            //for debugging
            if(opcodes[i] != null){
                throw new Error("Overwriting existing opcode!!!!!");
            }
            opcodes[i] = new JumpSubroutine(i & 0x0FFF);
        }
    }
    /**
     *
     2nnn - CALL addr
     Call subroutine at nnn.

     The interpreter increments the stack pointer,
     then puts the current PC on the top of the stack. The PC is then set to nnn.
     */
    private void initTwoBasedOpcodes(){
        for(int i = 0x2000; i <= 0x2FFF; i++){
            //need to grab the lowest 12 bits from i and pass it to the Subroutine

            //for debugging
            if(opcodes[i] != null){
                throw new Error("Overwriting existing opcode!!!!!");
            }
            opcodes[i] = new CallSubroutine(i & 0x0FFF);
        }
    }



    private interface SubroutineInterface {
        void execute();
    }

    private class JumpSubroutine implements SubroutineInterface {
        private int addressToJumpTo;
        JumpSubroutine(int address){
            addressToJumpTo = address;
        }

        @Override
        public void execute() {
            Registers.ProgramCouter = addressToJumpTo;
        }
    }

    private class CallSubroutine implements SubroutineInterface {
        private int value;
        CallSubroutine(int value){
            this.value = value;
        }

        @Override
        public void execute() {
            Stack.increment();
            Stack.setValue(Registers.ProgramCouter);
            Registers.ProgramCouter = this.value;
        }
    }

    private class CompareSubroutine implements SubroutineInterface {
        private int value;

        CompareSubroutine(int value){
            this.value = value;
        }

        @Override
        public void execute() {
        }
    }
}

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
    }

    private SubroutineInterface getOpcode(int index){
        return opcodes[index];
    }

    private SubroutineInterface[] initOpcodes(){
        return new SubroutineInterface[]{
                new SubroutineInterface() {
                    @Override
                    public void execute() {
                        //00E0 - CLS
                        //Clear the display

                    }
                },
                new SubroutineInterface() {
                    @Override
                    public void execute() {
                        /*00EE - RET
                        Return from a subroutine.
                        The interpreter sets the program counter to the address at the top of the stack,
                        then subtracts 1 from the stack pointer.
                         */

                    }
                },
                new SubroutineInterface() {
                    @Override
                    public void execute() {
                        //6XNN 	Store number NN in register VX

                    }
                }
        };
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
     *
     1nnn - JP addr
     Jump to location nnn.
     */
    private void initOneBasedOpcodes(){
        for(int i = 0x1000; i < 0x1FFF; i++){
            //need to grab the lowest 12 bits from i and pass it to the JumpSubroutine
            opcodes[i] = new JumpSubroutine(i & 0x0FFF);
        }
    }

    private SubroutineInterface jumpSubroutine(final int address){
        return new SubroutineInterface() {
            @Override
            public void execute() {
                Registers.ProgramCouter = address;
            }
        };
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
}

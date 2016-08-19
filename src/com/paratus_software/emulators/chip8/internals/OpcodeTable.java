package com.paratus_software.emulators.chip8.internals;

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
    private SubroutineInterface[] opcodes;

    public OpcodeTable(){
        opcodes = initOpcodes();
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


    private interface SubroutineInterface {
        void execute();
    }
}

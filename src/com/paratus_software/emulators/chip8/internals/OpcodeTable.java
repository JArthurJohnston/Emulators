package com.paratus_software.emulators.chip8.internals;

/**
 * Created by arthur on 8/14/16.
 */
public class OpcodeTable {
    private OpcodeInterface[] opcodes;

    public OpcodeTable(){
        opcodes = initOpcodes();
    }

    private OpcodeInterface getOpcode(int index){
        return opcodes[index];
    }

    private OpcodeInterface[] initOpcodes(){
        return new OpcodeInterface[]{};
    }


    private interface OpcodeInterface {
        void execute();
    }
}

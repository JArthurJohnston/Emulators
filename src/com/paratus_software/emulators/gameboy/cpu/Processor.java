package com.paratus_software.emulators.gameboy.cpu;


import com.paratus_software.emulators.gameboy.memory.MMUInterface;

/**
 * Created by arthur on 8/10/16.
 */
public class Processor {

    private Clock clock;
    private MMUInterface memoryManager;
    private OpcodeInterface[] opcodes;

    public Processor(){
        clock = new Clock();
        opcodes = initOpcodes();
    }

    public void nop(){
        Register.M.set(1);
        Register.T.set(4);
    }

    public void load(Register register, byte value){
        register.set(value);
        Register.T.set(8);
    }

    private OpcodeInterface[] initOpcodes(){

        return new OpcodeInterface[]{
//                () -> Processor.this.nop(),
//                () -> {
//                    //LD BC,nn
//                    int valueAtStack = memoryManager.readByteAt(Register.StackPointer);
//                    int valueAtStackPlusOne = memoryManager.readByteAt(Register.StackPointer.get() + 1);
//
//                    Register.C.set(valueAtStack);
//                    Register.B.set(valueAtStackPlusOne);
//                    Register.ProgramCounter.increment(2);
//
//                    Register.M.set(3);
//                    Register.T.set(12);
//                },
//                () -> {
//                    //LD (BC), A
//                    memoryManager.writeByteTo(RegisterPairs.BC, Register.A);
//
//                    Register.M.set(2);
//                    Register.T.set(8);
//                },
//                () -> {}
        };
    }


    public OpcodeInterface[] getOpcodes() {
        return this.opcodes;
    }
}

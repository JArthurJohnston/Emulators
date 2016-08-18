package com.paratus_software.emulators.chip8.internals;

/**
 * Created by arthur on 8/14/16.
 */
public class Stack {
    private char[] stackMemory;
    private int stackPointer;

    public Stack(){
        stackMemory = new char[16];
        stackPointer = 0;
    }


}

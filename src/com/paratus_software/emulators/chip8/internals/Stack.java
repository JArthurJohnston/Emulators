package com.paratus_software.emulators.chip8.internals;

/**
 * Created by arthur on 8/14/16.
 */
public class Stack {
    private static char[] stackMemory = new char[16];
    private static int stackPointer = 0;

    public static void setPointerTo(int index){
        stackPointer = index;
    }

    public static void increment(){
        stackPointer++;
    }

    public static char getValue(){
        return stackMemory[stackPointer];
    }

    public static void setValue(char value){
        stackMemory[stackPointer] = value;
    }


}

package com.paratus_software.emulators.chip8.internals;

/**
 * Created by arthur on 8/14/16.
 */
public class Stack {
    private static int[] stackMemory = new int[16];
    private static int stackPointer = 0;

    public static void setPointerTo(int index){
        stackPointer = index;
    }

    public static void increment(){
        stackPointer++;
    }

    public static int getValue(){
        return stackMemory[stackPointer];
    }

    public static void setValue(int value){
        stackMemory[stackPointer] = value;
    }

    public static void decrement() {
        stackPointer--;
    }
}

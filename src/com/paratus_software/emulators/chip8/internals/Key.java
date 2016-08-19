package com.paratus_software.emulators.chip8.internals;

/**
 *  Chip 8 has a HEX based keypad (0x0-0xF), you can use an array to store the current state of the key.
 * Created by arthur on 8/18/16.
 */
public class Key {
    private int[] keys;

    public Key(){
        keys = new int[16];
    }
}

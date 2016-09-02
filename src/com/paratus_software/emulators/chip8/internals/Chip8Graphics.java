package com.paratus_software.emulators.chip8.internals;

import java.awt.*;

/**
 * The graphics system: The chip 8 has one instruction that draws sprite to the screen.
 * Drawing is done in XOR mode and if a pixel is turned off as a result of drawing,
 * the VF_Flag register is set. This is used for collision detection.
 *
 * The graphics of the Chip 8 are black and white and the screen has a total of 2048 pixels (64 x 32).
 * This can easily be implemented using an array that hold the pixel state (1 or 0)
 *
 * Created by arthur on 8/14/16.
 */
public class Chip8Graphics {
    private char[] graphics;
    private Canvas screen;

    public Chip8Graphics(){
        graphics = new char[32 * 64];
        screen = new Canvas();
    }
}

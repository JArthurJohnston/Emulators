package com.paratus_software.emulators.chip8.internals.opcodes;

import com.paratus_software.emulators.chip8.internals.Registers;

import java.util.Random;

/**
 *
 * Cxkk - RND Vx, byte
 * Set Vx = random byte AND kk.
 *
 * The interpreter generates a random number from 0 to 255,
 * which is then ANDed with the value kk. The results are stored in Vx.
 *
 * See instruction 8xy2 for more information on AND.
 * Created by arthur on 9/2/16.
 */
public class RandomNumber extends AbstractInstruction {

    private static Random randomizer = new Random();
    @Override
    public void execute(int instruction) {
        int randomNumber = randomizer.nextInt(256);
        int kk = kk_lowestByte(instruction);
        Registers.setValue(x_lowestNibbleOfTheHighByte(instruction), (kk & randomNumber));
    }
}

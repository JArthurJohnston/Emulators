package com.paratus_software.emulators.chip8.internals.opcodes;

import com.paratus_software.emulators.chip8.internals.Registers;
import com.paratus_software.emulators.gameboy.cpu.Register;

/**
 *
 7xkk - ADD Vx, byte
 Set Vx = Vx + kk.

 Adds the value kk to the value of register Vx, then stores the result in Vx.
 * Created by arthur on 8/27/16.
 */
public class Add extends AbstractInstruction {
    @Override
    public void execute(int instruction) {
        final int x = x_lowestNibbleOfTheHighByte(instruction);
        int sum = Registers.find(x) + kk_lowestByte(instruction);
        Registers.setValue(x, sum);
    }
}

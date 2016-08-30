package com.paratus_software.emulators.chip8.internals.opcodes;

/**
 * 8xy6 - SHR Vx {, Vy}
 * Set Vx = Vx SHR 1.
 *
 * If the least-significant bit of Vx is 1, then VF is set to 1, otherwise 0.
 * Then Vx is divided by 2.
 *
 * Created by arthur on 8/29/16.
 */
public class Shift extends AbstractInstruction{
    @Override
    public void execute(int instruction) {

    }
}

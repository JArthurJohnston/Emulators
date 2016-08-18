package com.paratus_software.emulators.gameboy.memory;

import com.paratus_software.emulators.gameboy.cpu.Register;
import com.paratus_software.emulators.gameboy.cpu.RegisterPairs;

/**
 * Created by arthur on 8/10/16.
 */
public interface MMUInterface {

    int readByteAt(int address);
    int readByteAt(Register address);

    int readWordAt(int address);
    int readWordAt(Register address);

    void writeByteTo(RegisterPairs pair, Register reg);
    void writeByteTo(int address, int value);

    void writeWordTo(int address, int value);
    void writeWordTo(RegisterPairs pair, Register reg);
}

package com.paratus_software.emulators.gameboy.memory;

import com.paratus_software.GBEmulator.cpu.Register;
import com.paratus_software.GBEmulator.cpu.RegisterPairs;

/**
 * Created by arthur on 8/10/16.
 */
public class MemoryManagementUnit implements MMUInterface{
    @Override
    public int readByteAt(int address) {
        return 0;
    }

    @Override
    public int readByteAt(Register address) {
        return readByteAt(address.get());
    }

    @Override
    public int readWordAt(int address) {
        return 0;
    }

    @Override
    public int readWordAt(Register address) {
        return readWordAt(address.get());
    }

    @Override
    public void writeByteTo(RegisterPairs pair, Register reg) {
        writeByteTo(pair.value(), reg.get());
    }

    @Override
    public void writeByteTo(int address, int value) {
    }

    @Override
    public void writeWordTo(int address, int value) {
    }

    @Override
    public void writeWordTo(RegisterPairs pair, Register reg) {
        writeWordTo(pair.value(), reg.get());
    }
}

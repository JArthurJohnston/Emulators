package com.paratus_software.emulators.gameboy.cpu;

/**
 * Some instructions allow you to use the
 registers A,B,C,D,E,H, & L as 16-bit registers by
 pairing them up in the following manner: AF,BC,DE, & HL

 * Created by arthur on 8/12/16.
 */
public enum RegisterPairs {
    AF(Register.A, Register.F),
    BC(Register.B, Register.C),
    DE(Register.D, Register.E),
    HL(Register.H, Register.L);

    RegisterPairs(Register first, Register second){
        this.first = first;
        this.second = second;
    }

    private Register first;
    private Register second;

    public int value(){
        return first.get() + second.get();
    }

    public void set(int sixteenBitValue){
        //split 16 bit value into 2 8 bit values
        //set them to first and second
    }
}

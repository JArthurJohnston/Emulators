package com.paratus_software.emulators.gameboy.cpu;

/**
 * Created by arthur on 8/6/16.
 */
public enum Register {

    //8-Bit registers
    A, B, C, D, E, H, L, F, M, T,

    //16-Bit registers
    StackPointer, ProgramCounter,

    /**
     * Flag Register
     *  7 6 5 4 3 2 1 0
        Z N H C 0 0 0 0

     * see the Flag Enum (Below)
     */
    Z;

    private int value;
//    private BitSet value;

    public void set(int value){
        this.value = value;
    }

    public void setFlag(Flag flag){
        this.value += flag.value;
    }

    public void resetFlag(Flag flag){
        this.value -= flag.value;
    }

    public void increment(){
        if(this.value > 255){
            this.value = 0;
        } else {
            this.value++;
        }
        Register.Z.resetFlag(Flag.N_SUBTRACT);
        if(this.value == 0){
            Register.Z.setFlag(Flag.Z_ZERO);
        }
    }

    public void increment(int incValue){
        this.value += incValue;
    }

    public void decrement(){
        this.value--;
    }

    public void decrement(int decValue){
        this.value -= decValue;
    }

    /**
     * CP n (n being this.value)
     * Compare A with n. This is basically an A - n
     * subtraction instruction but the results are thrown
     * away.
     *
     * Z - Set if result is zero. (Set if A = n.)
     * N - Set.
     * H - Set if no borrow from bit 4.
     * C - Set for no borrow. (Set if A < n.)
     */
    public void compare(){
        int comparison = Integer.compare(A.get(), this.value);
        Z.setFlag(Flag.N_SUBTRACT);
        if(comparison == 0){
            Z.setFlag(Flag.Z_ZERO);
        } else if( comparison > 0){
            Z.setFlag(Flag.C_CARRY);
        } else {
            Z.setFlag(Flag.H_HALF_CARRY);
        }
    }

    public int get(){
        return (byte)this.value;
    }

    private enum Flag {
        /**
         * Zero Flag (Z):
         This bit is set when the result of a math operation
         is zero or two values match when using the CP
         instruction
         */
        Z_ZERO(0x08),
        /**
         * Subtract Flag (N):
         This bit is set if a subtraction was performed in the
         last math instruction
         */
        N_SUBTRACT(0x40),
        /**
         * Half Carry Flag (H):
         This bit is set if a carry occurred from the lower
         nibble in the last math operation.
         */
        H_HALF_CARRY(0x20),
        /**
         * Carry Flag (C):
         This bit is set if a carry occurred from the last
         math operation or if register A is the smaller value
         when executing the CP instruction.
         */
        C_CARRY(0x10);

        final private int value;

        Flag(int value){
            this.value = value;
        }

    }

}

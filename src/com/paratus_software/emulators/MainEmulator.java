package com.paratus_software.emulators;

/**
 * Created by arthur on 8/18/16.
 */
public class MainEmulator {

    public static void main(String[] args){

        RomFile rom = new RomFile("/home/arthur/IdeaProjects/Emulators/res/roms/BRIX");
        rom.printFile();

    }
}

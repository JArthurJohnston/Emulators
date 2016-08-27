package com.paratus_software.emulators;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * RomFile loads a rom into memory
 *
 * Created by arthur on 8/22/16.
 */
public class RomFile {

    private File binaryFile;
    private byte[] inMemoryRom;

    public RomFile(String filename){
        binaryFile = new File(filename);
        readInRomFile();
    }

    private void readInRomFile() {
        try {
            FileInputStream binaryStream = new FileInputStream(binaryFile);
            createInMemoryBuffer();
            inMemoryRom = createInMemoryBuffer();
            binaryStream.read(inMemoryRom);
            binaryStream.close();
        } catch (IOException e) {
            inMemoryRom = new byte[0];
            e.printStackTrace();
        }
    }

    private byte[] createInMemoryBuffer() {
        int romSize = (int)binaryFile.length();
        return new byte[romSize];
    }

    private byte[] GetRomMemory(){
        return inMemoryRom;
    }

    /**
     * For debugging purposes
     */
    public void printFile(){
        System.out.println("File length: " + inMemoryRom.length);
        for(int i=0; i< inMemoryRom.length; i++)
            System.out.print(inMemoryRom[i]);
    }
}

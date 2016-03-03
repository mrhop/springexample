package com.hopever.springexample.integration.file;

import java.io.File;

/**
 * Created by Donghui Huo on 2016/3/3.
 */
public class Handler {
    public String handleString(String input) {
        System.out.println("Copying text: " + input);
        return input.toLowerCase();
    }

    public File handleFile(File input) {
        System.out.println("Copying file: " + input.getAbsolutePath());
        return input;
    }

    public byte[] handleBytes(byte[] input) {
        System.out.println("Copying " + input.length + " bytes ...");
        return new String(input).toUpperCase().getBytes();
    }

}

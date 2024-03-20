/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a2_2101140073;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PCFactory {
    private static PCFactory instance;

    private PCFactory() {
        // Private constructor to enforce singleton pattern
    }

    public static PCFactory getInstance() {
        if (instance == null) {
            instance = new PCFactory();
        }
        return instance;
    }

    public static PC createPC(String model, int year, String manufacturer) {
        return new PC(model, year, manufacturer);
    }
}

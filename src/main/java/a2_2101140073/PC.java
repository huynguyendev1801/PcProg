/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a2_2101140073;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
class PC {
    private String model;
    private int year;
    private String manufacturer;
    private Set comps;

    public PC(String model, int year, String manufacturer) {
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        comps = new Set(); // Initialize empty set for components
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getComps() {
        String temp = comps.toString();
        
        return "[" + temp.substring(5, temp.length() - 2) + "]";
    }

    public void setComps(Set comps) {
        this.comps = comps;
    }

    public void addComponent(String component) {
        comps.insert(component); // Add component to the set
    }

    @Override
    public String toString() {
        return "PC<" + model + "," + year + "," + manufacturer + "," + comps.toString() + ">";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PC) {
            PC other = (PC) obj;
            return model.equals(other.model) && year == other.year && manufacturer.equals(other.manufacturer)
                    && comps.equals(other.comps);
        }
        return false;
    }
}
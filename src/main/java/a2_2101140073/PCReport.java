/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a2_2101140073;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class PCReport {
    public String displayReport(PC[] objs) {
        StringBuilder report = new StringBuilder();
        // Create report title
        String title = "PCPROG REPORT";
        int titleLength = 99;
        int padding = (titleLength - title.length()) / 2;
         report.append("----------------------------------------------------------------------------------------------\n");
        report.append(String.format("%" + padding + "s%s%" + padding + "s%n", "", title, ""));
        report.append("----------------------------------------------------------------------------------------------\n");
        // Populate report table with PC objects data
        for (int i = 0; i < objs.length; i++) {
            report.append(String.format("%-3d%-20s%-6d%-12s%-40s\n",i + 1, objs[i].getModel(), objs[i].getYear(), objs[i].getManufacturer(), objs[i].getComps()));
        }
        report.append("----------------------------------------------------------------------------------------------\n");
        return report.toString();
    }
}

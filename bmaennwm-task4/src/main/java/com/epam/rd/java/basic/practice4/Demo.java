package com.epam.rd.java.basic.practice4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Demo {

    public static void main(String[] args) {
         Part1.main(args);
    }

    public static String getInput(String fileName) {
            StringBuilder sb = new StringBuilder();
            try {
                Scanner scanner = new Scanner(new File(fileName), "cp1251");
                while (scanner.hasNextLine()) {
                    sb.append(scanner.nextLine()).append(System.lineSeparator());
                }
                scanner.close();
                return sb.toString().trim();
            } catch (IOException ex) {
                Logger.getLogger("Exception : " + ex);
            }
            return sb.toString();

    }
}

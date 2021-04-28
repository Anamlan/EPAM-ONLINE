package com.epam.rd.java.basic.practice4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    private static final Pattern CHARACTERS = Pattern.compile("\\b\\p{L}\\b");
    private static final Pattern STRING = Pattern.compile("(?<=|^)[a-zA-Z\\u0400-\\u04FF_]{2,}(?=|$)");
    private static final Pattern INTEGER = Pattern.compile("(^|\\s)([0-9]+)(?=$|\\s)");
    private static final Pattern DOUBLE = Pattern.compile("\\d+\\.\\d+|\\.\\d+");

    public static void main(String[] args) {
        String inputString = Demo.getInput("part3.txt");

        Scanner sc = new Scanner(System.in);
        String typeOutputData = null;
        while (!(typeOutputData = sc.nextLine()).equalsIgnoreCase("Stop")) {
            Matcher m = null;
            StringBuilder outputString = new StringBuilder();
            if (typeOutputData.equalsIgnoreCase("string")) {
                m = STRING.matcher(inputString);
            } else if (typeOutputData.equalsIgnoreCase("int")) {
                m = INTEGER.matcher(inputString);
            } else if (typeOutputData.equalsIgnoreCase("double")) {
                m = DOUBLE.matcher(inputString);
            } else if (typeOutputData.equalsIgnoreCase("char")) {
                m = CHARACTERS.matcher(inputString);
            }
            if (m == null) {
                outputString.append("Incorrect input");
            } else {
                while (m.find()) {
                    outputString.append(m.group().trim() + " ");
                }
            }
            System.out.println(outputString);
        }
        sc.close();
    }
}

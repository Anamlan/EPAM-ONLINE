package com.epam.rd.java.basic.practice4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {
    private static final Pattern CYRILLIC = Pattern.compile("[а-яА-ЯіІёЁїЇ]+");
    private static final Pattern LATIN = Pattern.compile("[A-Za-z]+");

    public static void main(String[] args) {
        String input = Demo.getInput("part6.txt");

        Scanner sc = new Scanner(System.in);
        String typeOutputData = null;
        while (!(typeOutputData = sc.nextLine()).equalsIgnoreCase("Stop")) {
            Matcher m = null;
            StringBuilder outputString = new StringBuilder();
            if (typeOutputData.equalsIgnoreCase("latn")) {
                m = LATIN.matcher(input);
            } else if (typeOutputData.equalsIgnoreCase("cyrl")) {
                m = CYRILLIC.matcher(input);
            }
            if (m == null) {
                outputString.append("Incorrect input");
            } else {
                while (m.find()) {
                    outputString.append(m.group().trim() + " ");
                }
            }
            System.out.println(typeOutputData + ": " + outputString);
        }
        sc.close();
    }
}

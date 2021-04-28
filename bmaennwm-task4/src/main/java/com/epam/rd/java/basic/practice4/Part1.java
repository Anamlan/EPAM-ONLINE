package com.epam.rd.java.basic.practice4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static final int A = 2;

    public static void main(String[] args) {
        String input = Demo.getInput("part1.txt");
        System.out.println(Part1.convert(input));
    }

    public static String convert(String input) {
        StringBuilder sb = new StringBuilder(input);
        Pattern p = Pattern.compile("(?<word>[A-Za-z-а-яА-Я]{4,})",Pattern.UNICODE_CHARACTER_CLASS);
        Matcher m = p.matcher(input);
        int index = 0;
        while (m.find()) {
              sb.delete(m.start() - index, m.start() + A - index);
              index += A;
        }
        return sb.toString();
    }
}




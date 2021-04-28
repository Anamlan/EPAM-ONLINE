package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

    public static void main(String[] args) {
        String input = Util.getInput("part3.txt");
        System.out.println(convert(input));
    }

    public static String convert(String input) {
        StringBuilder sb = new StringBuilder(input);
        Pattern p = Pattern.compile("(?<word>[a-zA-Z-а-яА-Я]{3,})");
        Matcher m = p.matcher(sb);
        while (m.find()){
                if (Character.isUpperCase(m.group().charAt(0))) {
                    sb.setCharAt(m.start(), Character.toLowerCase(m.group().charAt(0)));
                } else {
                    sb.setCharAt(m.start(), Character.toUpperCase(m.group().charAt(0)));
                }
        }
        return sb.toString();
    }
}

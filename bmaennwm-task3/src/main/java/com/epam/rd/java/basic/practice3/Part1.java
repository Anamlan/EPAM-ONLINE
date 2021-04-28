package com.epam.rd.java.basic.practice3;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static void main(String[] args) {
        String input = Util.getInput("part1.txt");
        System.out.println(convert1(input));
        System.out.println(convert2(input));
        System.out.println(convert3(input));
        System.out.println(convert4(input));
    }

    public static String convert1(String input) {
        String[] text = input.split(System.lineSeparator());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < text.length; i++) {
            String[] first = text[i].split(";");
            sb.append(first[0]).append(": ").append(first[2]).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static String convert2(String input) {
        String[] text = input.split(System.lineSeparator());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < text.length; i++) {
            String[] a = text[i].split("[\\s\\;]");
            sb.append(a[2]).append(" ").append(a[1]).append(" (email: ").append(a[3]).append(")").append("\n");
        }
        return sb.toString();
    }

    public static String convert3(String input) {
        Pattern pattern = Pattern.compile("^?(.+;)(.+;)(.+)(@.+)");
        Matcher matcher = pattern.matcher(input);
        StringBuilder str = new StringBuilder();
        str.append(" ");
        while (matcher.find()) {
            Pattern p2 = Pattern.compile(matcher.group(4).substring(1));
            Matcher m2 = p2.matcher(str);
            if (!m2.find()) {
                str.append(System.lineSeparator()).append(matcher.group(4).substring(1)).append(" ==> ").append(matcher.group(1), 0, matcher.group(1).length() - 1);
            } else {
                Pattern p3 = Pattern.compile(matcher.group(4).substring(1) + ".+");
                Matcher m3 = p3.matcher(str);
                m3.find();
                str.insert(m3.end(), ", " + matcher.group(1).substring(0, matcher.group(1).length() - 1));
            }
        }
        str.append(System.lineSeparator());
        return str.substring(2);
    }

    public static String convert4(String input) {
        String[] text = input.split(System.lineSeparator());
        StringBuilder sb = new StringBuilder();
        final int randomPass = 9999;
        SecureRandom rand = new SecureRandom();
        sb.append(text[0]).append(";Password").append(System.lineSeparator());
        for (int i = 1; i < text.length; i++) {
            int random = rand.nextInt(randomPass);
            while (random < 1001) {
                random = rand.nextInt(randomPass);
            }
            sb.append(text[i]).append(";").append(random).append(System.lineSeparator());
        }
        return sb.toString();
    }
}

package com.epam.rd.java.basic.practice3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class Part6 {

    public static final String ENCODING = "Cp1251";

    public static void main(String[] args){
        String input = Util.getInput("part1.txt");
        System.out.println(convert(input));
    }

    public static String convert(String s) {
        Pattern p = Pattern.compile("(\\b\\w+\\b)(?=[\\s\\S]*\\b\\1\\b[\\s\\S]*\\b\\1\\b)",
                Pattern.UNICODE_CHARACTER_CLASS);
        String res = p.matcher(s + " " + s).replaceAll("_$1");
        res = res.substring(0, res.length() - 1 - p.matcher(s).replaceAll("_$1").length());
        return res;
    }
//    public static String readFile(String path) {
//        String res = null;
//        try {
//            byte[] bytes = Files.readAllBytes(Paths.get(path));
//            res = new String(bytes, ENCODING);
//        } catch (IOException ex) {
//            Logger.getLogger("Exception : " + ex);
//        }
//        return res;
//    }
}

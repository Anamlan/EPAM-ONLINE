package com.epam.rd.java.basic.practice3;

public class Part5 {

    public static void main(String[] args) {
        final int numberFor = 200;
        for (int i = 1; i <= numberFor; i++) {
            System.out.println(i + " ==> " + decimal2Roman(i) + " ==> " + roman2Decimal(decimal2Roman(i)));
        }
    }
    private static final String[] REGEX_ROMAN = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX",
            "V", "IV", "I" };

    private static final int[] ROMAN_NUMERALS = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

    public static String decimal2Roman(int dec) {
        int x = dec;
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < REGEX_ROMAN.length; i++) {
            while (x >= ROMAN_NUMERALS[i]) {
                s.append(REGEX_ROMAN[i]);
                x -= ROMAN_NUMERALS[i];
            }
        }
        return s.toString();
    }

    public static int roman2Decimal(String roman) {
        final StringBuilder sb = new StringBuilder(roman);
        int constNum = 0;
        int number = 0;
        while (sb.length() != 0) {
            if (sb.indexOf(REGEX_ROMAN[number]) == 0) {
                constNum += ROMAN_NUMERALS[number];
                sb.delete(0, REGEX_ROMAN[number].length());
                continue;
            }
            number++;
        }
        return constNum;
    }
}

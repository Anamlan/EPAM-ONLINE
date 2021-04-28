package com.epam.rd.java.basic.practice1;

public class Part7 {
    static final int K = 64;
    static final int L = 26;
    public static void main(String[] args) {
        String[] letters = new String[] {"A", "B", "Z", "AA", "AZ", "BA", "ZZ", "AAA"};
        for (String letter : letters) {
            int number = Part7.str2int(letter);
            String letterSecond = Part7.int2str(number);
            System.out.println(letter + " ==> " + number + " ==> " + letterSecond);
        }
    }

    public static int str2int(String number) {
        int digit = 0;
        for (int i = 1, j = number.length(); j > 0; i++,j--) {
            digit += (number.charAt(number.length() - i) - K)
                    * Math.pow (L, (double) number.length() - j);
        }
        return digit;
    }

    public static String int2str(int number) {
        StringBuilder chars = new StringBuilder();
        StringBuilder charsMirror = new StringBuilder();
        int modul;
        int divident = number;
        while (divident != 0) {
            modul = divident % L;
            if (modul == 0) {
                chars.append("Z");
                divident = (divident - 1) / L;
            } else {
                chars.append((char) (modul + K));
                divident = (divident - modul) / L;
            }
        }
        for (int i = 0; i < chars.length(); i++)
            charsMirror.append(chars.charAt(chars.length() - i - 1));
        return charsMirror.toString();
    }

    public static String rightColumn(String number) {
        String chars = "";
        int num;
        num = str2int(number);
        num++;
        chars = int2str(num);
        return chars;
    }
}

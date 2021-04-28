package com.epam.rd.java.basic.practice3;

public class Part2 {

    private static final String WORDTYPE = "\\W+";

    public static void main(String[] args) {
        String input = Util.getInput("part2.txt");
        System.out.println(convert(input));
    }

    public static String convert(String input) {
        StringBuilder outputString = new StringBuilder();
        String[] words = input.split(WORDTYPE);
        outputString.append("Min:").append(reciveLenght(words, minWord(words))).append("\n");
        outputString.append("Max:").append(reciveLenght(words, maxWord(words)));
        return outputString.toString();
    }

    private static int minWord(String[] words) {
        int minLenght = words[0].length();
        for (String word : words) {
            if (word.length() < minLenght) {
                minLenght = word.length();
            }
        }
        return minLenght;
    }

    private static int maxWord(String[] words) {
        int maxLenght = words[0].length();
        for (String word : words) {
            if (word.length() > maxLenght) {
                maxLenght = word.length();
            }
        }
        return maxLenght;
    }

    private static String reciveLenght(String[] words, int lenght) {
        StringBuilder outputString = new StringBuilder();
        for (String word : words) {
            if (word.length() == lenght && !isUnique(word, outputString.toString())) {
                outputString.append(" ").append(word).append(",");
            }
        }
        outputString.deleteCharAt(outputString.length() - 1);
        return outputString.toString();
    }

    private static boolean isUnique (String word, String input) {
        return input.contains(word);
    }
}
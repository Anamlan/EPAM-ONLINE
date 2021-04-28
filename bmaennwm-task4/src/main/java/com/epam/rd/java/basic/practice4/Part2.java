package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.Scanner;
import java.util.logging.Logger;

public class Part2 {
    public static final Path ARG = Paths.get("part2.txt");
    public static final Path AUR = Paths.get("part2_sorted.txt");

    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter(String.valueOf(ARG), false)) {
            StringBuilder sb = new StringBuilder();
            SecureRandom rand = new SecureRandom();
            for (int i = 0; i < 10; i++) {
                sb.append(rand.nextInt(50) + " ");
            }writer.write(sb.toString());
        } catch (IOException e) {
            Logger.getLogger("Exception : " + e);
        }

        try (FileReader read = new FileReader(String.valueOf(ARG));
             FileWriter writeTo = new FileWriter(String.valueOf(AUR))) {
            Scanner scan = new Scanner(read);
            int [] next = new int[10];
            for (int i = 0; i < next.length; i++){
                next[i] = scan.nextInt();
            }
            writeTo.write(bubbleSortedValues(next));
        } catch (IOException ioException) {
            Logger.getLogger("Exception : " + ioException);
        }
        System.out.println(new StringBuilder().append("input ==> ").append(Demo.getInput(String.valueOf(ARG))).append("\n")
                .append("output ==> ").append(Demo.getInput(String.valueOf(AUR))).toString());
    }

    private static String bubbleSortedValues(int[] next) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < next.length; i++) {
            for (int j = i; j < next.length; j++) {
                if (next[i] > next[j]) {
                    int buffer = next[i];
                    next[i] = next[j];
                    next[j] = buffer;
                }
            }
        }
        for (int i : next) {
            sb.append(i + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}

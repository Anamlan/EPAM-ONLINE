package com.epam.rd.java.basic.practice3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Part4 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
            System.out.println(hash("passsword", "SHA-256"));
            System.out.println(hash("passwort", "SHA-256"));
    }

    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder();
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes());
        byte[] hash = digest.digest();
        for (int i = 0; i < hash.length; i++) {
            String x;
            if (hash[i] < 0) {
                x = (String.format("%1X", hash[i]));
                String y = x.substring(x.length() - 2);
                sb.append(y);
                continue;
            }
            sb.append(String.format("%02x", hash[i]));
        }
        return sb.toString().toUpperCase();
    }
}

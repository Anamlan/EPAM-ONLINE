package com.epam.rd.java.basic.practice1;

public class Part6 {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        String[] primeNum = new String[n];
        int a = 2;
        int index = 0;
        while (index < n) {
            if (isPrime(a)) {
                primeNum[index] = String.valueOf(a);
                index++;
            }
            a++;
        }
        System.out.println(String.join(" ", primeNum));
    }

    public static boolean isPrime(int number) {
        boolean flag = true;
        for (int i = 2; i < number / 2 +1; i++) {
            if (number % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}



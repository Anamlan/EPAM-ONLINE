package com.epam.rd.java.basic.practice1;

public class Part5 {

    public static void main(String[] args) {
        int sum = 0;
        int n = Integer.parseInt(args[0]);
        for(int i = 0; n >= i; i++){
            sum += n % 10;
            n /= 10;
        }
        System.out.println(sum);
    }
}


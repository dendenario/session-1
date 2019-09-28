package com.company;

import java.util.ArrayList;

public class Task {
    public static void main(String[] args) {
        System.out.println(binaryToDec("00"));
        System.out.println(sumOfBinary("1", "1"));

        long[] arr1 = new long[]{1,2,30};
        long[] arr2 = new long[]{1};
        long[] mass = intersection(arr1,arr2);
        for(int i=0; i<mass.length;i++)
        {
            System.out.println(mass[i]);
        }
    }

    public static long binaryToDec(String text) {
        long num = 0;
        String[] bin = text.split("");
        for (int i = text.length() - 1; i >= 0; i--) {
            if (Integer.parseInt(bin[i]) != 0) {
                num += Math.pow(2, text.length() - 1 - i);
            }
        }
        return num;
    }

    public static String sumOfBinary(String b1, String b2) {
        long sum = binaryToDec(b1) + binaryToDec(b2);
        if (sum == 0) return "0";
        StringBuilder result = new StringBuilder();
        while (sum != 0) {
            result.append(sum & 1);
            sum >>>= 1;
        }
        return result.reverse().toString();
    }

    public static long[] intersection(long[] arr1, long[] arr2) {
        ArrayList<Long> mass = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    mass.add(arr1[i]);
                }
            }
        }
        long[] result = new long[mass.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = mass.get(i);
        }
        return result;
    }
}

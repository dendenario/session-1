package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Task {
    public static void main(String[] args) {
//        System.out.println(binaryToDec("101"));
//        System.out.println(sumOfBinary("1", "1"));

        long startTime = System.currentTimeMillis();

        long[] arr1 = new long[]{1,2,30,1,30,1,30,20,20,2,1,30,1,30,20,20,2,1,30,1,30,20,20,21,30,1,30,20,20,2, 1,2,30,1,30,1,30,20,20,2,1,30,1,30,20,20,2,1,30,1,30,20,20,21,30,1,30,20,20,2,4,1,2,5,3,4,24,5,123,30,20,20,2,1,30,1,30,20,20,2,1,30,1,30,20,20,21,30,1,30,20,20,30,20,20,2,1,30,1,30,20,20,2,1,30,1,30,20,20,21,30,1,30,20,20,30,20,20,2,1,30,1,30,20,20,2,1,30,1,30,20,20,21,30,1,30,20,20,30,20,20,2,1,30,1,30,20,20,2,1,30,1,30,20,20,21,30,1,30,20,20,30,20,20,2,1,30,1,30,20,20,2,1,30,1,30,20,20,21,30,1,30,20,20,30,20,20,2,1,30,1,30,20,20,2,1,30,1,30,20,20,21,30,1,30,20,20,30,20,20,2,1,30,1,30,20,20,2,1,30,1,30,20,20,21,30,1,30,20,20,5,6,71347,17,4};
        long[] arr2 = new long[]{1,30,1,30,20,20,2,1,30,1,30,20,20,21,30,1,30,20,20,21,30,1,30,20,20,21,30,1,30,20,20,21,30,1,30,20,20,2};
        long[] mass = intersection(arr1,arr2);
        for(int i=0; i<mass.length;i++)
        {
            System.out.println(mass[i]);
        }

        long timeSpent = System.currentTimeMillis() - startTime ;
        System.out.println("программа выполнялась " + timeSpent + " миллисекунд");

    }

//    public static long binaryToDec(String text) {
//        long num = 0;
//        String[] bin = text.split("");
//        char[] bins = text.toCharArray();
//        for (int i = text.length() - 1; i >= 0; i--) {
//            if (Integer.parseInt(bin[i]) != 0) {
//                num += Math.pow(2, text.length() - 1 - i);
//            }
//        }
//        return num;
//    }

    public static long binaryToDec(String text) {
        long num = 0;
        long mult = 1;
        char[] bin = text.toCharArray();
        for (int i = bin.length - 1; i >= 0; i--) {
            if (bin[i] != 48) {
                num += mult;
            }
            mult*=2;
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

//    public static long[] intersection(long[] arr1, long[] arr2) {
//        ArrayList<Long> mass = new ArrayList<>();
//        for (int i = 0; i < arr1.length; i++)
//        {
//            for (int j = 0; j < arr2.length; j++)
//            {
//                if (arr1[i] == arr2[j])
//                {
//                    mass.add(arr1[i]);
//                }
//            }
//        }
//        long[] result = new long[mass.size()];
//        for (int i = 0; i < result.length; i++) {
//            result[i] = mass.get(i);
//        }
//        return result;
//    }
//
//    public static long[] intersection(long[] arr1, long[] arr2) {
//        HashSet<Long> set = new HashSet<>();
//        ArrayList<Long> arrayList = new ArrayList<>();
//        for(Long l : arr1)
//        {
//            set.add(l);
//        }
//
//        for(Long l : arr2)
//        {
//            if(set.contains(l))
//            {
//                arrayList.add(l);
//            }
//        }
//        long[] result = new long[arrayList.size()];
//        for (int i = 0; i < result.length; i++) {
//            result[i] = arrayList.get(i);
//        }
//        return result;
//    }

    public static long[] intersection(long[] arr1, long[] arr2) {
        Arrays.sort(arr1);
        ArrayList<Long> res = new ArrayList<>();
        long num = 0;
        for(int i = 0;  i<arr2.length; i++)
        {
            num = binarySearch(arr1, arr2[i] );
            if(num!=-1) {
                res.add(num);
            }
        }
        long[] result = new long[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public static long binarySearch(long arr[], long elementToSearch) {

        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        while(firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (arr[middleIndex] == elementToSearch) {
                return arr[middleIndex];
            }
            else if (arr[middleIndex] < elementToSearch)
                firstIndex = middleIndex + 1;
            else if (arr[middleIndex] > elementToSearch)
                lastIndex = middleIndex - 1;

        }
        return -1;
    }
}

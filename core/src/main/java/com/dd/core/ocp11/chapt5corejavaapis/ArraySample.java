package com.dd.core.ocp11.chapt5corejavaapis;

import java.util.*;

public class ArraySample {
    public static void main(String[] args) {
        char[] arr1 = new char[3];
        arr1[0] = 'a';
        for (char i: arr1) {
            System.out.println(i);
        }

        System.out.println(Arrays.binarySearch(arr1, 'a'));

        System.out.println(Arrays.compare(new int[]{1}, new int[]{1,2} ));
        System.out.println(Arrays.compare(new int[]{1,3}, new int[]{1,2} ));

        System.out.println("abc".compareTo("ab"));
        System.out.println("abc".compareTo("aa"));
        System.out.println("AA".compareTo("aa"));
        System.out.println("aa".compareTo("AA"));

        System.out.println(Arrays.compare(new int[]{1,2}, new int[]{1,2,3}));
        System.out.println(Arrays.mismatch(new int[]{1,2}, new int[]{1,2,3,4}));

        int[][] var1;
        int[] var2[];
        int var3[][];
        int[] var4[], var5[][];

        int[][] var6 = new int[3][2];

        int[][] var7 = {{1,2}, {3,4}, {7,8,9}};

        int[][] var8 = new int[3][];
        var8[0] = new int[2];
        var8[1] = new int[3];
        var8[2] = new int[8];
    }
}

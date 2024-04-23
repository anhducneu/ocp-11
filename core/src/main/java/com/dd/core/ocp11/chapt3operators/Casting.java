package com.dd.core.ocp11.chapt3operators;

public class Casting {
    public static void main(String[] args) {
        short ticketTaker = (short)1921224;
        System.out.println(ticketTaker);

        long x = (long) (Long.MAX_VALUE + 2);
        System.out.println(Long.MAX_VALUE);
        System.out.println(x);

        char a = 10;
        char b = 20;

        var c = a * b;

        int x2 = 10;
        double y2 = 10.00;
//        x2 *= y2;
        System.out.println("x2: " + x2);

        System.out.println(x2 == y2 ? "true" : "false");

        Object x3 = null;
        System.out.println(x3 instanceof String ? "true" : "false");

        Integer x4 = null;
        System.out.println(x4 instanceof Number ? "true" : "false");

        System.out.println("x2: " + x2);
        boolean x5 = false || (++x2 < 1);
        System.out.println("x2: " + x2);

        long x6 = Integer.MAX_VALUE + 1;
        System.out.println(("x6: " + x6));
    }
}

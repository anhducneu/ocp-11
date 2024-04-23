package com.dd.core.ocp11.chapt5corejavaapis;

public class StringSample {

    public static void main(String[] args) {
        String string = "animals";

        System.out.println(string.length());
        System.out.println(string.charAt(3));

        System.out.println(string.indexOf('i'));
        System.out.println(string.indexOf("ma"));
        System.out.println(string.indexOf("ma", 4));

        System.out.println(string.substring(2));
        System.out.println(string.substring(2, 5));
        System.out.println(string.substring(string.indexOf('i'), string.indexOf('m')));

        System.out.println(string.toLowerCase());
        System.out.println(string.toUpperCase());

        System.out.println(string.startsWith("ani"));
        System.out.println(string.endsWith("mals"));

        System.out.println(string.replace('a', 'b'));
        System.out.println(string.replace("an", "bm"));
        System.out.println(string.contains("an"));

        StringBuilder sb = new StringBuilder("start");
        sb.append("+middle");
        StringBuilder same = sb;
        same.append("+end");

        System.out.println("Orig: " + sb.toString());
        System.out.println("Dest: " + same.toString());

        StringBuilder sb1 = new StringBuilder("animals");
        sb1.insert(7, '-');
        System.out.println(sb1);

        sb1.delete(7, 8);
        System.out.println(sb1);

        sb1.deleteCharAt(2);
        System.out.println(sb1);

        StringBuilder sb2 = new StringBuilder("pigeon dirty");
        sb2.replace(3, 7, "xxx");

        System.out.println(sb2);

        sb2.reverse();
        System.out.println(sb2);

        String string3 = "Hello world";
        String string4 = new StringBuilder("Hello world").toString().intern();

        System.out.println("Equality: " + (string3 == string4));

        String z = "Hello".intern();
    }
}

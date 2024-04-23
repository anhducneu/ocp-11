package com.dd.core.ocp11.chapter8classdesign;

public class Animal {
    protected static String name = "A";

    public static void testHiding() {
        System.out.println("Animal is hiding you");
    }

    public static void childHiding() {
        testHiding();
        System.out.println("Animal is childHiding you");
    }

    public Animal() {

    }

    public Animal(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

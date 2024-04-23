package com.dd.core.ocp11.chapter9advancedclassdesign;

interface Canine {
    String getName();
}

class Dog implements Canine {
    public String getName() {
        return "Dog";
    }
}

class Wolf implements Canine {
    public String getName() {
        return "Wolf";
    }
}

class BabyWolf  {
    public String getName() {
        return "Baby Wolf";
    }
}



public class BadCasts {
    public static void main(String[] args) {
        Wolf canine = new Wolf();

        if(canine instanceof Wolf) {
            Canine badDog = (Wolf) canine;
            System.out.println(badDog.getName());
        }
    }
}
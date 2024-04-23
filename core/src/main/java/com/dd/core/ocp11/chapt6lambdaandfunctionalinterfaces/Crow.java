package com.dd.core.ocp11.chapt6lambdaandfunctionalinterfaces;

import java.util.function.*;

public class Crow {
private String color;
    String gender = "Pink";
    public void caw(String name) {
        String volume = "loudly";
        color = "black";

        Consumer<String> consumer = s ->
             System.out.println(name + " says "
             + volume + " that she is " + color + gender);
            gender = "red";
         }
}
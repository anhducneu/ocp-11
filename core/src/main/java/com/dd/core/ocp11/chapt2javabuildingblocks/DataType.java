package com.dd.core.ocp11.chapt2javabuildingblocks;

public class DataType {

    public static void main(String[] args) {
        Chick chick = new Chick();
        Chick chick2 = new Chick();
    }
}

class Chick {
    private String name = "Luffy";

    {
        name = "xxx";
        System.out.println("Setting field: " + name);
    }

    public Chick() {
        System.out.println("Hello: " + name);
        char mammal = (short) 83;
        char mammal2 = (int) 65535;

    }
}
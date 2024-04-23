package com.dd.core.ocp11.chapter8classdesign;

public class Gorilla extends Animal{
    protected String name = "G";

    private final String description;

    static Animal a;

    public Gorilla(String description) {
        this.description = description;
    }

    public static void testHiding() {
        System.out.println("Gorilla is hiding you");
    }

    public static void main(String[] args) {

        Animal animal = new Gorilla("Des");
        animal.setName("Animal");
        System.out.println(animal.name);

        Gorilla gorilla = (Gorilla) animal;
        gorilla.setName("Gorilla");

        System.out.println("getName(): " + gorilla.getName());
        System.out.println("getName(): " + animal.getName());

        System.out.println("name: " + gorilla.name);
        System.out.println("name: " + animal.name);

        a = gorilla;
        a.setName("Animal static");

        System.out.println(gorilla.getName());
        System.out.println(a.getName());

//        Dragon dragon = (Dragon) animal;
//        System.out.println(dragon.getName());

        gorilla.testHiding();
        animal.testHiding();

    }

}

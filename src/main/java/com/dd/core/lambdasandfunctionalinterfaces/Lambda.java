package com.dd.core.lambdasandfunctionalinterfaces;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda {

  public static void main(String[] args) {

    List<Animal> animals = new ArrayList<>();
    animals.add(new Animal("fish", false, true));
    animals.add(new Animal("kangaroo", true, false));
    animals.add(new Animal("rabbit", true, false));
    animals.add(new Animal("turtle", false, true));

    //Predicate
    print(animals, Animal::canHop);

    //Consumer
    print2(item -> System.out.println(item + " transform"), "Test");

    //Supplier
    System.out.println(print3(() -> new Random().nextInt()));

    //Comparator
    animals.stream().sorted((animal1, animal2) -> animal1.toString().compareTo(animal2.toString()));

  }

  private void variableReference(String name) {
    String volume = "loudly";
    Consumer<String> consumer = s -> {
      System.out.println(volume + "-" + s);
    };
  }

  private String color;
  public void caw(String name) {
     String volume = "loudly";
     color = "black";
     if(true == true){
       color = "softly";

     }

     Consumer<String> consumer = s ->
     System.out.println(name + " says "
     + volume + " that she is " + color);
     }


  private static void print(List<Animal> animals, Predicate<Animal> checker) {
    for (Animal animal : animals) {
      if (checker.test(animal)) {
        System.out.print(animal + " ");
      }
    }
    System.out.println();
  }

  private static void print2(Consumer<String> consumer, String value) {
    consumer.accept(value);
  }

  private static Integer print3(Supplier<Integer> supplier) {
    return supplier.get();
  }

}

//@FunctionalInterface
//interface CheckTrait {
//  boolean test(Animal a);
//}


class Animal {

  private String species;
  private boolean canHop;
  private boolean canSwim;

  public Animal(String speciesName, boolean hopper, boolean swimmer) {
    species = speciesName;
    canHop = hopper;
    canSwim = swimmer;
  }

  public boolean canHop() {
    return canHop;
  }

  public boolean canSwim() {
    return canSwim;
  }

  public String toString() {
    return species;
  }


}



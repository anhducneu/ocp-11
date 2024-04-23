package com.dd.core.ocp11.chapt6lambdaandfunctionalinterfaces;

import java.util.*;
import java.util.ArrayList;
import java.util.function.*;

public class LambdaSample {

    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();
        animals.add("a");
        animals.add("b");
        animals.add("c");
        animals.add("d");

        Predicate<String> predicate = i -> "a".equals(i);
        verify(animals, predicate);
        consume(animals, i -> System.out.println(i));
        supply(animals, () -> Math.random());
        compare(animals, (a, b) -> a.compareTo(b));

        animals.removeIf(a -> "a".equals(a));
        animals.sort((a, b) -> b.compareTo(a));
        animals.forEach(a -> System.out.println(a));
//        test(animals, "hello");

        var x = new ArrayList();

    }

    public void test(List<String> animals, String a) {
        final String b = "abc";
        String c = "xyz";
        Consumer<String> consumer = i -> {
            System.out.println(a + " " + b + " " + c + " ...");
        };
        consume(animals, consumer);
    }

    public static void verify(List<String> animals, Predicate<String> predicate) {
        for(String a: animals) {
            System.out.println(predicate.test(a));
        }
    }

    public static void consume(List<String> animals, Consumer<String> consumer) {
        for(String a: animals) {
            consumer.accept(a);
        }
    }

    public static void supply(List<String> animals, Supplier<Double> supplier) {
        for(String a: animals) {
            System.out.println("Random value: " + supplier.get());
        }
    }

    public static void compare(List<String> animals, Comparator<String> comparator) {
        for (String a: animals) {
            System.out.println(comparator.compare(a, "b"));
        }
    }

}

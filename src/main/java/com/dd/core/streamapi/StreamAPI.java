package com.dd.core.streamapi;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class StreamAPI {

//  public static void main(String[] args) {
//
//    long count = Stream.of(1,2,3,4,5)
//        .map(item -> item * item)
//        .peek(System.out::println)
//        .count();
//
//    System.out.println(count);
//
//  }

//  public static void main(String[] args) {
//    Method[] methods = Stream.class.getMethods();
//    Optional<String> methodName = Arrays.stream(methods)
//        .map(Method::getName)
//        .peek(System.out::println)
//        .filter(name -> name.endsWith("Match"))
//        .findFirst();
//
//    System.out.println(methodName);
//  }

  public static void main(String[] args) {

    Stream<Double> doubleStream = Stream.of();

    Optional<Double> max = doubleStream.max(Double::compareTo);

    if (max.isPresent()) {
      System.out.println(max.get());
    }

    max.ifPresent(System.out::println);


  }

//  public static void main(String[] args) {
//
//    Set<String> uniqueValues = new HashSet<String>();
//    uniqueValues.add("1");
//    uniqueValues.add("2");
//    uniqueValues.add("3");
//
////    uniqueValues.stream()
//
//    Map<String, String> x = new HashMap();
//    x.put("1", "A lot of");
//    x.put("2", "Graceful");
//    x.put("3", "Fully");
//
//    Map<String, String> map = x.keySet().stream().collect(Collectors.toMap(item -> item, item -> item));
//
//    System.out.println(map);
//
//  }

//  public static void main(String[] args) {
//
//    String string = "you never know what you have until you clean your room";
//    String[] stringArr = string.split("");
////    Arrays.stream(stringArr).distinct().forEach(System.out::println);
//
//    Arrays.stream(string.split(" "))
//        .flatMap(item -> Arrays.stream(item.split("")))
//        .distinct()
//        .sorted()
//        .forEach(System.out::println);
//
//
//
//  }

}

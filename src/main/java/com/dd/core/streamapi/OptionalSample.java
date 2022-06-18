package com.dd.core.streamapi;

import java.util.Optional;

public class OptionalSample {

  public static void main(String[] args) {

    Optional<String> empty = Optional.empty();

//    Optional<String> nullValue = Optional.of(null);  //Null pointer exception

    Optional<String> nullableValue = Optional.ofNullable(null);

    Optional<String> value = Optional.of("TEST");

//    System.out.println(nullableValue);

    System.out.println(nullableValue.map(String::length).orElse(-1));

  }
}

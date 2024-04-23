package com.dd.core.extend.jackson.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Zoo {
  public Animal animal;

  @JsonTypeInfo(
      use = JsonTypeInfo.Id.NAME,
      include = As.PROPERTY,
      property = "type")
  @JsonSubTypes({
      @JsonSubTypes.Type(value = Dog.class, name = "dog"),
      @JsonSubTypes.Type(value = Cat.class, name = "cat")
  })
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Animal {
    public String name;
    public String type;
  }

  @AllArgsConstructor
  @NoArgsConstructor
  @JsonTypeName("dog")
  public static class Dog extends Animal {
    public double barkVolume;
  }

  @AllArgsConstructor
  @NoArgsConstructor
  @JsonTypeName("cat")
  public static class Cat extends Animal {
    boolean likesCream;
    public int lives;
  }
}

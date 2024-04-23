package com.dd.core.extend.jackson.models;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum TypeEnumWithValue {

  TYPE1(1, "Type A"),
  TYPE2(2, "Type B");

  private Integer id;
  private String name;

  @JsonValue
  public String getName(){
    return "abc";
  }

}

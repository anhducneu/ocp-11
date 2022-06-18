package com.dd.core.jackson.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"name", "id"})
public class MyBean {

  public int id;
  private String name;

  @JsonGetter("name")
  public String getTheName() {
    return name;
  }

}

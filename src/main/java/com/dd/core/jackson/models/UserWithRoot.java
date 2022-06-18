package com.dd.core.jackson.models;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@JsonRootName(value = "user")
public class UserWithRoot {

  public Integer id;
  public String name;

}

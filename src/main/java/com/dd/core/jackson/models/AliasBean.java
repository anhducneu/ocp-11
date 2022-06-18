package com.dd.core.jackson.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AliasBean {
  @JsonAlias({"fName", "f_name"})
  private String firstName;
  private String lastName;
}

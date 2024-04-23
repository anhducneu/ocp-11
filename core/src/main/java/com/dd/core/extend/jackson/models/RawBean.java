package com.dd.core.extend.jackson.models;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class RawBean {
  public String name;

  @JsonRawValue
  public String json;
}

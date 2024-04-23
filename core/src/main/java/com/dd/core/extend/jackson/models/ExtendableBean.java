package com.dd.core.extend.jackson.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExtendableBean {
  public String name;
  private Map<String, String> properties;

//  @JsonAnyGetter
//  public Map<String, String> getProperties() {
//    return properties;
//  }

  @JsonAnySetter
  public void add(String key, String value) {
    properties.put(key, value);
  }
}

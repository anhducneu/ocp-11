package com.dd.core.extend.jackson.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties(value = {"id"}, ignoreUnknown = true)
@JsonInclude(Include.ALWAYS)
public class BeanWithIgnore {
  private int id;
  private String name;

  private String custom;

  private Name fullName;

  private Instant createdAt;

  @JsonIgnore
  public void setCustom(String custom) {
    this.custom = custom;
  }

  @JsonProperty
  public String getCustom() {
    return this.custom;
  }

  @AllArgsConstructor
  @NoArgsConstructor
  @JsonIgnoreType
  public static class Name {
    public String firstName;
    public String lastName;
  }
}

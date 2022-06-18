package com.dd.core.anotation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@JsonSerializable
@AllArgsConstructor
@NoArgsConstructor
public class Person {
  @JsonElement
  private String firstName;

  @JsonElement
  private String lastName;

  @JsonElement(key = "personAge")
  private String age;

  private String address;

  @Init
  private void initNames() {
    this.firstName = this.firstName.substring(0, 1).toUpperCase()
        + this.firstName.substring(1);
    this.lastName = this.lastName.substring(0, 1).toUpperCase()
        + this.lastName.substring(1);
  }

}

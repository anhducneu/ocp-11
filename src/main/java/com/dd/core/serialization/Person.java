package com.dd.core.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

  static String country = "ITALY";

  private int age;

  private String name;

  transient int height;

  private Address address;

  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
    oos.writeObject(address.getHouseNumber());
  }

  private void readObject(ObjectInputStream ois)
      throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
    Integer houseNumber = (Integer) ois.readObject();
    Address a = new Address();
    a.setHouseNumber(houseNumber);
    this.setAddress(a);
  }

}


package com.dd.core.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Serialization {

  @Test
  public void whenSerializingAndDeserializing_ThenObjectIsTheSame()
      throws IOException, ClassNotFoundException {

    Address address = Address.builder()
        .houseNumber(111)
        .build();
    Person person = Person.builder()
        .age(10)
        .height(100)
        .name("Hi hi")
        .address(address)
        .build();

    FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    objectOutputStream.writeObject(person);
    objectOutputStream.flush();
    objectOutputStream.close();

    FileInputStream fileInputStream = new FileInputStream("test.txt");
    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
    Person person2 = (Person) objectInputStream.readObject();
    objectInputStream.close();

    Assertions.assertEquals(person.getAge(), person2.getAge());
    Assertions.assertEquals(person.getName(), person2.getName());
    Assertions.assertEquals(person.getAddress().getHouseNumber(), person2.getAddress().getHouseNumber());


  }
}

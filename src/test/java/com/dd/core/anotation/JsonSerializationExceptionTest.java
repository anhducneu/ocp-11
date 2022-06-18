package com.dd.core.anotation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JsonSerializationExceptionTest {

  @Test
  public void givenObjectNotSerializedThenExceptionThrown() throws JsonSerializationException {
    Object object = new Object();
    ObjectToJsonConverter serializer = new ObjectToJsonConverter();
    Assertions.assertThrows(JsonSerializationException.class, () -> {
      serializer.convertToJson(object);
    });
  }

  @Test
  public void givenObjectSerializedThenTrueReturned() throws JsonSerializationException {
    Person person = new Person("soufiane", "cheouati", "34", "abc");
    ObjectToJsonConverter serializer = new ObjectToJsonConverter();
    String jsonString = serializer.convertToJson(person);
    Assertions.assertEquals("{\"personAge\":\"34\",\"firstName\":\"Soufiane\",\"lastName\":\"Cheouati\"}", jsonString);
  }

}

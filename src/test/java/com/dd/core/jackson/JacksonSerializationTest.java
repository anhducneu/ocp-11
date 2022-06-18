package com.dd.core.jackson;


import com.dd.core.jackson.models.BeanWithCreator;
import com.dd.core.jackson.models.BeanWithIgnore;
import com.dd.core.jackson.models.BeanWithInject;
import com.dd.core.jackson.models.EventWithSerializer;
import com.dd.core.jackson.models.ExtendableBean;
import com.dd.core.jackson.models.MyBean;
import com.dd.core.jackson.models.RawBean;
import com.dd.core.jackson.models.TypeEnumWithValue;
import com.dd.core.jackson.models.UserWithRoot;
import com.dd.core.jackson.models.Zoo;
import com.dd.core.jackson.models.Zoo.Dog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JacksonSerializationTest {

  @Test
  public void whenSerializingUsingJsonGetter_thenCorrect() throws JsonProcessingException {

    MyBean bean = new MyBean(1, "My bean");
    String result = new ObjectMapper().writeValueAsString(bean);

    System.out.println(result);
  }


  @Test
  public void whenSerializingUsingJsongRawValue_thenCorrect() throws JsonProcessingException {

    RawBean rawBean = new RawBean("My bean", "{\"attr\":false}");
    String result = new ObjectMapper().writeValueAsString(rawBean);

    System.out.println(result);
  }

  @Test
  public void whenSerializingUsingJsonValue_thenCorrect() throws JsonProcessingException {
    String result = new ObjectMapper().writeValueAsString(TypeEnumWithValue.TYPE1);

    System.out.println(result);
  }

  @Test
  public void whenSerializingUsingJsonRootName_thenCorrect() throws JsonProcessingException{

    UserWithRoot userWithRoot = new UserWithRoot(1, "Hello");

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
    String result = objectMapper.writeValueAsString(userWithRoot);

    System.out.println(result);

  }

  @Test
  public void whenSerializingUsingJsonSerialize_thenCorrect() throws JsonProcessingException, ParseException {

    SimpleDateFormat df
        = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    String toParse = "20-12-2014 02:30:00";
    Date date = df.parse(toParse);
    EventWithSerializer event = new EventWithSerializer("party", date);

    String result = new ObjectMapper().writeValueAsString(event);

    System.out.println(result);
  }

  @Test
  public void whenSerializingWithBeanWithCreator_thenCorrect() throws JsonProcessingException, ParseException {
    String json = "{\"id\":1,\"theName\":\"My bean\"}";

    BeanWithCreator bean = new ObjectMapper()
        .readerFor(BeanWithCreator.class)
        .readValue(json);

    Assertions.assertEquals("My bean", bean.name);

  }

  @Test
  public void whenSerializingWithJacksonInject_thenCorrect() throws JsonProcessingException {

    String json = "{\"name\":\"My bean\"}";
    InjectableValues injectableValues = new InjectableValues.Std()
        .addValue(int.class, 1);

    BeanWithInject bean = new ObjectMapper()
        .reader(injectableValues)
        .forType(BeanWithInject.class)
        .readValue(json);

    Assertions.assertEquals(1, bean.id);
  }

  @Test
  public void whenSerializingUsingJsonIgnoreProperties_thenCorrect()
      throws JsonProcessingException {

    BeanWithIgnore.Name name = new BeanWithIgnore.Name("John", "Doe");

    BeanWithIgnore bean = new BeanWithIgnore(1, "My bean", null, name, Instant.now());

    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    String result = mapper.writeValueAsString(bean);

    System.out.println(result);

  }


  @Test
  public void whenSerializingPolymorphic_thenCorrect()
      throws JsonProcessingException {
    Zoo.Dog dog = new Zoo.Dog(2);
    Zoo zoo = new Zoo(dog);

    String result = new ObjectMapper()
        .writeValueAsString(zoo);

    System.out.println(result);

    Zoo zoo2 = new ObjectMapper()
        .readerFor(Zoo.class)
        .readValue(result);

    Assertions.assertEquals(2, ((Dog) zoo.animal).barkVolume);



  }


}

package com.dd.core.jackson;

import com.dd.core.jackson.models.AliasBean;
import com.dd.core.jackson.models.EventWithSerializer;
import com.dd.core.jackson.models.ExtendableBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JacksonDerializationTest {


  @Test
  public void whenDeserializingUsingJsonAnySetter_thenCorrect()
      throws IOException {
    String json
        = "{\"name\":\"My bean\",\"attr2\":\"val2\",\"attr1\":\"val1\"}";

    ExtendableBean bean = new ObjectMapper()
        .readerFor(ExtendableBean.class)
        .readValue(json);

    Assertions.assertEquals("My bean", bean.name);
    Assertions.assertEquals("val2", bean.getProperties().get("attr2"));
  }

  @Test
  public void whenDeserializingUsingJsonDeserialize_thenCorrect()
      throws IOException {

    String json = "{\"name\":\"party\",\"eventDate\":\"20-12-2014 02:30:00\"}";

    SimpleDateFormat df
        = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
    EventWithSerializer event = new ObjectMapper()
        .readerFor(EventWithSerializer.class)
        .readValue(json);

    Assertions.assertEquals("20-12-2014 02:30:00", df.format(event.eventDate));
  }

  @Test
  public void whenDeserializingUsingJsonAlias_thenCorrect() throws IOException {
    String json = "{\"fName\": \"John\", \"lastName\": \"Green\"}";
    AliasBean aliasBean = new ObjectMapper().readerFor(AliasBean.class).readValue(json);
    Assertions.assertEquals("John", aliasBean.getFirstName());
  }
}

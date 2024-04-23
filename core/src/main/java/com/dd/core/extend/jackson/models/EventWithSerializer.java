package com.dd.core.extend.jackson.models;

import com.dd.core.extend.jackson.CustomDateDeserializer;
import com.dd.core.extend.jackson.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class EventWithSerializer {

  public String name;

  @JsonSerialize(using = CustomDateSerializer.class)
  @JsonDeserialize(using = CustomDateDeserializer.class)
  public Date eventDate;

}

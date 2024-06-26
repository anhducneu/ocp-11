package com.dd.core.extend.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateSerializer extends StdSerializer<Date> {

  private static SimpleDateFormat formatter
      = new SimpleDateFormat("dd-MM-yyyy hh:mm");

  public CustomDateSerializer() {
    this(null);
  }

  public CustomDateSerializer(Class<Date> t) {
    super(t);
  }

  @Override
  public void serialize(Date value, JsonGenerator gen, SerializerProvider arg2) throws IOException {
    gen.writeString(formatter.format(value));
  }

}

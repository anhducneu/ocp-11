package com.dd.core.jackson.models;

import com.fasterxml.jackson.annotation.JacksonInject;

public class BeanWithInject {

  @JacksonInject
  public int id;

  public String name;


}

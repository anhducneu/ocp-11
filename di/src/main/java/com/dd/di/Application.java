package com.dd.di;

import com.dd.di.annotation.Autowire;
import com.dd.di.annotation.Component;
import com.dd.di.loader.ClassLoader;
import com.dd.di.loader.Runner;
import com.dd.di.service.OrderService;

@Component
public class Application implements Runner {

  @Autowire
  private OrderService orderService;

  public static void main(String[] args) {
    ClassLoader.getInstance().load("com.dd.di");

    System.out.println("Loaded all classes successfully");
  }

  @Override
  public void run() {
    System.out.println("START");

    orderService.order();
    System.out.println("DONE");

  }
}

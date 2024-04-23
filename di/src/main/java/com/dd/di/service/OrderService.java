package com.dd.di.service;

import com.dd.di.annotation.Autowire;
import com.dd.di.annotation.Component;
import com.dd.di.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OrderService {

  @Autowire
  private PaymentService paymentService;

  @PostConstruct
  public void init() {
    System.out.println("PaymentService.init");
  }

  public void order() {
    paymentService.pay();
    log.info("OrderService.order");
  }

}

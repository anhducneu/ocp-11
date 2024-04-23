package com.dd.di.service;

import com.dd.di.annotation.Component;
import com.dd.di.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PaymentService {

  @PostConstruct
  public void init() {
    System.out.println("PaymentService.init");
  }

  public void pay() {
    log.info("PaymentService.pay");
  }

}

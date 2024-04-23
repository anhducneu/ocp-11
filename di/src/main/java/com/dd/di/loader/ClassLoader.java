package com.dd.di.loader;

import com.dd.di.annotation.Autowire;
import com.dd.di.annotation.Component;
import com.dd.di.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;

@Slf4j
public class ClassLoader {

  private static ClassLoader instance;
  private final Map<String, Object> container = new HashMap<>();

  public static ClassLoader getInstance() {
    if (instance == null) {
      synchronized (ClassLoader.class) {
        if (instance == null) {
          instance = new ClassLoader();
        }
      }
    }
    return instance;
  }

  public void load(String packageName) {
    var reflections = new Reflections(packageName);
    var classes = reflections.getTypesAnnotatedWith(Component.class);

    initiateInstance(classes);

    for (var clazz : classes) {
      var instance = container.get(clazz.getName());
      injectFieldValue(instance);
      postConstruct(instance);
    }
    executeRunner();
    System.out.println("ClassLoader.load");
  }

  private void initiateInstance(Set<Class<?>> classes) {
    for (var clazz : classes) {
      log.info("Initiating class: {}", clazz.getName());
      try {
        var instance = clazz.getDeclaredConstructor().newInstance();
        container.put(clazz.getName(), instance);

        log.info("Initiated class: {}", instance.getClass().getName());
      } catch (Exception e) {
        log.error("Failed to initiate class: {}", clazz);
      }
    }

    System.out.println("ClassLoader.initiateInstance");
  }

  private void injectFieldValue(Object instance) {
    var fields = instance.getClass().getDeclaredFields();
    Arrays.stream(fields)
        .filter(field -> field.isAnnotationPresent(Autowire.class))
        .forEach(field -> {
          try {
            field.setAccessible(true);
            field.set(instance, container.get(field.getType().getName()));
          } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to inject field: " + field);
          }
        });
  }

  private void postConstruct(Object instance) {
    var methods = instance.getClass().getDeclaredMethods();
    var optional = Arrays.stream(methods)
        .filter(method -> method.isAnnotationPresent(PostConstruct.class))
        .findAny();

    if(optional.isPresent()) {
      try {
        var method = optional.get();
        method.setAccessible(true);
        method.invoke(instance);
      } catch (Exception e) {
        throw new RuntimeException("Failed to invoke post construct method: " + optional.get());
      }
    }
  }

  private void executeRunner() {
    container.values().stream()
        .filter(clazz -> clazz instanceof Runner)
        .map(clazz -> (Runner) clazz)
        .forEach(Runner::run);
  }

  public <T> T getBean(Class<T> clazz) {
    return (T) container.get(clazz.getName());
  }

}

package com.dd.core.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import javax.swing.JLabel;

class Reflection {


  public static void main(String[] args) throws Exception {

//    Class c=Class.forName("Simple");
//    System.out.println(c.getName());

//    Simple s = new Simple();
//    Class c = s.getClass();
//    System.out.println(c.getName());

//    Simple s = new Simple();
//    Class c = Simple.class;
//    System.out.println(c.isInterface());


    //New Instance with no-arg constructor
//    try {
//      Class c = Simple.class;
//      Simple s = (Simple) c.newInstance();
//      s.message();
//      System.out.println(c.getName());
//
//    } catch (Exception e) {
//      System.out.println(e);
//    }

    //New Instance with arg constructor
//    Class[] t = {String.class};
//
//    Class classRef = Class.forName("javax.swing.JLabel");
//    System.out.println(classRef.getName());
//
//    Constructor constructor = classRef.getConstructor(t);
//
//    Object[] arg = {"My JLabel in Reflection."};
//    Object obj = constructor.newInstance(arg);
//
//    if (obj instanceof JLabel) {
//      System.out.println(((JLabel)obj).getText());
//    }


    Class clazz = Class.forName("javax.swing.JLabel");
    Field[] fields = clazz.getDeclaredFields();

    for(int i = 0;i<fields.length;i++) {
      System.out.println(fields[i].getName());
    }

    Constructor[] constructors = clazz.getConstructors();

    for(int i = 0;i<constructors.length;i++) {
      System.out.println(constructors[i].getName());
    }

    Method[] methods = clazz.getMethods();

    for(int i = 0;i<methods.length;i++) {
      System.out.println(methods[i].getName());
    }


  }

}


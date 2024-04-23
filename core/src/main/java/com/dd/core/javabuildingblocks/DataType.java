package com.dd.core.javabuildingblocks;

public class DataType {

  public static void main(String[] args) {

    boolean boolValue = true;
    byte byteValue = 1; // 8bits
    short shortValue = 123; // 16bits
    int intValue = 1234; // 32bits
    long longValue = 123456789L; // 64bits
    float floatValue = 123.123f; // 32bits float point value
    double doubleValue = 123.123; // 64bits float point value
    char charValue = 'a'; // 16bits unicode value

    int s1, s2 = 1, s3 = 2;

    short bird = 'd';
    char m = (short) 84; // unsigned only

    int x;
    x = 1;
    System.out.println(x);

    int wolf = 5;
    int coyote = (wolf = 3);
    System.out.println(wolf);
    System.out.println(coyote);


  }

}

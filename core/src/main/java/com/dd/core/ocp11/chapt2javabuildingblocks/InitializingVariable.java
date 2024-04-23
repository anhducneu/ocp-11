package com.dd.core.ocp11.chapt2javabuildingblocks;

public class InitializingVariable {

    static String CLASS_VARIABLE; //Or STATIC_VARIABLE
    private String instanceVariable;

//    var value = "ABC";        // DOESN'T COMPILE because var is used for local variable only

    private Integer instanceVariable2;

    public static void main(String[] args) {

        double value;
//        localVariable(value);     // DOESN'T COMPILE

        InitializingVariable var = new InitializingVariable();
        System.out.println("Value: " + var.instanceVariable);
        System.out.println("Value: " + var.instanceVariable2);
    }

    private static void localVariable(String value){
        int localVariable1;
        int localVariable2 = 2;
//        if (localVariable2 == 2) {
//            localVariable = 3;
//        } else {
//            localVariable = 4;
//        }
//        int z = localVariable + localVariable2;       // DOESN'T COMPILE
    }

    private static void localVariableTypeInference(String value) {
        var localVariableTypeInference = "ABC";
        var x = 10;
//        int x = 1, var y = 1;     // DOESN'T COMPILE
//        var x = 1, y = 1;      // DOESN'T COMPILE
//        var n = null;     // DOESN'T COMPILE
//        var x;        // DOESN'T COMPILE
//        x = 1
        var x1 = "Hello";
        x1 = null;
//        var x2 = 1;
//        x2 = null;      // DOESN'T COMPILE
        var x3 = (String) null;
        var var = "abc";

//    Default value
//    boolean: false
//    byte, short, int, long: 0
//    float, double: 0.0
//    char: '\u0000' (NUL)
//    All object references (everything else) null

    }

}

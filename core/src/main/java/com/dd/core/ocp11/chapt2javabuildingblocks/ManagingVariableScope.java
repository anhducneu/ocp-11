package com.dd.core.ocp11.chapt2javabuildingblocks;

public class ManagingVariableScope {


    public static void main(String[] args) {

    }

    private static void localScope(String x) {      //Local variables
        String y = "Local";     //Local variables

        if(x.equals("limit")) {
            int z = 1;
            {
                int a = 1;
                System.out.println(a);
            }
//            System.out.println(a);      //DOESN'T COMPILE
        }
        //z goes out of scope here
//        System.out.println(z);      //DOESN'T COMPILE
    }

}

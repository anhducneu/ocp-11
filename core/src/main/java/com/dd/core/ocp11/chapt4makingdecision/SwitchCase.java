package com.dd.core.ocp11.chapt4makingdecision;

public class SwitchCase {

    public static void main(String[] args) {
        short dayOfWeek = 2;
        final int small = 12;
        switch(dayOfWeek) {
            case 0:
            case small:
                System.out.println("Sunday");
            case 677:
                System.out.println("Saturday");
            default:
                System.out.println("Weekday");
                break;

        }



    }

}

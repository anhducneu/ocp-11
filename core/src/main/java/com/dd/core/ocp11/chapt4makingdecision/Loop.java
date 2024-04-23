package com.dd.core.ocp11.chapt4makingdecision;

public class Loop {
    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,5};
        INNER_LOOP: for(int i=1;i<10;++i) {
            System.out.println("i: " + i);

            OUTER_LOOP: for(int j = 0;j<10;j++) {
                System.out.print("j: " + j);
                break OUTER_LOOP;
            }

        }
        search();

    }

    public static int[] search() {
        int checkDate = 0;
        while(checkDate<10) {
            checkDate++;
            if(checkDate>100) {
                checkDate++; // DOES NOT COMPILE
            }
        }
        int x = 1;
        int y = 2;
        int z = 0;
        z += x + y + 1;
        System.out.println(z);
        return null;
    }
}

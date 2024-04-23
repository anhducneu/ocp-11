package com.dd.core.ocp11.chapt5corejavaapis;

import java.util.*;

public class ArrayListSample {
    public static void main(String[] args) {

        List<Object> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(Integer.valueOf(0));
        list1.add(null);
        list1.add(null);
        print(list1);

        list1.remove(Integer.valueOf(0));
        print(list1);

        list1.remove(0);
        print(list1);

        list1.removeIf(i -> i instanceof Integer && (Integer)i > 1);
        print(list1);

        Object[] arr = list1.toArray(new Object[0]);
        list1.clear();

        String[] arr1 = {"hawk", "robin"};
        List<String> list2 = Arrays.asList(arr1); // Return a fixed-size list & relate to array
        list2.set(1, "d");
        System.out.println(Arrays.toString(arr1));
        List<String> list3 = List.of(arr1); //Return Immutable list


        List<String> list4 = Arrays.asList("a", "b", "c"); // Return a fixed-size list

        List<String> list5 = List.of("a", "b", "c"); //Return Immutable list

        List<String> list6 = new ArrayList<>(list5);

        Collections.sort(list4);

        List z = new ArrayList<String>();
    }

    public static void print(List<Object> list) {
        System.out.println("");
        for(Object o: list) {
            System.out.print(o + ",");
        }
    }
}

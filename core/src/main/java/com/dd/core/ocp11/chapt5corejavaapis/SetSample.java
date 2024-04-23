package com.dd.core.ocp11.chapt5corejavaapis;

import java.util.*;

public class SetSample {

    public static void main(String[] args) {

        Set<String> set1 = new HashSet<String>();
        System.out.println(set1.add("a"));
        System.out.println(set1.add("b"));
        System.out.println(set1.add("b"));
        set1.remove("b");
        System.out.println(set1.isEmpty());
        System.out.println(set1.size());
    }
}

package com.dd.core.ocp11.chapt5corejavaapis;

import java.util.*;

public class HashMapSample {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("a", "AAA");
        map.putIfAbsent("b", "BBB");
        map.putIfAbsent("b", "BBB_FAKE");
        map.putIfAbsent("c", "CCC");
        map.putIfAbsent("d", "DDD");

        System.out.println(map.get("a"));
        System.out.println(map.getOrDefault("x", "XXX"));
        System.out.println(map.containsKey("a"));
        System.out.println(map.containsValue("BBB"));
        System.out.println(map);

        for(String key : map.keySet()) {
            System.out.println("Key: " + key + "|Value: " + map.get(key));
        }

    }
}

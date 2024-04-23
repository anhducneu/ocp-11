package com.dd.core.ocp8.chapter3genericsandcollections;

import java.util.*;

public class Crate<T, N> {

    private List<T> contents = new ArrayList<>();
    private N size;

    public T emptyCrate() {
        return contents.get(0);
    }

    public List<T> add(T contents) {

        this.contents.add(contents);
        return this.contents;
    }

    public static <E> void sink(E element) {}

    public <K> K identify(K key) {
        return key;
    }

    public static void main(String[] args) {

        Crate<String, Long> crate = new Crate<>();
        crate.add("Test");
        System.out.println(crate.emptyCrate());

    }

}

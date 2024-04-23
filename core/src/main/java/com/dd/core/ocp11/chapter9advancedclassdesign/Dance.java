package com.dd.core.ocp11.chapter9advancedclassdesign;

interface Dance {

    public static final int MAX = 10;

    void step();

    default void start() {
        System.out.println(this.MAX);;
        this.intern();
    }

    private void intern() {
        System.out.println("abc");
    }

}

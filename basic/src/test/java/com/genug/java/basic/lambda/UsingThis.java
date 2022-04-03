package com.genug.java.basic.lambda;

public class UsingThis {
    public int outterField = 10;

    class Inner {
        int innerField = 20;
        void method() {
            TestFunctionalInterface fi = () -> {
                System.out.println("outterField: " + outterField);
                System.out.println("UsingThis.this.outterField: " + UsingThis.this.outterField + "\n");

                System.out.println("innerField: " + innerField);
                System.out.println("this.innerField: " + this.innerField + "\n");
            };
            fi.method();
        }
    }
}

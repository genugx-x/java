package com.genug.java.basic.lambda;

@FunctionalInterface // 두 개 이상의 추상 메소드를 선언하게 되면 컴파일 예외 발생.
public interface Calculator {
    int sum(int a, int b);
}

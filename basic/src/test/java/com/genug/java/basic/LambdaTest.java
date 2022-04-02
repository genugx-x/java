package com.genug.java.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LambdaTest {

    @Test
    @DisplayName("람다 기초 - Runnable 활용")
    void test_1() {
        // 기본적인 Runnable 인터페이스 익명 구현 객체 생성 코드
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // 코드
            }
        };

        // 람다식
        runnable = () -> {
            //코드
        };


    }
}

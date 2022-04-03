package com.genug.java.basic.lambda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    @DisplayName("14.3.1 타겟 타입과 함수적 인터페이스 - 함수적 인터페이스 (@FunctionalInterface)")
    void test_2() {
        // 인터페이스 변수 = 람다식;
        TestFunctionalInterface fi = () -> {
            // 실행 코드
        };
    }

    @Test
    @DisplayName("14.3.2 매개 변수가 없는 람다식)")
    void test_3() {
        // 인터페이스 변수 = 람다식;
        TestFunctionalInterface fi = () -> {
            System.out.println("[log] fi.method called - first");
        };
        fi.method();
        fi = () -> System.out.println("[log] fi.method called - second");
        fi.method();
    }

    @Test
    @DisplayName("14.3.3 매개 변수가 있는 람다식")
    void test_4() {
        // 인터페이스 변수 = 람다식;
        TestFunctionalInterfaceWithArg fi = (i) -> {
            System.out.println("[log] fi.method called - first --- i:" + i);
        };
        fi.method(1);
        fi = (i) -> System.out.println("[log] fi.method called - second --- i:" + i);
        fi.method(2);
    }

    @Test
    @DisplayName("14.3.4 리턴값이 있는 람다식")
    void test_5() {
        // 인터페이스 변수 = 람다식;
        TestFunctionalInterfaceWithReturnValue fi = (b) -> b;
        System.out.println("[log] fi.method called - first --- " + fi.method(true));
        fi = (b) -> !b;
        System.out.println("[log] fi.method called - first --- " + fi.method(true));

        Calculator cal = (a, b) -> a+b;
        System.out.println("[log] cal.sum called --- " + cal.sum(1, 2));


    }
    
    @Test
    @DisplayName("14.4.1 클래스의 멤버 사용")
    void test_6() {
        UsingThis usingThis = new UsingThis();
        UsingThis.Inner inner = usingThis.new Inner();
        inner.method();
    }
}

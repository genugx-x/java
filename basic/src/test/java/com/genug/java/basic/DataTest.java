package com.genug.java.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DataTest {

    @Test
    @DisplayName("1. 여러 라인으로 되어 있는 문자열을 라인별 List로 변경")
    void test_1() {
        String string = "aaa\nbbb\nccc";
        System.out.println(string);

        String[] strings = string.split("\n");
        for (String s : strings) {
            System.out.println(s);
        }
    }
}

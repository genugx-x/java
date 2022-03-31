package com.genug.java.basic.date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalDateCalculatorTest {

    @Test
    @DisplayName("LocalDate.plusMonth(또는 minusMonth 메서드 사용 시 일이 다른 경우 (31 -> 30, 31 -> 28, 31 -> 29)")
    void test_1() {
        assertEquals(
                LocalDate.of(2022, 4, 30),
                LocalDate.of(2022, 3, 31).plusMonths(1)
        );
        assertEquals(
                LocalDate.of(2022, 2, 28),
                LocalDate.of(2022, 1, 31).plusMonths(1)
        );
        assertEquals(
                LocalDate.of(2024, 2, 29),
                LocalDate.of(2024, 1, 31).plusMonths(1)
        );
    }

    @Test
    @DisplayName("LocalDate.plusMonth(또는 minusMonth) 메서드 사용 시 일이 다른 경우 (30 -> 31)")
    void test_2() {
        LocalDateCalculator calculator = new LocalDateCalculator();
        assertEquals(
                LocalDate.of(2022, 5, 31),
                calculator.plusMonths(LocalDate.of(2022, 4, 30), 1)
        );
        assertEquals(
                LocalDate.of(2022, 3, 31),
                calculator.plusMonths(LocalDate.of(2022, 4, 30), -1)
        );
    }

    @Test
    @DisplayName("2월 말일인 경우")
    void test_3() {
        LocalDateCalculator calculator = new LocalDateCalculator();
        assertEquals(
                LocalDate.of(2022, 3, 31),
                calculator.plusMonths(LocalDate.of(2022, 2, 28), 1)
        );
    }

}

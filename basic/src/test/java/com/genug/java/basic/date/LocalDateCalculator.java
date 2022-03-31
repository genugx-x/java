package com.genug.java.basic.date;

import java.time.LocalDate;

public class LocalDateCalculator {


    // LocalDate로는 해당 월의 마지막 일을 알아내기가 쉽지 않은듯.
    // Calender로 접근하여 해당 월의 마지막 일자를 가져와서 처리
    public LocalDate plusMonths(LocalDate localDate, int plusMonthAmount) {
        LocalDate result = null;
        int plusDaysAmount = 0;
        int monthValue = localDate.getMonthValue();
        if (monthValue % 2 == 0) { // 짝수 월
            if (monthValue == 2) { // 2월인 경우
                if (localDate.getDayOfMonth() >= 28) {
                    result = plusMonthsAndDays(localDate, plusMonthAmount, 31);
                } else {
                    result = plusMonthsAndDays(localDate, plusMonthAmount, 1);
                }
            } else if (monthValue == 8) { // 8월인 경우

            } else {
                result = plusMonthsAndDays(localDate, plusMonthAmount, 1);
            }
        } else { // 홀수 월
        }

        return result;
    }

    public LocalDate plusMonthsAndDays(LocalDate localDate, int plusMonthsAmount, int plusDaysAmount ) {
        return localDate.plusMonths(plusMonthsAmount).plusDays(plusDaysAmount);
    }

}

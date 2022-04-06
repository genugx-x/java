package com.genug.java.basic.data;

import java.util.Queue;

public class Data {
    private StringBuilder stringBuilder;
    private Queue<Queue<String>> dataIntervals;

    public Data(StringBuilder stringBuilder, Queue<Queue<String>> dataIntervals) {
        this.stringBuilder = stringBuilder;
        this.dataIntervals = dataIntervals;
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public void setStringBuilder(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    public Queue<Queue<String>> getDataIntervals() {
        return dataIntervals;
    }

    public void setDataIntervals(Queue<Queue<String>> dataIntervals) {
        this.dataIntervals = dataIntervals;
    }
}

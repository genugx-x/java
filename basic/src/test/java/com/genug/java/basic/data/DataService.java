package com.genug.java.basic.data;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DataService {

    public void connectString(Data data) throws IOException {
        StringBuilder sb = data.getStringBuilder();
        Queue<String> lines = new LinkedList<>(
                IOUtils.readLines(new StringReader(sb.toString()))
        );
        List<String> deleteList = new ArrayList<>();
        Queue<Queue<String>> dataIntervals = data.getDataIntervals();
        Queue<String> dataInterval = null;
        boolean flag = false;
        while (!lines.isEmpty()) {
            String line = lines.poll();
            deleteList.add(line);
            if (line.toUpperCase().contains("<-- TARGET")) {
                flag = true;
                dataInterval = new LinkedList<>();
            }
            if (flag) {
                dataInterval.add(line);
            }
            if (line.toUpperCase().contains("--> TARGET")) {
                dataIntervals.add(dataInterval);
                for (String s : deleteList) {
                    char[] chars = new char[s.length()];
                    sb.getChars(0, s.length(), chars, 0);
                    for (char c : chars) {
                        System.out.print(c);
                    }
                    System.out.println();
                    sb.delete(0, s.length() + 2);
                    System.out.println(s + "* <--- DELETED");
                    System.out.println();
                    flag = false;
                }
            }

        }

    }
}

package com.genug.java.basic;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringReader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

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

    @Test
    @DisplayName("2. StringBuilder 문자열 delete 테스트")
    void test_2() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("AAA").append("\n")
                .append("GQ EVSE[02:17:0167] --> PowerDelivery")
                .append("BBFB").append(System.lineSeparator())
                .append("CCC").append("\n");

        System.out.println(sb.toString());
        List<String> lines = IOUtils.readLines(new StringReader(sb.toString()));


        for (String line : lines) {
            int length = line.length();
            System.out.println("length: " + length);
            sb.delete(0, length+1);
            System.out.println(sb.toString());
            System.out.println();
        }
    }

    @Test
    @DisplayName("3. StringBuilder delete 기능 테스트")
    void test_3() throws IOException {
        FileChannel fileChannel = null;
        try {
            Path path = Paths.get("./string_builder_delete_test.log");
            fileChannel = FileChannel.open(path, StandardOpenOption.READ);
            ByteBuffer buffer = ByteBuffer.allocate(1000);
            int byteCount = 0;
            StringBuilder sb = new StringBuilder();
            while (true) {
                buffer.clear();
                byteCount = fileChannel.read(buffer);
                if (byteCount == -1) {
                    break;
                }
                buffer.flip();
                String contents = StandardCharsets.UTF_8.decode(buffer).toString();
                System.out.println(contents);
                sb.append(contents);
            }
            // System.out.println(sb.toString());
            List<String> lines = IOUtils.readLines(new StringReader(sb.toString()));
            for (String line : lines) {
                System.out.println(sb.toString());
                sb.delete(0, line.length()+2);
                System.out.println("--------------------------------------------------------");
            }
            System.out.println(sb.toString());
        } catch(IOException e){
            e.printStackTrace();
        } finally {
            if (fileChannel != null && fileChannel.isOpen())
                fileChannel.close();
        }
    }
}

package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {

    public static Map<Long, String> valuesMap = new HashMap<>();;
    public static void main(String[] args) throws IOException {
        File valuesFile = new File(args[0]);
        File testsFile = new File(args[1]);
        File resultFile = new File(args[2]);

        ObjectMapper mapper = new ObjectMapper();

        ValuesRoot valuesRoot = mapper.readValue(valuesFile, ValuesRoot.class);
        for (Value value: valuesRoot.values) {
            valuesMap.put(value.id, value.value);
        }

        TestsRoot testsRoot = mapper.readValue(testsFile, TestsRoot.class);

        for (Test test: testsRoot.tests) {
            fillResult(test);
        }

        mapper.writeValue(resultFile, testsRoot);
    }

    public static void fillResult(Test test) {
        test.value = valuesMap.get(test.id);
        if (test.values != null) {
            for (Test subtest: test.values) {
                fillResult(subtest);
            }
        }
    }

    public static class Value {
        public long id;
        public String value;
    }

    public static class ValuesRoot {
        public List<Value> values;
    }

    public static class Test {
        public long id;
        public String title;
        public String value;
        public List<Test> values;
    }

    public static class TestsRoot {
        public List<Test> tests;
    }
}
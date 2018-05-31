package net.orangepeels.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    @org.junit.Test
    public void hi(){
        List<List<String>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList("123213","123123","12321312")));
        list.add(new ArrayList<>(Arrays.asList("456456","456456","45645656")));
        String json = JSONtools.toJSON(list);
    }
}

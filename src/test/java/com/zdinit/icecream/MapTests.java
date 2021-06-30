package com.zdinit.icecream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapTests {
    public static void main(String[] args) {
        Map m = new HashMap();
        m.put("1","1");
        m.put("1","2");
        m.put("1","3");
        System.out.println(m.get("1"));


        List<String> list = new ArrayList();
        list.add("1");
        list.add("3");
        list.add("4");
        list.add("5");
        Map mm = list.stream().collect(Collectors.toMap(s -> "1",s -> s));
        System.out.println(mm.get("1"));
    }
}

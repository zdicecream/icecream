package com.zdinit.icecream;

import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompareTest {


    public static void main(String[] args) {
        List<menu> nemuList = new ArrayList<>();
        nemuList.add(new menu("1001"));
        nemuList.add(new menu("10011"));
        nemuList.add(new menu("1010"));
        nemuList.add(new menu("01010"));
        nemuList.add(new menu("1003"));
        nemuList.add(new menu("0000001"));
        nemuList.add(new menu("1004"));
        nemuList.add(new menu("1011"));
        nemuList.add(new menu("1011"));
        nemuList.add(new menu("s1011"));

        nemuList.sort(new Comparator<menu>() {
            @Override
            public int compare(menu o1, menu o2) {
                return (Integer.parseInt(o1.getCode())-Integer.parseInt(o2.getCode()));
            }
        });

        nemuList.stream().forEach(menu -> System.out.println(menu.getCode()));
    }

}
@Data
class menu {
    String code;
    public menu(String code){
        this.code = code;
    }


}

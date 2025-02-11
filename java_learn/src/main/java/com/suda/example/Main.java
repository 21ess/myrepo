package com.suda.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // java实现泛型的方式是类型擦除
        //
        //List<String> list = new ArrayList<>();
        //System.out.println(list.getClass());    // class java.util.ArrayList
        //List<Object> listObj;
        //listObj = list; // 编译报错
        ArrayList<String> list = new ArrayList<String>() {
            @Override
            public String toString() {
                return Integer.toString(this.size());
            }
        };
        System.out.println(list.getClass().getGenericSuperclass());

        String[] strings = new String[100];
        Object[] objs;
        System.out.println(strings.getClass());
        objs = strings;
        System.out.println(objs.getClass());
    }

    private static void hello() {
        System.out.println("Hello world!");
    }


}



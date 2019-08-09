package com.lee.poi.demo.util;

import java.util.*;

public class QueueUtils {

    private static final List<String> list = new LinkedList();

    private static final String[] args = {"aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii", "jj", "kk"};

    static {
        init();
    }

    public static String out() {
        String s = list.get(0);
        list.remove(0);
        return s;
    }

    public static void in(String str) {
        list.add(str);
    }

    private static void init() {
//        String[] args = {"aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii", "jj", "kk"};
        List<String> c = Arrays.asList(args);
        list.addAll(c);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 22; i++) {
            String out = QueueUtils.out();
            System.out.println(out);
            QueueUtils.in(out);
        }
    }
}

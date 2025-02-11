package com.suda.example.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class huawei1016q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expr = br.readLine();
        String ans = dfs(expr);
        System.out.println(ans);
        br.close();
    }

    private static String dfs(String expr) {
        if (expr.length() == 0) return "";

        // 除去最外层的括号（这些括号无法构成有效子表达式）
        int start = 0;
        while (expr.charAt(start) == '(' && expr.charAt(expr.length() - 1 - start) == ')') {
            start++;
        }
        if (start * 2 == expr.length()) return expr;
        start -= 1;
        
        ArrayList<String> list = new ArrayList<>();
        int last = start;
        for (int i = start, cnt = 0; i < expr.length() - start; i++) {
            // 分割括号表达式
            if (expr.charAt(i) == '(') {
                cnt++;
            } else {
                cnt--;
                if (cnt == 0) {
                    list.add(expr.substring(last, i + 1));
                    last = i + 1;
                }
            }
        }
        // list.forEach(System.out::println);
        // 对于每子表达式，都是最大的
        for (int i = 0; i < list.size(); i ++ ) {
            String str = list.get(i);
            list.set(i, dfs(str));
        }

        list.sort(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                String a = o1 + o2;
                String b = o2 + o1;
                return a.compareTo(b);
            }

        });
        StringBuffer stringBuffer = new StringBuffer();
        for (String string : list) {
            stringBuffer.append(string);
        }
        StringBuffer prex = new StringBuffer();
        StringBuffer tail = new StringBuffer();
        for (int i = 0; i < start; i ++ ) {
            prex.append('(');
            tail.append(')');
        }
        return prex.append(stringBuffer).append(tail).toString(); 
    }
}

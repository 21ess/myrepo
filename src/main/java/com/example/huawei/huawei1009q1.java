package com.example.huawei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/*
 * 编辑距离问题
 * 
 */

public class huawei1009q1 {
    static char[] c1 = new char[] { 'w', 'i', 'r', 'e', 'l', '@', 'c', 'o', 'm' };
    static char[] c2 = new char[] { 'h', 'f', 'v', '#', 'g', 'b', 't', 's' };
    static HashSet<Character> set1;
    static HashSet<Character> set2;
    static int f[][] = new int[2010][2010];

    static {
        for (int i = 0; i < f.length; i++)
            Arrays.fill(f[i], (int) 0x3f3f3f3f);
        set1 = new HashSet<>();
        set2 = new HashSet<>();
        for (int i = 0; i < c1.length; i++) {
            set1.add(c1[i]);
        }
        for (int i = 0; i < c2.length; i++) {
            set2.add(c2[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        a = " " + a;
        b = " " + b;
        // System.out.println(a.length());
        // System.out.println(b.length());

        init(a, b);
        for (int i = 1; i < a.length(); i++) {
            for (int j = 1; j < b.length(); j++) {
                f[i][j] = Math.min(f[i][j], f[i][j-1] + 3);
                f[i][j] = Math.min(f[i][j], f[i-1][j] + 3);
                char ca = a.charAt(i);
                
                char cb = b.charAt(j);
                if (ca != cb) {
                    if (set1.contains(ca) && set1.contains(cb)) {
                        f[i][j] = Math.min(f[i][j], f[i-1][j-1] + 1);
                    }else if (set2.contains(ca) && set2.contains(cb)) {
                        f[i][j] = Math.min(f[i][j], f[i-1][j-1] + 1);
                    }else if (set1.contains(ca) && set2.contains(cb)) {
                        f[i][j] = Math.min(f[i][j], f[i-1][j-1] + 2);
                    }else if (set1.contains(cb) && set2.contains(ca)) {
                        f[i][j] = Math.min(f[i][j], f[i-1][j-1] + 2);
                    }else {
                        f[i][j] = Math.min(f[i][j], f[i-1][j-1] + 3);
                    }
                }else {
                    f[i][j] = Math.min(f[i][j], f[i-1][j-1]);
                }
            }
        }

        System.out.println(f[a.length()-1][b.length()-1]);
    }

    private static void init(String a, String b) {
        for (int i = 0; i < a.length(); i ++ ) f[i][0] = i * 3;
        for (int j = 0; j < b.length(); j ++ ) f[0][j] = j * 3;
    }
}

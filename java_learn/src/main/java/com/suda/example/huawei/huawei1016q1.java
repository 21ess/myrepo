package com.suda.example.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class huawei1016q1 {
    static int n;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] strings = br.readLine().split(" ");
        int [] a = new int[n + 1];
        Arrays.fill(a, 0);
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(strings[i-1]);
            a[i] += a[i-1];
        }
        
        int ans = Integer.MAX_VALUE;
        for (int r = 1, l = 1; r <= n; r ++ ) {
            int sumMx = a[l-1] + a[n] - a[r];
            int sumVec = (a[r] - a[l-1]) * 6;
            //System.out.println(sumMx + " " +sumVec);
            ans = Math.min(ans, Math.max(sumMx, sumVec));
            while (l < r && sumMx <= sumVec) {
                l ++;
                sumMx = a[l-1] + a[n] - a[r];
                sumVec = (a[r] - a[l-1]) * 6;
                //System.out.println(sumMx + " " +sumVec);
                ans = Math.min(ans, Math.max(sumMx, sumVec));
            }
        }
        System.out.println(ans);
        br.close();
        
    }
}
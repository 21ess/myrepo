package com.example.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class huawei0919q3 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int[] a = new int[n*n];
        for (int i = 0; i < n * n; i ++ ) a[i] = Integer.parseInt(inputs[i]);
        int left = 0;
        int length = n == 1 ? 1 : 2 * (2 * n - 2);
        ArrayList<Integer> subRes = new ArrayList<Integer>();
        while (left < n * n) {
            int right = left + length;
            subRes.add(a[left]);
            int idx = right - 1;
            while (idx > left) {
                subRes.add(a[idx]);
                idx --;
            }
            left = right;
            if (length - 8 == 0) length = 1;
            else length -= 8;
        }
        for (int i = 0; i < a.length; i++) {
            if (i < a.length - 1)System.out.print(subRes.get(i) + " ");
            else System.out.println( subRes.get(i));
        }
        br.close();
    }
}

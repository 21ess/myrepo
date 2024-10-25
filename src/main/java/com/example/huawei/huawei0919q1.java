package com.example.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;

public class huawei0919q1 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        int [] a = new int[n];
        // 保存16进制权重
        for (int i = 0; i < n; i ++ ) {
            int t = Integer.parseInt(nums[i]);
            int val = 0;
            while (t > 0) {
                val += t % 16;
                t /= 16;
            }
            a[i] = val;
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> subRes = new ArrayDeque<>();
        // 单调队列
        for (int i = n - 1; i >= 0; i -- ) {
            System.out.println(a[i]);
            while (stack.size() > 0 && a[stack.peekFirst()] <= a[i]) {
                stack.pollFirst();
            }
            if (stack.size() == 0) subRes.addFirst(-1);
            else subRes.addFirst(stack.peekFirst());
            stack.addFirst(i);
        }
        Iterator<Integer> iterator = subRes.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        br.close();
    }
}

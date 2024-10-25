package com.example.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class huawei0919q2 {
    
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String in = br.readLine();
        n = Integer.parseInt(in);
        String[] inpuStrings = br.readLine().split(" ");
        int [] a = new int[n];
        for (int i = 0; i < n; i ++ ) {
            a[i] = Integer.parseInt(inpuStrings[i]);   
        }
        
        System.out.println(dfs(0, n - 1, a));
        br.close();
    }

    private static int dfs(int l, int r, int[] a) {
        if (l > r) return 0;
        if (l == r) return 2;
        
        int minH = Integer.MAX_VALUE;
        ArrayList<Entry> list = new ArrayList<>();
        for(int i = l; i <= r; i ++ ) {
            if (minH > a[i]) minH = a[i];
        }
        // System.out.println(minH);
        int last = l;
        while (minH == a[last]) last ++;
        for (int i = last; i <= r; i ++ ) {
            if (a[i] == minH) {
                list.add(new Entry(last, i - 1));
                while (i <= r && a[i] == minH) i ++;
                last = i;
            } 
        }   
        if (last <= r) list.add(new Entry(last, r));
        int res = 1;
        for (Entry entry : list) {
            res += dfs(entry.left, entry.right, a);
        }
        return res;

    }
    static class Entry{
        int left;
        int right;
        public Entry(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

}


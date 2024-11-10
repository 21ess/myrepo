package com.example.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;

public class huawei1023q1 {

    static ArrayDeque<String> maxList;
    static int maxC;
    static HashMap<String,Integer> map;
    static HashMap<String, List<String>> table;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new HashMap<String, Integer>();
        for (int i = 0; i < n; i ++ ) {
            String[] kv = br.readLine().split(" ");
            map.put(kv[0], Integer.parseInt(kv[1]));
        }
        int m = Integer.parseInt(br.readLine().trim());
        String enter = null;
        table = new HashMap<String, List<String>>();
        for (int i = 0; i < m; i ++ ) {
            ArrayList<String> list = new ArrayList<>();
            Collections.addAll(list, br.readLine().split(" "));
            table.put(list.get(0), list);
            if (i == 0) enter = list.get(0);
        }
        int c = Integer.parseInt(br.readLine());
        
        ArrayDeque<String> path = new ArrayDeque<String>();
        path.add(enter);
        boolean ans = dfs(enter, path, map.get(enter), c);
        
        if (ans) {
            System.out.print("false ");
        } else {
            System.out.print("true ");
        }
        int length = maxList.size();
        for (int i = 0; i < length; i ++ ) {
            if (i == length - 1) {
                System.out.print(maxList.getFirst());
            }else {
                System.out.print(maxList.getFirst() + "-");
                maxList.pollFirst();
            }
        }
        System.out.println(" " + maxC);
    }

    private static boolean dfs(String cur, Deque<String> path, int curC, int c) {
        if(curC > c) {
            maxList = new ArrayDeque<String>(path);
            maxC = curC;
            return false;
        }
        
        if (curC > maxC) {
            maxList = new ArrayDeque<String>(path);
            maxC = curC;
        }
        
        ArrayList<String> list = (ArrayList) table.get(cur);
        if (list == null || list.size() == 0) return true;
        for (String node : list.subList(1, list.size())) {
            path.addLast(node);
            curC += map.get(node);
            if (!dfs(node, path, curC, c)) return false; 
            path.pollLast();
            curC -= map.get(node);
        }
        return true;
    }

}

package com.example.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class huawei1023q2 {
    static int[] head = new int[8250];
    static int[] e = new int[8250], ne = new int[8250];
    static int idx;
    static int[][] f = new int[8250][3];

    static {
        Arrays.fill(head, -1);
        for (int i = 0; i < f.length; i++)
            for (int j = 0; j < f[0].length; j++) {
                f[i][j] = (int)1e9;
            }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = Arrays.stream(br.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < a.length; i = i * 2 + 1) {
            for (int j = i * 2 + 1, cnt = 0, t = i; j <= 2 * (i * 2 + 1) && j < a.length; j++, cnt++) {
                if (cnt == 2) {
                    t++;
                    cnt = 0;
                }
                if (a[t] == 1 && a[j] == 1) add(t, j);
                System.out.print(j + " ");
            }
            System.out.println();
        }
        dfs(0);
        System.out.println(Math.min(f[0][1], f[0][0]));
    }

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = head[a];
        head[a] = idx++;
    }

    private static void dfs(int cur) {
        // 叶子节点
        if (head[cur] == -1) {
            f[cur][0] = 1;
            f[cur][1] = (int)1e9;
            f[cur][2] = 0;
            for (int i = 0; i < 3; i ++ ) {
                System.out.print(" " + f[cur][i]);
            }
            System.out.println();
            return;
        }

        ArrayList<Integer> childs = new ArrayList<Integer>();
        for (int i = head[cur]; i != -1; i = ne[i]) {
            int t = e[i];
            dfs(t);
            childs.add(t);
        }
        System.out.print(cur + " " +childs);
        if (childs.size() == 1) {
            int t = childs.get(0);
            f[cur][0] = Math.min(f[t][0], Math.min(f[t][1], f[t][2])) + 1;
            f[cur][1] = f[t][0];
            f[cur][2] = f[t][1];
        } else {
            int l = childs.get(0);
            int r = childs.get(1);
            f[cur][0] = Math.min(f[l][0], Math.min(f[l][1], f[l][2])) +
                    Math.min(f[r][0], Math.min(f[r][1], f[r][2])) + 1;
            f[cur][1] = Math.min(f[l][0] + Math.min(f[r][0], f[r][1]),
                    f[r][0] + Math.min(f[l][0], f[l][1]));
            f[cur][2] = f[l][1] + f[r][1];
        }
        for (int i = 0; i < 3; i ++ ) {
            System.out.print(" " + f[cur][i]);
        }
        System.out.println();
    }
}
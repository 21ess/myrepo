package com.suda.example.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
/**
 * @author alien
 * @program myrepo
 * @description
 * @date 2024/10/26$
 */
public class huawei1024q2 {

    public static int num;

    static  {
        num = 10;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        TreeNode root = new TreeNode(a[0]);
        ArrayDeque<TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.add(root);
        for (int i = 1; i < a.length; i ++ ) {
            if (a[i] == -1) {
                TreeNode fa = treeNodes.pollFirst();
                ArrayDeque<TreeNode> save = new ArrayDeque<>();
                for (int j = i + 1; j < a.length && a[j] != -1; j ++) {
                    save.addLast(new TreeNode(a[j]));
                }
                if (save.size() == 0) continue;
                TreeNode[] childs = new TreeNode[save.size()];
                for (int j = 0; j < childs.length; j ++ ) {
                    childs[j] = save.pollFirst();
                    treeNodes.addLast(childs[j]);
                }
                fa.setNext(childs);
            }
        }
        dfs(root);

        treeNodes.clear();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            TreeNode fa = treeNodes.pollFirst();
            if (fa.val == -1) {
                System.out.print(-1 + " ");
                continue;
            }
            System.out.print(fa.val + " ");
            treeNodes.addLast(new TreeNode(-1));
            if (fa.next == null) continue;
            for (TreeNode ch : fa.next) {
                treeNodes.addLast(ch);
            }
        }

        br.close();
    }

    private static int dfs(TreeNode root) {
        if (root == null) return 0;
        if (root.next == null ) return root.val;
        for (TreeNode treeNode : root.next) {
             root.val += dfs(treeNode);
        }
        return root.val;
    }

}

class TreeNode {
    TreeNode[] next;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode() {
    }

    public void setNext(TreeNode[] next) {
        this.next = next;
    }
}

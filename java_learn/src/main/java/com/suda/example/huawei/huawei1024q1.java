package com.suda.example.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class huawei1024q1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int [] a = Arrays.stream(inputs).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(a);
        // 考虑在每一步选择最长的且高度小于当前编号的箱子
        ArrayList<Integer> heightList = new ArrayList<>();
        for (int i = 0; i < a.length; i ++ ) {
            // height 数组是有序的，二分查找可以添加箱子的位置
            if (heightList.isEmpty()) heightList.add(1);
            int l = 0, r = heightList.size() - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (heightList.get(mid) > a[i]) l = mid + 1;
                else r = mid;
            }
            if (heightList.get(l) <= a[i]) {
                heightList.set(l, heightList.get(l) + 1);
            }else {
                heightList.add(1);
            }
        }
        System.out.println(heightList.size());
    }
}

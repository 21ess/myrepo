package com.suda.example.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;
import java.util.PriorityQueue;

/**
 * @author alien
 * @program myrepo
 * @description
 * @date 2024/10/27$
 */
public class huawei1024q3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int m = Integer.parseInt(bufferedReader.readLine());
        Task[] tasks = new Task[m];

        for(int i = 0; i < m; i ++ ) {
            String[] input = bufferedReader.readLine().split(" ");
            tasks[i] = new Task(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        // 排序
        // pre越小优先级越高
        Arrays.sort(tasks, (o1, o2) -> {
            return o1.pre == o2.pre ? o2.cost - o1.cost : o1.pre - o2.pre;
        });
        //for (int i = 0; i < tasks.length; i ++ ) {
        //    System.out.println(tasks[i].cost + " " + tasks[i].pre);
        //}
        // 建立小根堆
        PriorityQueue<Long> heap = new PriorityQueue<>();
        for (int i = 0; i < n; i ++ ) heap.offer(0l);

        long ans = 0L;
        for (Task task : tasks) {
            Long lastTime =heap.poll();
            lastTime += task.cost;
            ans = Math.max(lastTime, ans);
            heap.offer(lastTime);
            //System.out.println(lastTime);
        }
        Optional<Long> maxed = heap.stream().max((Long::compare));
        maxed.ifPresent(max -> System.out.println(max));
        bufferedReader.close();
    }
}

class Task{
    int cost;
    int pre;    // 优先级
    public Task(int cost, int pre) {
        this.cost = cost;
        this.pre = pre;
    }
}

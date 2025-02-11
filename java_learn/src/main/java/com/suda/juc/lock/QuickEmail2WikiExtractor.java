package com.suda.juc.lock;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author alien
 * @program myrepo
 * @description
 * @date 2024/12/29$
 */
public class QuickEmail2WikiExtractor {

    private ThreadPoolExecutor threadPool;

    private ArrayBlockingQueue<Object> emailQueue;

    public QuickEmail2WikiExtractor() {
        emailQueue = new ArrayBlockingQueue<>(1024 * 1024);
        int corePoolSize = Runtime.getRuntime().availableProcessors() * 2;
        threadPool = new ThreadPoolExecutor(
                corePoolSize,
                corePoolSize,
                101,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(2000));
    }

    public void extract() {
        new ExtractorEmailTask().start();
    }

    public void insertToQueue() throws InterruptedException {
        // 登录到wiki

        while (true) {
            Object email = emailQueue.poll(2, TimeUnit.SECONDS);
            if (email == null) {
                break;
            }
            threadPool.submit(new insertToWikiTask(email));
        }
    }

    protected List<Object> extractEmail() {
        //
        List<Object> allMails = null;
        if (allMails == null) {
            return null;
        }
        for (Object allMail : allMails) {
            emailQueue.offer(allMail);
        }
        return null;
    }

    public class ExtractorEmailTask extends Thread {
        @Override
        public void run() {
            extractEmail();
        }
    }
}
class insertToWikiTask extends Thread {

    public insertToWikiTask(Object email) {}
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

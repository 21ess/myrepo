package com.suda.juc.extractor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

/**
 * @author alien
 * @program myrepo
 * @description
 * @date 2024/12/29$
 */
public class MsgQueueManager implements IMsgQueue{
    public static BlockingQueue<Message> messageQueue = new LinkedTransferQueue<>();

    private MsgQueueManager() {}

    public void put(Message msg) {
        try {
            messageQueue.put(msg);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public Message take() {
        try {
            return messageQueue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return null;
    }

    static class DispatchMessageTask implements Runnable {
        @Override
        public void run() {
            BlockingQueue<Message> subQueue;
            for (;;) {
                try {
                    Message msg = messageQueue.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}

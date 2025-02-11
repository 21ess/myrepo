package com.suda.juc.lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author alien
 * @program myrepo
 * @description 至多允许2个线程访问的锁
 * @date 2024/12/28$
 */
public class TwinsLock implements Lock {
    private static final Sync sync = new Sync(2);
    private static class Sync extends AbstractQueuedSynchronizer {

        public Sync(int count) {
            if (count <= 0) {
                throw new IllegalArgumentException("count must larger than zero");
            }
            setState(count);
        }

        @Override
        protected int tryAcquireShared(int reduceCount) {
            for (;;) {
                int curState = getState();
                int newState = curState - reduceCount;
                if (newState < 0 || compareAndSetState(curState, newState)) {
                    return newState;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int returnCount) {
            for(;;) {
                int curState = getState();
                int newState = curState + returnCount;
                if (compareAndSetState(curState, newState)) {
                    return true;
                }
            }
        }
    }
    @Override
    public void lock() {
        sync.tryAcquireShared(1);
    }
    @Override
    public void unlock() {
        sync.tryReleaseShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}

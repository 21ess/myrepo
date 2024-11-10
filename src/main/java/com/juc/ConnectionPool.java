package com.juc;

import java.sql.Connection;
import java.util.LinkedList;

public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<>();
    
    public ConnectionPool(int initialSize) {
        for (int i = 0; i < initialSize; i++) {
            pool.addLast(ConnectionDriver.createConnection());
        }
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized(pool) {
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized(pool) {
            // 完全超时
            if (mills <= 0) {
                if (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.pollFirst();
            }
            // 设置了等待超时时间
            else {
                long deadline = System.currentTimeMillis() + mills;
                Long remaining = mills;
                while (pool.isEmpty() && remaining > 0) {
                    pool.wait();
                    remaining = deadline - System.currentTimeMillis();
                }
                // 等待超时或者竞争到数据库连接池
                Connection result = null;
                if (!pool.isEmpty()) {
                    result = pool.pollFirst();
                }
                return result;
            }
        }
    }
}

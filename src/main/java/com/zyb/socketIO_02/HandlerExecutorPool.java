package com.zyb.socketIO_02;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Title: HandlerExecutorPool.java
 * @Package com.zyb.socketIO_02
 * @Description: TODO
 * @Author ZhangYB
 * @Version V1.0
 */
public class HandlerExecutorPool {
    private ExecutorService executor;

    public HandlerExecutorPool(int maxPoolSize , int queueSize) {
        this.executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),maxPoolSize , 120L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(queueSize));
    }

    public void execute(Runnable task){
        this.executor.execute(task);
    }
}

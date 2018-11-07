package com.zyb.basic.chapter004;

import com.zyb.basic.chapter003.Task1;
import com.zyb.constant.GlobalConstant;
import com.zyb.utils.DataUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @Title: Task2.java
 * @Package com.zyb.basic.chapter004
 * @Description:
 *      ScheduledExecutorService替代Timer，实现多线程任务调度
 * @Author ZhangYB
 * @Version V1.0
 */
@Slf4j
public class Task2 implements Runnable{
    @Override
    public void run() {
        log.info("----task2 start----{}" ,DataUtil.format(DataUtil.getLocalDateTime() , GlobalConstant.DATE_FORMAT));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("----5s later ,task2 end--- {}" ,DataUtil.format(DataUtil.getLocalDateTime() , GlobalConstant.DATE_FORMAT) );
    }

    public static void main(String[] args) {

        int corePoolSize = 5;

        //设置线程池最大能接受多少线程
        int maximumPoolSize = 10;

        //当前线程数大于corePoolSize、小于maximumPoolSize时，超出corePoolSize的线程数的生命周期
        long keepActiveTime = 200;

        //设置时间单位，秒
        TimeUnit timeUnit = TimeUnit.SECONDS;

        //设置线程池缓存队列的排队策略为FIFO，并且指定缓存队列大小为5
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(5);

        //创建ThreadPoolExecutor线程池对象，并初始化该对象的各种参数
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepActiveTime, timeUnit,workQueue);



        //启用2个线程
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);

        Task1 t1 = new Task1();

        // 立即执行，任务消耗3秒，执行结束后等待2秒，【有空余线程时】，再次执行该任务
        pool.scheduleWithFixedDelay(t1, 0, 2, TimeUnit.SECONDS);


        // 立即执行，任务消耗5秒，执行结束后等待2秒，【有空余线程时】，再次执行该任务
        Task2 t2 = new Task2();
        pool.scheduleWithFixedDelay(t2, 0, 2, TimeUnit.SECONDS);
    }

}

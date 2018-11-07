package com.zyb.basic.chapter003;

import java.util.concurrent.*;

/**
 * @Title: FixedDelay.java
 * @Package com.zyb.basic.chapter003
 * @Description: 测试scheduleAtFixedRate方法
 *              固定延迟
 * @Author ZhangYB
 * @Version V1.0
 */
public class FixedDelay {

    public static void main(String[] args) {

       //线程池
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);

        Task1 t1 = new Task1();
        //立即执行t1，3s后任务结束，再等待5s（间隔时间-消耗时间），如果有空余线程时，再次执行该任务
        pool.scheduleWithFixedDelay(t1, 0, 5, TimeUnit.SECONDS);

    }
}

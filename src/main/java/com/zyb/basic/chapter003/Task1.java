package com.zyb.basic.chapter003;

import com.zyb.constant.GlobalConstant;
import com.zyb.utils.DataUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @Title: Task1.java
 * @Package com.zyb.basic.chapter003
 * @Description: task1
 * @Author ZhangYB
 * @Version V1.0
 */
@Slf4j
public class Task1 implements Runnable{
    @Override
    public void run() {
        log.info("----task1 start----{}" ,DataUtil.format(DataUtil.getLocalDateTime() , GlobalConstant.DATE_FORMAT));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("----3s later ,task1 end--- {}" ,DataUtil.format(DataUtil.getLocalDateTime() , GlobalConstant.DATE_FORMAT) );
    }

    /**
     * scheduleAtFixedRate方法是按照固定频率去执行任务的
     * @param args
     */
    public static void main(String[] args) {

      ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);

        Task1 t1 = new Task1();

        //立即执行t1，3s后任务结束，再等待2s（间隔时间-消耗时间），如果有空余线程时，再次执行该任务
        pool.scheduleAtFixedRate(t1, 0, 5, TimeUnit.SECONDS);
    }
}

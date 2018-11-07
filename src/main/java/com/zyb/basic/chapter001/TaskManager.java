package com.zyb.basic.chapter001;

import lombok.extern.slf4j.Slf4j;

import java.util.Timer;

/**
 * @Title: TaskManager.java
 * @Package com.zyb.basic
 * @Description:
 *          任务调度管理器
 * @Version V1.0
 */
@Slf4j
public class TaskManager {

    /**
     * PERIOD 周期
     */
    private static final long PERIOD = 5 * 1000;
    public TaskManager() {
        Timer timer = new Timer();
        FixedTimerTask task = new FixedTimerTask();
        log.info("任务start......");

        //0表示立即执行 以后每隔一段时间执行一次
        timer.schedule(task , 0 , PERIOD);

        //1000表示1秒后执行一次，以后每隔一段时间执行一次
        timer.schedule(task , 1000 , PERIOD);

    }
    public static void main(String[] args) {
        new TaskManager();
    }
}

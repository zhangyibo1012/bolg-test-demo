package com.zyb.basic.chapter002;
import com.zyb.constant.GlobalConstant;
import com.zyb.utils.DataUtil;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;

import static com.zyb.constant.GlobalConstant.PERIOD;


/**
 * @Title: TaskManager.java
 * @Description: 任务调度管理器
 * @Version V1.0
 */
@Slf4j
public class DynamicTaskManager {

    /**
     * 构造方法私有化
     */
    private DynamicTaskManager() {}

    /**
     * 单例模式使用内部类来维护单例的实例,由于实例的建立是在类加载时完成,故天生对线程友好.
     * 内部类的方式实现单例,既可以做到延迟加载,也不必要使用同步关键字,
     */
    private static class SingletonHolder {
        private static DynamicTaskManager instance = new DynamicTaskManager();
    }

    /**
     * 获取单例的方法
     *
     * @return
     */
    public static DynamicTaskManager getInstance() {
        return SingletonHolder.instance;
    }

    /**
     * 时间调度对象
     */
    private static Timer timer = new Timer();
    /**
     * 任务
     */
    private static DynamicTimerTask task = null;

    /**
     * @param startTime 开始时间
     * @param period    周期
     */
    public void startTask(LocalDateTime startTime, long period) {

        log.info("设置启动时间: " + DataUtil.format(startTime, GlobalConstant.DATE_FORMAT));
        //如果当前时间超过了设定时间，会立即执行一次
        task = new DynamicTimerTask();
        timer.schedule(task, DataUtil.lDT2Date(startTime), period);
    }

    /**
     * 启动定时器
     */
    public void start() {
        //启动任务，10点40启动任务
        start(DataUtil.bookTime(9, 40, 0));
    }

    /**
     * 启动定时器
     */
    public void startLocalDate(LocalDateTime time) {
        //启动任务，10点40启动任务
        start(DataUtil.lDT2Date(time));
    }


    /**
     * 启动定时器
     */
    public void start(long preiod) {
        //启动任务，10点40启动任务
        start(DataUtil.bookTime(10, 40, 0), preiod);
    }

    /**
     * 启动定时器
     */
    public void start(Date startTime) {
        start(startTime, PERIOD);
    }

    /**
     * 启动定时器
     */
    public void start(Date startTime, long preiod) {
        startTask(DataUtil.date2LDT(startTime), preiod);
    }

    /**
     * 重新启动
     */
    public void restart() {
        clean();
        start();
    }

    /**
     * 清空timer
     */
    public void clean() {
        if (task != null) {
            task.cancel();
        }
        timer.purge();
    }

    /**
     * 停止任务
     */
    public void stop() {
        System.out.println("--------任务正在停止---------");
        clean();
        System.out.println("---------任务已停止----------");

    }
}
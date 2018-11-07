package com.zyb.basic.chapter002;

import com.zyb.constant.GlobalConstant;
import com.zyb.utils.DataUtil;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @Title: DynamicTimerTask.java
 * @Package com.example.task
 * @Description:
 *          可动态修改的任务
 * @Version V1.0
 */
@Slf4j
public class DynamicTimerTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("-------start----------");
        LocalDateTime time = DataUtil.getLocalDateTime();

        for (int i = 0 ; i < 2 ; i ++){
            try {
                Thread.sleep(1000);
                log.info ("已执行【"+(i+1)+"】秒钟，at: "+ DataUtil.format(time , GlobalConstant.DATE_FORMAT));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("本次任务调度结束，at: "+DataUtil.format(DataUtil.getLocalDateTime() , GlobalConstant.DATE_FORMAT));
    }

}

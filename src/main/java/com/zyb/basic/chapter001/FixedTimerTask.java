package com.zyb.basic.chapter001;


import com.zyb.utils.DataUtil;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.TimerTask;

/**
 * @Title: FixedTimerTask.java
 * @Package com.zyb.basic
 * @Description:
 *              固定计时器任务
 * @Author ZhangYB
 * @Version V1.0
 */
@Slf4j
public class FixedTimerTask extends TimerTask {
    final String pattern = "yyyy-MM-dd HH:mm:ss";
    @Override
    public void run() {
        LocalDateTime time = DataUtil.getLocalDateTime();
        for (int i = 0; i < 3 ; i ++){
            try {
                Thread.sleep(1000);
                log.info("已执行【{}】秒钟,at:{}" , i+1 ,DataUtil.format(time , pattern));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("本次任务调度结束,at:{}" , DataUtil.format(DataUtil.getLocalDateTime() , pattern));
    }
}

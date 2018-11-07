package com.zyb.basic.chapter002;

import com.zyb.utils.DataUtil;

import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * @Title: Test.java
 * @Package com.example.task
 * @Description: TODO
 * @Version V1.0
 */
public class Test {
    public static void main(String[] args) {

        //获取任务调度管理器
        DynamicTaskManager instance = DynamicTaskManager.getInstance();

        //启动任务，会立即执行一次，2s时执行完毕，5s时第二次执行，7s时第二次执行完毕
        instance.start();

        for(int i=0;i<8;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //8s时，stop原任务，动态更改启动时间
        instance.stop();
        System.out.println("当前时间："+ DataUtil.getCurrentTimeFormat());

        System.out.println("修改原计划，5s后重新执行");

        //5s后再启动，即13s时再启动
        instance.startLocalDate(DataUtil.plus(DataUtil.getLocalDateTime() , 5 , SECONDS));
    }
}

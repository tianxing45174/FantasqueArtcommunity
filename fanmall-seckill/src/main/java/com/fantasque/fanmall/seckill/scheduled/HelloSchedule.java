//package com.fantasque.fanmall.seckill.scheduled;
//
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.stereotype.Component;
//
///**
// * @author LaFantasque
// * @version 1.0
// */
//
///**
// * 定时任务
// *      @EnableScheduling 开启定时任务
// *      @Scheduled开启一个定时任务
// *      自动配置类：TaskSchedulingAutoConfiguration
// *
// * 异步任务
// *      @EnableAsync:开启异步任务
// *      @Async：给希望异步执行的方法标注
// *      自动配置类：TaskExecutionAutoConfiguration
// */
//@Component
//@EnableScheduling
//public class HelloSchedule {
//
//    /**
//     * 1、在Spring中表达式是6位组成，不允许第七位的年份
//     * 2、在周几的的位置,1-7代表周一到周日 MON-SUN
//     * 3、定时任务不该阻塞。默认是阻塞的
//     *      1）、可以让业务以异步的方式，自己提交到线程池
//     *              CompletableFuture.runAsync(() -> {
//     *         },execute);
//     *      2）、支持定时任务线程池；设置 TaskSchedulingProperties
//     *        spring.task.scheduling.pool.size: 5
//     *      3）、让定时任务异步执行
//     *          异步任务
//     *      解决：使用异步任务 + 定时任务来完成定时任务不阻塞的功能
//     *                  秒 分 时 日 月 周
//     */
//    @Scheduled(cron = "3/5 * * ? * *")
//    public void hello(){
//        System.out.println("Hello "+new Date());
//    }
//
//}

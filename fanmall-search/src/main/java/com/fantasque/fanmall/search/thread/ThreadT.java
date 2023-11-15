package com.fantasque.fanmall.search.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author LaFantasque
 * @version 1.0
 */
public class ThreadT {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runable01 runable01 = new Runable01();
        FutureTask<Integer> futureTask = new FutureTask<>(runable01, 0);
        // new Thread(futureTask).start()
//        new CompletableFuture<>().whenComplete(new BiConsumer<Object, Throwable>() {
//        }).exceptionally(new Function<Throwable, Object>() {
//        })
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
//                5,
//                200,
//                10,
//                TimeUnit.SECONDS,
//                new LinkedBlockingDeque<>(1000),//队列最大值为1000
//                Executors.defaultThreadFactory(),//默认线程工厂
//                new ThreadPoolExecutor.AbortPolicy()
//        );
    }

    public static class Runable01 implements Runnable {
        @Override
        public void run() {
            System.out.println("当前线程：" + Thread.currentThread().getId());
            int i = 10 / 2;
            System.out.println("运行结果：" + i);
        }
    }
}

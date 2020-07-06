package com.lu.forkjoin;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * @author 小卢
 * 没有返回值的
 * <p>
 * 如何使用ForkJoin
 * 1.ForkJoinPool 通过它来执行
 * 2.计算任务      ForkJoinPool.execute(ForkjoinTask task)
 * ForkjoinTask
 */
public class ImportDemo extends RecursiveAction {

    private List<Integer> list;

    //临界值
    private Long temp = 100L;

    public ImportDemo(List<Integer> list) {
        this.list = list;
    }


    @Override
    protected void compute() {
        if (list.size() < temp) {


            list.forEach((l) -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                System.out.println(Thread.currentThread().getName()+ LocalDateTime.now()+"   ->  "+l);
                /*System.out.println(l);
                if (l % 100 == 0) {
                    Integer integer = list.get(0);
                    Integer integer1 = list.get(list.size() - 1);
                    System.out.println(integer+"------------->"+integer1);
                    throw new RuntimeException();
                }*/
            });
        } else {
            // ForkJoin
            // 中间值
            List<Integer> top = list.subList(0, list.size() / 2);

            ImportDemo task1 = new ImportDemo(top);
            // 拆分任务,吧任务压入线程队列
            task1.fork();
            List<Integer> down = list.subList(list.size() / 2, list.size());

            ImportDemo task2 = new ImportDemo(down);
            // 拆分任务,吧任务压入线程队列
            task2.fork();
        }
    }

}

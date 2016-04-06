package com.dyx.mp.task;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-05
 * Time      : 16:07
 * Summary   : 任务线程池
 * Copyright : Copyright (c) 2016
 */
public class TaskExecutor {
    private static ScheduledThreadPoolExecutor mScheduledThreadPoolExecutor = null;
    private static Handler mHandler = null;
    private static ExecutorService esNotDoNetwork = null;
    private static ExecutorService esDoNetwork = null;

    public static void executeNoNetworkTask(Runnable task) {
        executeNoNetworkExecutor();
        esNotDoNetwork.execute(task);
    }

    public static void executeTask(Runnable task) {
        executeExecutor();
        esDoNetwork.execute(task);
    }

    /**
     * 提交任务
     *
     * @param task
     * @param <T>
     * @return
     */
    public static <T> Future<T> submitTask(Callable<T> task) {
        executeNoNetworkExecutor();
        return esNotDoNetwork.submit(task);
    }

    public static void scheduleTask(long delay, Runnable task) {
        executeScheduleThreadPoolExecutor();
        mScheduledThreadPoolExecutor.schedule(task, delay, TimeUnit.MICROSECONDS);
    }

    public static void scheduleTaskAtFixedRateIgnoringTaskRunningTime(long initialDelay, long period, Runnable task) {
        executeScheduleThreadPoolExecutor();
        mScheduledThreadPoolExecutor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.MICROSECONDS);
    }

    public static void scheduleTaskAtFixedRateIncludingTaskRunningTime(long initialDelay, long period, Runnable task) {
        executeScheduleThreadPoolExecutor();
        mScheduledThreadPoolExecutor.scheduleWithFixedDelay(task, initialDelay, period, TimeUnit.MICROSECONDS);
    }

    public static void executorScheduleTaskOnUiThread(long delay, Runnable task) {
        executorMainHandler();
        mHandler.postDelayed(task, delay);
    }

    public static void runTaskOnUiThread(Runnable task) {
        executorMainHandler();
        mHandler.post(task);
    }

    private static void executorMainHandler() {
        if (mHandler == null) {
            mHandler = new Handler(Looper.getMainLooper());
        }
    }

    private static void executeScheduleThreadPoolExecutor() {
        if (mScheduledThreadPoolExecutor == null) {
            mScheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2);
        }
    }

    private static void executeExecutor() {
        if (esDoNetwork == null) {
            esDoNetwork = new ThreadPoolExecutor(10, 15, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(), Executors.defaultThreadFactory());
        }
    }

    private static void executeNoNetworkExecutor() {
        if (esNotDoNetwork == null) {
            esNotDoNetwork = new ThreadPoolExecutor(5, 10, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(), Executors.defaultThreadFactory());
        }
    }

    public static void shutDown() {
        if (esNotDoNetwork != null) {
            esNotDoNetwork.shutdown();
            esNotDoNetwork = null;
        }

        if (mScheduledThreadPoolExecutor != null) {
            mScheduledThreadPoolExecutor.shutdown();
            mScheduledThreadPoolExecutor = null;
        }
    }
}  
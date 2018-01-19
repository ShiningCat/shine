package com.shine.common.util.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadFactory {
    public static ExecutorService pool = Executors.newCachedThreadPool();
    public static void execute(Runnable able){
        pool.execute(able);
    }
}
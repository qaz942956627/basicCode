package com.lu.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class TestForkJoinPool {

    private static final ForkJoinPool FORK_JOIN_POOL = new ForkJoinPool();

    private TestForkJoinPool() {


    }


    public static ForkJoinPool getInstance() {
        return FORK_JOIN_POOL;
    }
}


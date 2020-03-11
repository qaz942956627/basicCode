package com.lu.single;

/**
 * 懒汉式单例
 * @author 小卢
 */
public class LazyMan {

    private LazyMan() {

    }

    private volatile static LazyMan lazyMan;

    //双重检测锁模式的懒汉式单例 DCL懒汉式
    public static LazyMan getInstance() {
        if (lazyMan == null) {
            synchronized (LazyMan.class) {
                if (lazyMan == null) {
                    lazyMan = new LazyMan();// 不是一个原子性操作
                    /**
                     * 1.分配内存空间
                     * 2.执行构造方法，初始化对象
                     * 3.把这个对象执行这个空间
                     *
                     *
                     * 123
                     * 132 A
                     *     B 此时lazyMan还没有完成构造 空间指向是虚无
                     *     避免指令重排 必须在lazyMan前面加上一个volatile
                     */
                }
            }
        }
        return lazyMan;
    }
}

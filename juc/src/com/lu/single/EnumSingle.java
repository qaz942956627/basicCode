package com.lu.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


/**
 * enum 是一个什么？ 本身也是一个Class类
 * @author 小卢
 */
public enum EnumSingle {
    /**
     * 枚举实现单例模式,反射不能破坏枚举的单例
     */
    INSTANCE;

    public EnumSingle getInstance(){
        return INSTANCE;
    }

}

class Test{

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumSingle instance1 = EnumSingle.INSTANCE;
        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class,int.class);
        declaredConstructor.setAccessible(true);
        EnumSingle instance2 = declaredConstructor.newInstance();

        // NoSuchMethodException: com.kuang.single.EnumSingle.<init>()
        System.out.println(instance1);
        System.out.println(instance2);

    }

}
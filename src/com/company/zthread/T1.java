package com.company.zthread;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class T1 implements Runnable {

    static Integer num = 10;
    AtomicInteger atomicInteger = new AtomicInteger(0);

    public void test() {
        try {
            System.out.println("InterruptedException");
            wait();
        } catch (InterruptedException e) {

            System.out.println("InterruptedException");
        }

    }

    public static void main(String[] args) {

        System.out.println("Xmx="+Runtime.getRuntime().maxMemory()/1024/1024);
        System.out.println("free men="+Runtime.getRuntime().freeMemory()/1024/1024);
        System.out.println("total men="+Runtime.getRuntime().totalMemory()/1024/1024);
        System.gc();

        Unsafe unsafe = null;
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(unsafe.addressSize());
        System.out.println(unsafe.pageSize());

//        LinkedList list = new LinkedList<>();
//
//
//        T1 t2 = new T1();
//        System.out.println(Thread.currentThread().isInterrupted());
//        new Thread(t2).start();
//        new Thread(t2).start();
//
//        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
//
//        ReentrantLock reentrantLock = new ReentrantLock(true);
//        ReentrantReadWriteLock.WriteLock reentrantWriteLock;
//        ReentrantReadWriteLock.ReadLock reentrantReadLock;
//
//        synchronized(num){
//
//        }

//        ThreadPoolExecutor pool = new  ThreadPoolExecutor();

//        t2.test();
//        try {
//            Thread.currentThread().wait();
//        } catch (InterruptedException e) {
//            System.out.println(Thread.currentThread().getName() + "wait");
//        }

//        t2.notify();
    }

    @Override
    public void run() {
        //synchronized (num) {
        for (int i = 0; num > 0; i++) {

            System.out.println(Thread.currentThread().getName() + "run");
            num--;
            System.out.println(num);
            // }
//            if (num > 5 && Thread.currentThread().getName() == "Thread-0") {
//                try {
//                    wait();
//                } catch (InterruptedException e) {
//                    System.out.println(Thread.currentThread().getName() + "wait");
//                }
//                //}
//            }

        }

    }
}

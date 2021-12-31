package com.company.Test;

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Cat extends Animal {

    @Override
    public void eat() {
        System.out.println("cat 干饭");
    }

    @Override
    public void sleep() {
        System.out.println("cat 睡大觉");
    }
}

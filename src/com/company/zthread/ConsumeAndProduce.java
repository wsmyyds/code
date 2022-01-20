package com.company.zthread;

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class ConsumeAndProduce {

    int MIN_PRODUCT = 0;
    int MAX_PRODUCT = 20;
    static int PRODUCT = 0;

    public synchronized void produce(){

        if (PRODUCT>=MAX_PRODUCT){
            try {
                wait();
                System.out.println("product已满");
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }
        PRODUCT++;
        System.out.println("第"+PRODUCT+"产品生产");
        notifyAll();
    }

    public synchronized void consume(){

        if (PRODUCT<=MIN_PRODUCT){
            try {
                wait();
                System.out.println("product已满");
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }
        PRODUCT--;
        System.out.println("第"+PRODUCT+"产品消费");
        notifyAll();
    }

    public static void main(String[] args) {

        ConsumeAndProduce consumeAndProduce = new ConsumeAndProduce();

        new Thread(){
            @Override
            public void run() {
                while(true){
                    consumeAndProduce.produce();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                while(true) {
                    consumeAndProduce.consume();
                }
            }
        }.start();

    }

}

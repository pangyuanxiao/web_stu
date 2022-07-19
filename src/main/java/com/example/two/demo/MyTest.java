package com.example.two.demo;

public class MyTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        for(;;){
            synchronized (myThread){
                if (myThread.isFlag()){
                    System.out.println("Java编程");
                }
            }
        }
    }
}
class MyThread extends Thread {
    private volatile boolean flag =false;

    public boolean isFlag(){
        return flag;
    }
    public void run(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag =true;
        System.out.println("flag=" + flag);
    }
}
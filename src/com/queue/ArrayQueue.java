package com.queue;

import java.util.Arrays;

public class ArrayQueue {
    public static void main(String[] args) {
        ArrayQueueRealize aq = new ArrayQueueRealize(10);
        aq.add(1);
        aq.add(2);
        aq.add(4);
        aq.show();
    }
}
//使用数组模拟队列
class ArrayQueueRealize{
    private int maxSize;
    private int front; //队列首
    private int rear; // 队列尾
    private int[] arr; // store data

    //创建队列的构造器
    public ArrayQueueRealize(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头的前一个位置
        rear = -1; //指向队列尾部
    }
    public boolean isEmpty(){
        return rear == front;
    }
    public boolean isFull(){
        return rear == maxSize-1;
    }

    // add item
    public void add(int n){
        if(!this.isFull()) {
            rear++;
            arr[rear] = n;
            return;
        }
        else {
            System.out.println("This queue is full, cannot add!");
            return;
        }
    }

    // take item out of queue
    public int get(){
        if(!this.isEmpty()){
            front++;
            return arr[front];
        }
        else {
            //跑出异常
            throw new RuntimeException("This queue is empty, cannot take item");
        }
    }

    // show all item
    public void show(){
        if(!this.isEmpty()){
            for(int i=0; i<=rear; i++){
                System.out.print(arr[i]+"\t");
            }
        }
        else System.out.println("Empty queue.");
    }
    //show first item
    public int peek(){
        if(this.isEmpty()) throw new RuntimeException("Empty queue");
        return arr[front+1];
    }
}


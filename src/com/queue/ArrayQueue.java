package com.queue;

import com.sun.javaws.IconUtil;

import java.util.Arrays;

public class ArrayQueue {
    public static void main(String[] args) {
        CircleArrayRealize ca = new CircleArrayRealize(3);
        ca.add(10);
        ca.add(2);
        ca.add(1);
        System.out.println("first item: ");
        System.out.println(ca.get());
        System.out.println("all items in queue: ");
        ca.show();
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

class CircleArrayRealize{
    private int maxSize;
    private int front; // point to the first item
    private int rear; // point to the place after the last item
    private int[] arr;
    private int size;

    public CircleArrayRealize(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    public boolean isFull(){
        // 当队列为满时，条件为：(rear+1)%maxSize == front
        //return (rear+1) % maxSize == front;
        return size == maxSize;
    }
    public boolean isEmpty(){
        // 当队列为空时，条件为：rear == front
        return size==0;
    }

    // add item to queue
    public void add(int item){
        if(isFull()) {
            System.out.println("This queue is full, cannot add item");
            return;
        }
        arr[rear] = item;
        size++;
        rear = (rear+1)%maxSize;
    }

    // get item from queue
    public int get(){
        if(isEmpty()) {
            throw new RuntimeException("This queue is empty");
        }
        else {
            size--;
            int res = arr[front];
            front = (front+1)%maxSize;
            return res;
        }
    }

    public void show(){
        if(isEmpty()) System.out.println("This queue is empty");
        else{
            for(int i=0; i<size; i++){
                int index = (front+i) % maxSize;
                System.out.println(arr[index]+"\t");
            }
        }
    }

    public int getSize(){
        return size;
    }
}


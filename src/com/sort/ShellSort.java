package com.sort;

public class ShellSort {

    public static void shellsort(int[] arr){
        for(int gap=arr.length/2; gap>0; gap/=2){
            //遍历一组中所有元素
            for(int i=gap;i<arr.length;i++){
                for(int j=i-gap; j>=0; j-=gap){
                    if(arr[j]>arr[j+gap]){
                        int tmp=arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]=tmp;
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {1,22,2,6,43,103,42,3};
        shellsort(arr);
        for(int i:arr) System.out.print(i+"\t");
    }
}

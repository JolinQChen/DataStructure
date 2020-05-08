package com.sort;

public class SelectSort {
    public static void selectSort(int[] arr){
        int len = arr.length;
        for(int i=0; i<len; i++){
            int minIndex = i;
            for(int j=i; j<len; j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            switchIndex(arr, i, minIndex);
        }
    }

    public static void switchIndex(int[] arr, int a, int b){
        int item = arr[a];
        arr[a] = arr[b];
        arr[b] = item;
    }

    public static void main(String[] args){
        int[] arr = {1,32,2,142};
        selectSort(arr);
        for (int i:arr)
            System.out.print(i+"\t");
    }
}

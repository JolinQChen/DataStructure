package com.sort;

public class InsertSort {
    public static void insertSort(int[] arr){
        for(int ii:arr) System.out.print(ii+"\t");
        System.out.println();
        if(arr.length<=1) return;
        int len = arr.length;
        for(int i=1; i<len; i++){
            int insertVal = arr[i]; //待定插入的数
            int insertIndex = i-1; // arr[1]前面这个数的下标
            while(insertIndex>=0 && insertIndex<len && insertVal<arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1] = insertVal;
            for(int ii:arr) System.out.print(ii+"\t");
            System.out.println();
        }

        /*

        //第一轮插入
        int insertVal = arr[1]; //待定插入的数
        int insertIndex = 0; // arr[1]前面这个数的下标
        while(insertIndex>=0 && insertIndex<len && insertVal<arr[insertIndex]){
            arr[insertIndex+1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex+1] = insertVal;

         */
    }

    public static void main(String[] args){
        int[] arr = {1,90,2,45,4};
        insertSort(arr);
        //for(int i:arr)
        //    System.out.print(i+"\t");
    }
}

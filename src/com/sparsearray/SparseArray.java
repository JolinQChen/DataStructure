package com.sparsearray;

import java.sql.SQLOutput;

public class SparseArray {
    public static void main(String[] args){
        // Create an original 2-dimensional array: 11*11
        // 0: not occupied, 1: black, 2: blue
        int chessArray1[][] = new int[11][11];
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;
        chessArray1[4][6] = 8;
        // output original
        System.out.println("Original array: ");
        for(int[] row:chessArray1){
            for(int data:row) System.out.printf("%d\t",data);
            System.out.println();
        }

        // transform array to sparse array
        // 1. traverse, get number of non-zero data
        int sum=0;
        for (int i=0; i<chessArray1.length; i++){
            for(int j=0; j<chessArray1[0].length;j++) {
                if(chessArray1[i][j]!=0) sum++;
            }
        }
        System.out.println("The number of non-zero data is: "+sum);

        // create sparse array
        int[][] sparseArray = new int[sum+1][3];
        sparseArray[0][0] = chessArray1.length;
        sparseArray[0][1] = chessArray1[0].length;
        sparseArray[0][2] = sum;

        // traverse array
        int count = 0;
        for (int i=0; i<chessArray1.length; i++){
            for(int j=0; j<chessArray1[0].length;j++) {
                if(chessArray1[i][j]!=0) {
                    sparseArray[++count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray1[i][j];
                }
            }
        }
        System.out.println("Sparse Array: ");
        for(int[] row:sparseArray){
            for(int data:row) System.out.printf("%d\t",data);
            System.out.println();
        }

        // transform sparse to array (omit)
        //...
    }
}

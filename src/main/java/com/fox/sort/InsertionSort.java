package com.fox.sort;

/**
 * @Description: [插入排序]
 * @Author: gaoyimin
 * @CreateDate: 2019/10/27
 * @Version: [v1.0]
 */
public class InsertionSort {

    public static void main(String[] args) {
        System.out.println("This is insertSort");
        InsertionSort insertionSort = new InsertionSort();
        int[] array = new int[]{5, 3, 4, 2, 1};
        insertionSort.insetSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    private void insetSort(int[] array) {
        if (array.length == 0 || array.length == 1) {
            return;
        }
        for (int j = 1; j < array.length; j++) {
            int k = array[j];
            int i = j - 1;
            while (i >= 0 && array[i] > k) {
                array[i + 1] = array[i];
                i = i - 1;
            }
            array[i + 1] = k;
        }
    }
}

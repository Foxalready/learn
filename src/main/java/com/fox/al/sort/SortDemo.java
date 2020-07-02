package com.fox.al.sort;

/**
 * @Description: [排序]
 * @Author: gaoyimin
 * @CreateDate: 2020/7/2
 * @Version: [v1.0]
 */
public class SortDemo {

    public static void main(String[] args) {
        SortDemo sortDemo = new SortDemo();
        int[] arr = new int[]{6, 5, 3, 8, 1, 9, 2};
        sortDemo.xuanzeSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }

    }

    private void xuanzeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("为空");
            return;
        }
        int length = arr.length;
        int min = 0;
        int temp = 0;
        for (int i = 0; i < length; i++) {
            min = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

}

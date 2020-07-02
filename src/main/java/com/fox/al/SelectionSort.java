package com.fox.al;

/**
 * @Description: [选择排序]
 * @Author: gaoyimin
 * @CreateDate: 2018/9/30
 * @Version: [v1.0]
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 45, 65, 33, 12};
        System.out.println("选择排序前");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        //TODO 选择排序
        for (int i = 0; i < array.length; i++) {
            int k = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j]<array[k]){
                    k=j;
                }
            }

            if (i!=k){
                int temp = array[k];
                array[k]=array[i];
                array[i]=temp;
            }
        }


        System.out.println("选择排序后");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}

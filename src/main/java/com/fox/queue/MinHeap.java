package com.fox.queue;

import java.util.Arrays;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2019/10/24
 * @Version: [v1.0]
 */
public class MinHeap {

    private int[] values = new int[16];
    private int size;

    /**
     * 上浮
     * <p>
     * 堆尾的元素与父节点比较，如果小于父节点，则交换位置，并且再次与父节点进行比较，直到比父节点大或者到根节点位置
     *
     * @return
     */
    private int fixUp() {
        int j = size - 1;
        //如果只有一个元素，此时应该不进行上浮操作，在插入的时候就进行判断是否进行
        if (j == 0) {
            return -1;
        }
        int k = 0;
        while (((j - 1) / 2) >= 0) {

            k = (j - 1) / 2;

            if (values[k] > values[j]) {
                int temp = values[k];
                values[k] = values[j];
                values[j] = temp;
            } else {
                break;
            }

        }

        return k;
    }

    /**
     * 下沉
     * <p>
     * 从堆顶拿走元素，将堆尾的元素放到堆顶，然后与他的左右子节点中的较小者进行比较，如果与之比较小，则交换位置，并于子节点继续进行比较
     */
    private int fixDown() {

        //父节点index
        int f = 0;

        //较小者的index
        int k = 0;

        //至少存在左子节点
        while ((k = (2 * f + 1)) < size) {
            //存在右子节点
            if (k < size - 1) {
                //左右子节点进行比较，如果右节点小
                if (values[k] > values[k + 1]) {
                    k++;
                }
            }
            //父节点小于较小节点，满足逻辑，退出循环
            if (values[f] <= values[k]) {
                break;
            }

            int temp = values[f];
            values[f] = values[k];
            values[k] = temp;
            f = k;
        }

        return f;
    }

    /**
     * 弹出一个堆顶元素
     *
     * @return
     */
    private int poll() {
        if (size < 0) {
            throw new IllegalStateException("不存在元素");
        }
        int value = values[0];
        values[0] = values[--size];
        values[size] = 0;
        fixDown();
        return value;
    }

    private int push(int element) {
        if (size > values.length) {
            Arrays.copyOf(values, size >> 1);
        }
        values[size++] = element;
        return fixUp();
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        heap.push(4);
        heap.push(2);
        heap.push(7);
        heap.push(9);
        heap.push(1);
        heap.push(5);
        heap.push(10);
        heap.push(3);
        heap.push(2);
        for (int i = 0; i < 9; i++) {
            System.out.println(heap.poll());
        }

    }
}

package com.fox.queue;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2019/10/23
 * @Version: [v1.0]
 */
public class QueueDemo {

    public static void main(String[] args) {
        System.out.println("Hello");

        QueueDemo d = new QueueDemo();
        d.maxSort();
    }

    private void maxSort() {

        List<QueueNode> list = Lists.newArrayList(new QueueNode(5), new QueueNode(10), new QueueNode(2), new QueueNode(1), new QueueNode(3));

        PriorityQueue<QueueNode> queue = new PriorityQueue<>(Comparator.comparingInt(QueueNode::getValue));
        queue.addAll(list);

        while (!queue.isEmpty()) {
            System.out.println(JSON.toJSONString(queue.poll()));
        }

        PriorityQueue<QueueNode> queue1 = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        queue1.addAll(list);

        while (!queue1.isEmpty()) {
            System.out.println(JSON.toJSONString(queue1.poll()));
        }

    }
}

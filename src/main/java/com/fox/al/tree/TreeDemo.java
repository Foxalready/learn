package com.fox.al.tree;

import com.sun.jmx.remote.internal.ArrayQueue;
import org.apache.commons.collections.CollectionUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2020/6/30
 * @Version: [v1.0]
 */
public class TreeDemo {

    public static void main(String[] args) {
        TreeDemo treeDemo = new TreeDemo();
        treeDemo.test();
    }

    private void test() {


        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode10 = new TreeNode(10);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
//        treeNode2.right = treeNode5;
        treeNode3.left = treeNode5;
//        treeNode3.right = treeNode7;
//        treeNode4.left = treeNode8;
        treeNode4.right = treeNode6;
        treeNode6.right = treeNode7;
//        treeNode5.left = treeNode10;

        //先序遍历
        left(treeNode1);
        //中序遍历
//        middle(treeNode1);
        //后续遍历
//        right(treeNode1);
        //层次遍历
//        cengci(treeNode1);
        //深度遍历
        shendu(treeNode1);


    }

    /**
     * 栈先进后出，所以先入右边的，后入左边的
     *
     * @param node
     */
    private void shendu(TreeNode node) {

        Stack<TreeNode> linkedList = new Stack<>();

//        LinkedList<TreeNode> linkedList = new LinkedList<>();
        if (node == null) {
            System.out.println("为空");
            return;
        }

        linkedList.push(node);
        while (CollectionUtils.isNotEmpty(linkedList)) {
            TreeNode temp = linkedList.pop();
            System.out.println(temp.value);
            if (temp.right != null) {
                linkedList.push(temp.right);
            }
            if (temp.left != null) {
                linkedList.push(temp.left);
            }
        }

    }

    private void cengci(TreeNode node) {

        ArrayBlockingQueue<TreeNode> queue = new ArrayBlockingQueue<>(10);

//        ArrayQueue<TreeNode> queue = new ArrayQueue<TreeNode>(10);
        if (node == null) {
            System.out.println("为空");
            return;
        }

        queue.offer(node);
        while (CollectionUtils.isNotEmpty(queue)) {
            TreeNode temp = queue.poll();
            System.out.println(temp.value);
            if (temp.left != null) {
                queue.offer(temp.left);
            }

            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }

    private void left(TreeNode node) {
        if (node != null) {
            System.out.println(node.value);
            left(node.left);
            left(node.right);
        }
    }

    private void middle(TreeNode node) {
        if (node != null) {
            middle(node.left);
            System.out.println(node.value);
            middle(node.right);
        }
    }

    private void right(TreeNode node) {
        if (node != null) {
            middle(node.left);
            middle(node.right);
            System.out.println(node.value);
        }
    }


}

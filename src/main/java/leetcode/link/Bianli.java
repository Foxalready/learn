package leetcode.link;

import leetcode.common.MyLinkedNode;
import leetcode.common.MyTreeNode;

public class Bianli {


    public static void main(String[] args) {

        MyLinkedNode node = MyLinkedNode.create(1, 2, 3, 4);

        MyTreeNode myTreeNode4 = new MyTreeNode(4);
//        MyTreeNode myTreeNode8 = new MyTreeNode(8);
//        MyTreeNode myTreeNode7 = new MyTreeNode(7);
//        MyTreeNode myTreeNode5 = new MyTreeNode(5, myTreeNode7, myTreeNode8);
//        MyTreeNode myTreeNode2 = new MyTreeNode(2, myTreeNode4, myTreeNode5);
//        MyTreeNode myTreeNode6 = new MyTreeNode(6);
//        MyTreeNode myTreeNode3 = new MyTreeNode(3, null, myTreeNode6);
//        MyTreeNode myTreeNode1 = new MyTreeNode(1, myTreeNode2, myTreeNode3);
//
//        Bianli bianli = new Bianli();
////        bianli.pre(myTreeNode1);
////        bianli.mid(myTreeNode1);
//        bianli.beh(myTreeNode1);

    }


    private void pre(MyTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.value);
        pre(treeNode.left);
        pre(treeNode.right);
    }

    private void mid(MyTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        mid(treeNode.left);
        System.out.println(treeNode.value);
        mid(treeNode.right);
    }

    private void beh(MyTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        beh(treeNode.left);
        beh(treeNode.right);
        System.out.println(treeNode.value);
    }


}

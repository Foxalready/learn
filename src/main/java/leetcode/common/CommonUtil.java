package leetcode.common;

public class CommonUtil {

    public static void printNode(MyLinkedNode node) {
        StringBuffer stringBuffer = new StringBuffer();
        while (node != null) {
            stringBuffer.append(node.value).append("->");
            node = node.next;
        }
        System.out.println(stringBuffer.toString());
    }
}

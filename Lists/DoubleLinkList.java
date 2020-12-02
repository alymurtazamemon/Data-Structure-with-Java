package Lists;

public class DoubleLinkList {
    DoubleNode head, tail;
    public static void main(String[] args) {

    }

    private void insertFirst(int data) {
        DoubleNode newNode = new DoubleNode(data);
        newNode.next = head;
        head.prev = newNode;
    }
}

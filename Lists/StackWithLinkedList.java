package Lists;

public class StackWithLinkedList {
    private SingleLink head;

    public static void main(String[] args) {
        StackWithLinkedList obj = new StackWithLinkedList();

        obj.insert(10);
        obj.insert(20);
        obj.insert(30);
        obj.insert(40);
        obj.insert(50);

        obj.delete();
        obj.delete();
        System.out.println(obj.peek().data);
        obj.print();
        System.out.println();
    }

    public void insert(int data) {
        SingleLink newNode = new SingleLink(data);
        newNode.next = head;
        head = newNode;
    }

    public void delete() {
        SingleLink removeNode = head;
        head = head.next;
        removeNode = null;
    }

    private SingleLink peek() {
        return head;
    }

    public void print() {
        SingleLink n = head;

        System.out.print("Head ");
        while (n != null) {
            System.out.print(" --> " + n.data);
            n = n.next;
        }
    }
}

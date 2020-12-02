package Lists;

public class Test {
    SingleLink head;

    public static void main(String[] args) {
        Test obj = new Test();

        obj.insertFirst(10);
        obj.insertFirst(20);
        obj.insertFirst(30);
        obj.insertFirst(40);
        obj.insertFirst(50);
        obj.printList();

        obj.deleteFirst();
        obj.deleteFirst();
        obj.printList();

        System.out.println(obj.findIndex(10));

        obj.insertLast(5);
        obj.insertLast(2);
        obj.printList();

        obj.deleteLast();
        obj.deleteLast();
        obj.printList();
    }

    private void deleteParticularNode(int index) {

    }

    private void deleteLast() {
        SingleLink link = head;

        while (link.next.next != null) {
            link = link.next;
        }
        link.next = null;
    }

    private void insertLast(int data) {
        SingleLink newNode = new SingleLink(data);
        SingleLink link = head;

        while (link.next != null) {
            link = link.next;
        }
        link.next = newNode;
    }

    private String findIndex(int key) {
        SingleLink current = head;
        int index = -1;
        while (current != null) {
            index++;
            if (current.data == key) {
                return index + "";
            }
            current = current.next;
        }
        return null;
    }

    private void insertFirst(int data) {
        SingleLink newNode = new SingleLink(data);
        newNode.next = head;
        head = newNode;
    }

    private void deleteFirst() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        head = head.next;
    }

    private boolean isEmpty() {
        return head == null;
    }

    private void printList() {
        SingleLink link = head;

        while (link != null) {
            link.print();
            link = link.next;
        }
        System.out.println();
    }
}

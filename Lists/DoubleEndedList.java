package Lists;

public class DoubleEndedList {
    SingleLink first, last;

    public static void main(String[] args) {
        DoubleEndedList obj = new DoubleEndedList();

        obj.insertFirst(10);
        obj.insertFirst(20);
        obj.insertFirst(30);
        obj.insertFirst(40);
        obj.insertLast(50);
        obj.insertLast(60);
        obj.deleteFirst();
        obj.deleteFirst();
        obj.printList();
    }

    private void insertFirst(int data) {
        SingleLink newNode = new SingleLink(data);
        if (isEmpty()) {
            last = newNode;
        }
        newNode.next = first;
        first = newNode;
    }

    private void insertLast(int data) {
        SingleLink newNode = new SingleLink(data);
        if (isEmpty()) {
            first = newNode;
        }
        last.next = newNode;
        last = newNode;
    }

    private void deleteFirst() {
        if (first.next == null) {
            last = null;
        }
        first = first.next;
    }

    private boolean isEmpty() {
        return first == null;
    }

    private void printList() {
        SingleLink current = first;

        while (current != null) {
            current.print();
            current = current.next;
        }
        System.out.println();
    }
}

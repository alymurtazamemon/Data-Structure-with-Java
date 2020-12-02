package Lists;

public class DoubleLinkedList {
    DoublyNode first, last;

    public static void main(String[] args) {
        DoubleLinkedList obj = new DoubleLinkedList();
        obj.insertFirst(10);
        obj.insertFirst(5);
        obj.insertFirst(2);
        obj.insertFirst(1);
        obj.displayForward();

        obj.insertLast(20);
        obj.insertLast(30);
        obj.insertLast(40);
        obj.insertLast(50);
        obj.displayForward();

        obj.insertAfter(15, 50);
        obj.displayForward();

        obj.deleteAfter(1);
        obj.deleteAfter(15);
        obj.deleteAfter(20);
        obj.displayForward();

        obj.deleteFirst();
        obj.displayForward();

        obj.deleteLast();
        obj.displayForward();
    }

    private void deleteLast() {
        DoublyNode current = last;

        last = current.previous;
        current.previous.next = null;
        current.previous = null;
    }

    private void deleteFirst() {
        DoublyNode current = first;

        first = current.next;
        current.next.previous = null;
        current.next = null;
    }

    private void deleteAfter(int key) {
        DoublyNode current = find(key);

        if (current == first) {
            first = current.next;
            current.next.previous = null;
            current.next = null;
        } else if (current == last) {
            last = current.previous;
            current.previous.next = null;
            current.previous = null;
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
    }

    private void insertAfter(int data, int key) {
        DoublyNode newNode = new DoublyNode(data);
        DoublyNode current = find(key);

        if (current == null) {
            System.out.println("Node not found!");
        } else if (current == last) {
            newNode.next = null;
            last = newNode;
        } else {
            newNode.next = current.next;
            current.next.previous = newNode;
        }
        newNode.previous = current;
        current.next = newNode;
    }

    private DoublyNode find(int key) {
        DoublyNode current = first;

        while (current != null) {
            if (current.data == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private void insertLast(int data) {
        DoublyNode newNode = new DoublyNode(data);
        DoublyNode current = last;

        if (isEmpty())
            first = newNode;
        else
            current.next = newNode;
        newNode.previous = current;
        last = newNode;
    }

    private void insertFirst(int data) {
        DoublyNode newNode = new DoublyNode(data);
        DoublyNode current = first;

        if (isEmpty())
            last = newNode;
        else
            current.previous = newNode;
        newNode.next = current;
        first = newNode;
    }

    private void displayForward() {
        DoublyNode current = first;

        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

    private void displayBackward() {
        DoublyNode current = last;

        while (current != null) {
            current.displayLink();
            current = current.previous;
        }
        System.out.println();
    }

    private boolean isEmpty() {
        return first == null;
    }
}

class DoublyNode {
    int data;

    DoublyNode next;
    DoublyNode previous;

    public DoublyNode(int data) {
        this.data = data;
    }

    public void displayLink() {
        System.out.print(data + ", ");
    }
}

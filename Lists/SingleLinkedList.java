package Lists;

public class SingleLinkedList {

    //Declaring the instance variable.
    SingleLink head;
    int size;

    public static void main(String[] args) {
        SingleLinkedList obj = new SingleLinkedList();

        obj.insertFirst(10);
        obj.insertFirst(20);
        obj.insertFirst(30);
        obj.insertFirst(40);
        obj.insertFirst(50);

        //insert node at index number 3.
        obj.insertCenter(60, 3);

        //delete a node 30 from the list.
        obj.deleteCenterNode(30);

        System.out.println();
        obj.printList();
    }

    private void deleteCenterNode(int key) {
        SingleLink current = head;
        SingleLink prev = head;
        int index = findWithKey(key);
        int c = 0;

        while (c != index - 1) {
            prev = prev.next;
            c++;
        }
//        System.out.println(prev.data);
        while (current.data != key) {
            current = current.next;
        }
        System.out.println("Deleted Node: "+current.data);
        prev.next = current.next;
    }

    private void insertCenter(int data, int index) {
        if (index == 0) {
            insertFirst(data);
        } else {
            SingleLink newNode = new SingleLink(data);
            SingleLink current = findWithIndex(index - 1);
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    private int findWithKey(int key) {
        int count = -1;
        SingleLink n = head;

        while (n != null) {
            count++;
            if (n.data == key) {
                return count;
            }
            n = n.next;
        }
        return -1;
    }

    private SingleLink findWithIndex(int index) {
        int search = 0;
        SingleLink current = head;

        while (current != null) {
            if (search == index && search < listSize()) {
                break;
            }
            current = current.next;
            search++;
        }
        return current;
    }

    private SingleLink getNode(int key) {
        SingleLink current = head;

        while (current != null) {
            if (current.data == key) {
                return current;
            } else {
                current = current.next;
            }
        }
        return null;
    }

    private void insertLast(int data) {
        SingleLink current = head;

        while (current.next != null) {
            current = current.next;
        }
        current.next = new SingleLink(data);
        size++;
    }

    private void insertFirst(int data) {
        SingleLink newNode = new SingleLink(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    private void deleteLast() {
        SingleLink node = head;
        while (node.next.next != null) {
            node = node.next;
        }
        node.next = null;
    }

    private SingleLink deleteFirst() {
        if (isEmpty()) {
            return null;
        }
        SingleLink ref = head;
        head = head.next;
        size--;
        return ref;
    }

    private void printList() {
        SingleLink current = head;

        while (current != null) {
            current.print();
            current = current.next;
        }
        System.out.println();
    }

    private int listSize() {
        return size;
    }

    private boolean isEmpty() {
        return head == null;
    }
}


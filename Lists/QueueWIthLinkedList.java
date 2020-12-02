package Lists;

public class QueueWIthLinkedList {
    SingleLink head;

    public static void main(String[] args) {
        QueueWIthLinkedList obj = new QueueWIthLinkedList();

        obj.enqueue(10);
        obj.enqueue(20);
        obj.enqueue(30);
        obj.enqueue(40);
        obj.enqueue(50);
        System.out.println("Peek " + obj.peek().data);
        obj.enqueue(10);
        obj.dequeue();
        obj.enqueue(60);
        obj.dequeue();
        obj.print();

    }

    private SingleLink peek() {
        SingleLink current = head;

        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    private void dequeue() {
        SingleLink node = head;
        while (node.next.next != null) {
            node = node.next;
        }
        System.out.println("Outted Element --> " + node.next.data);
        node.next = null;
    }

    private void enqueue(int data) {
        SingleLink newNode = new SingleLink(data);
        newNode.next = head;
        head = newNode;
    }


    private void print() {
        SingleLink current = head;

        System.out.print("In ");
        while (current != null) {
            System.out.print(" --> " + current.data);
            current = current.next;
        }
        System.out.print(" --> Out");
    }
}

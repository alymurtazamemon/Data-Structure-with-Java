package StackandQueue;

public class PriorityQueue {
    int front, rear;
    int[] array;

    public PriorityQueue(int length) {
        front = -1;
       // rear = -1;
        array = new int[length];
    }

    public static void main(String[] args) {
        PriorityQueue obj = new PriorityQueue(10);

        obj.insert(3);
        obj.insert(7);
        obj.insert(9);
        obj.insert(2);
        obj.insert(5);
        obj.insert(1);
        obj.insert(10);
        obj.printQueue();
        System.out.println();

        obj.delete();
        obj.delete();
        obj.delete();
        obj.delete();
        obj.delete();
        obj.delete();
        obj.delete();
        obj.printQueue();
        System.out.println();

       // System.out.println(obj.peek());
    }

    public void insert(int data) {
        if (isEmpty()) {
            //rear = 0;
            array[++front] = data;
        } else {
            if (isFull()) {
                System.out.println("Not inserted , Array is Full");
            } else {
                for (int i = 0; i <= front; i++) {
                    if (array[i] < data) {
                        for (int j = front; j >= i; j--) {
                            array[j + 1] = array[j];
                        }
                        front++;
                        array[i] = data;
                        break;
                    }
                }
                if (data < array[front]) {
                    array[++front] = data;
                }
            }
        }
    }

    public void delete() {
        if (isEmpty()) {
            System.out.println("Array is Empty");
        } else {
            System.out.println("Deleted Item --> " + array[front--]);
        }
    }

    public String peek() {
        return isEmpty() ? "Can't peek array is empty" : "Peeked Item --> " + array[front];
    }

    private boolean isFull() {
        return front == array.length - 1;
    }

    private boolean isEmpty() {
        return front == -1;
    }

    public void printQueue() {
        for (int i = front; i >= 0; i--) {
            System.out.print(array[i] + ", ");
        }
    }
}

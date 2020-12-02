package StackandQueue;

public class Queue {
    private int[] array;
    private int front, rear;

    public Queue(int size) {
        array = new int[size];
        front = 0;
        rear = -1;
    }

    public static void main(String[] args) {
        Queue obj = new Queue(10);
        obj.enqueue(10);
        obj.enqueue(12);
        obj.enqueue(13);
        obj.enqueue(14);
        obj.enqueue(11);
        obj.show();
    }

    private boolean isEmpty() {
        return rear == -1;
    }

    private void enqueue(int item) {
        array[++rear] = item;
    }

    private String dequeue() {
        if (!isEmpty()) {
            int num = array[front];
            for (int i = 0; i < rear; i++) {
                array[i] = array[i + 1];
            }
            rear--;
            return num + "";
        } else {
            return "Array is Empty";
        }
    }

    private String front() {
        if (!isEmpty()) {
            return array[front] + "";
        }
        return "Array is Empty";
    }

    private void show() {
        if (!isEmpty()) {
            for (int i = 0; i <= rear; i++) {
                System.out.println(array[i]);
            }
        } else {
            System.out.println("Array is Empty");
        }
    }
}

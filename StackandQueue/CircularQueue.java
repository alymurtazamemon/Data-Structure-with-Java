package StackandQueue;

public class CircularQueue {
    int front, rear;
    int[] array;

    public CircularQueue(int size) {
        array = new int[size];
    }

    public static void main(String[] args) {
        CircularQueue obj = new CircularQueue(5);

        obj.enqueue(10);
        obj.enqueue(10);
        obj.enqueue(10);
        obj.enqueue(10);
        obj.enqueue(10);

    }

    private void enqueue(int item) {
        if (size() == array.length-1) {
//            int numItems = size();
//            int[] newArray = new int[array.length * 2];
//            System.arraycopy(array, front, newArray, 0, array.length - front);
//            System.arraycopy(array, 0, newArray, array.length - front, rear);
//
//            front = 0;
//            rear = numItems;
            System.out.println("Array is Full");
        }

        array[rear] = item;
        if (rear < array.length - 1) {
            rear++;
        } else {
            rear = 0;
        }
    }

    private String dequeue() {
        if (size() == 0) {
            return "Array is Empty";
        }

        String str = array[front++] + "";
        if (size() == 0) {
            front = 0;
            rear = 0;
        } else if (front == array.length) {
            front = 0;
        }
        return str;
    }

    private String peek() {
        if (size() == 0) {
            return "Array is Empty";
        }
        return array[front] + "";
    }

    private int size() {
        if (front <= rear) {
            return rear - front;
        } else {
            return rear - front + array.length - 1;
        }
    }

    private void printQueue() {
        if (front <= rear) {
            for (int i = front; i < rear; i++) {
                System.out.println(array[i]);
            }
        } else {
            for (int i = front; i < array.length; i++) {
                System.out.println(array[i]);
            }
            for (int i = 0; i < rear; i++) {
                System.out.println(array[i]);
            }
        }
    }
}

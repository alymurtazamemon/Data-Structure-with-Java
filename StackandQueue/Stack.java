package StackandQueue;

public class Stack {
    int top;
    int[] array;

    public Stack(int size) {
        array = new int[size];
        top = -1;
    }

    public static void main(String[] args) {
        Stack obj = new Stack(10);
        obj.push(50);
        obj.push(40);
        obj.push(30);
        obj.push(20);
        obj.push(10);
        obj.push(100);
        obj.push(200);
        obj.push(300);
        obj.push(400);
        obj.push(500);
        obj.push(600);
        System.out.println("Peek : " + obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println("Peek : " + obj.peek());
        obj.showStack();
    }

    private void push(int item) {
        if (isFull()) {
            System.out.println("Can't push : array is full");
        } else {
            array[++top] = item;
        }
    }

    private String pop() {
        if (isEmpty()) {
            return "Can't pop : array is empty";
        } else {
            return array[top--] + "";
        }
    }

    private boolean isFull() {
        return top == array.length - 1;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private String peek() {
        if (isEmpty()) {
            return "Can't peek : array is empty";
        } else
            return array[top] + "";
    }

    private void showStack() {
        for (int i = top; i >= 0; i--) {
            System.out.print(array[i]+" ");
        }
    }
}

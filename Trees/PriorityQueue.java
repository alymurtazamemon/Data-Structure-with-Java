package Trees;

public class PriorityQueue {
    int front, rear;
    CharNode[] array;

    public PriorityQueue(int length) {
        front = -1;
        rear = -1;
        array = new CharNode[length];
    }

    public void insert(CharNode node) {
        if (isEmpty()) {
            rear = 0;
            array[++front] = node;
        } else {
            if (isFull()) {
                System.out.println("Not inserted , Array is Full");
            } else {
                for (int i = 0; i <= front; i++) {
                    if (array[i].characterFrequency < node.characterFrequency) {
                        for (int j = front; j >= i; j--) {
                            array[j + 1] = array[j];
                        }
                        front++;
                        array[i] = node;
                        break;
                    }
                }
                if (node.characterFrequency <= array[front].characterFrequency) {
                    array[++front] = node;
                }
            }
        }
    }

    public CharNode delete() {
        return isEmpty() ? null : array[front--];
    }

    public CharNode peek() {
        return isEmpty() ? null : array[front];
    }

    private boolean isFull() {
        return front == array.length - 1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public void printQueue() {
        for (int i = front; i >= 0; i--) {
            System.out.println(array[i].character + " it's frequency --> "+array[i].characterFrequency);
        }
    }
}

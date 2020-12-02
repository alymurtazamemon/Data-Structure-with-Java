package Lists;

public class Palindrome {
    CharNode head;
    int size = 0;

    public static void main(String[] args) {
        Palindrome obj = new Palindrome();

        String str = "civic";
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            obj.insert(ch[i]);
        }
        System.out.println(obj.getFirst().data);
        System.out.println(obj.getLast().data);
        System.out.println(obj.getFirst().data);
        System.out.println(obj.getLast().data);
    }

    private CharNode find(int index) {
        CharNode current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current;
            }
            count++;
            current = current.next;
        }
        return null;
    }

    private CharNode getLast() {
        CharNode current = head;
        CharNode pre = find(size - 1);
        System.out.println("p"+pre.data);
        while (current.next != null) {
            current = current.next;
        }
        pre.next = current.next;
        size--;
        return current;
    }

    private CharNode getFirst() {
        CharNode remove = head;
        head = head.next;
        size--;
        return remove;
    }

    private void insert(char ch) {
        CharNode newNode = new CharNode(ch);
        newNode.next = head;
        head = newNode;
        size++;
    }

    private void print() {
        CharNode current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}

package Recursion;

public class TowerOfHenoi {
    public static void main(String[] args) {
        TowerOfHenoi object = new TowerOfHenoi();
        object.doTower(4, 'A', 'B', 'C');
    }

    private void doTower(int disks, char s, char i, char d) {
        if (disks == 1) {
            System.out.println("Disk 1 from " + s + " to " + d);
        } else {
            doTower(disks - 1, s, d, i);
            System.out.println("Disks " + disks + " from " + s + " to " + d);
            doTower(disks - 1, i, s, d);
        }
    }

    private void doTowerWithStack(Stack A, Stack B, Stack C) {

    }
}

class Stack {
    private Link head;
    private int size = 0;

    public void insert(int data) {
        Link newNode = new Link(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public int size() {
        return size;
    }

    public void delete() {
        Link removeNode = head;
        head = head.next;
        removeNode = null;
    }

    public void print() {
        Link n = head;

        System.out.print("Head ");
        while (n != null) {
            System.out.print(" --> " + n.data);
            n = n.next;
        }
    }
}

class Link {
    int data;
    Link next;

    public Link(int data) {
        this.data = data;
    }
}
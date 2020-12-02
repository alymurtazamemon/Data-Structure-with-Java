package Trees;

public class MinAndMax {
    Node root;

    public static void main(String[] args) {
        MinAndMax obj = new MinAndMax();
        obj.root = new Node(60);
        obj.insert(10);
        obj.insert(20);
        obj.insert(30);
        obj.insert(40);
        obj.insert(50);

        obj.inOrder(obj.root);
        System.out.println();
        System.out.println("Mimimum --> " + obj.minimum(obj.root));
        System.out.println("Maximum --> " + obj.maximum(obj.root));
    }

    private int maximum(Node node) {
        Node n = node;

        while (n != null) {
            if (n.rs == null) {
                return n.data;
            }
            n = n.rs;
        }
        return -1;
    }

    private int minimum(Node node) {
        Node n = node;

        while (n != null) {
            if (n.ls == null) {
                return n.data;
            }
            n = n.ls;
        }
        return -1;
    }

    private void insert(int data) {
        Node newNode = new Node(data);
        Node n = root;
        if (n == null) {
            n = newNode;
        } else {
            while (true) {
                if (data < n.data) {
                    if (n.ls == null) {
                        n.ls = newNode;
                        return;
                    }
                    n = n.ls;
                } else if (data > n.data) {
                    if (n.rs == null) {
                        n.rs = newNode;
                        return;
                    }
                    n = n.rs;
                }
            }
        }
    }

    private void inOrder(Node n) {

        if (n != null) {
            inOrder(n.ls);
            System.out.print(n.data + ", ");
            inOrder(n.rs);
        }
    }
}

package Trees;

public class BinarySearchTree {
    Node root;

    public static void main(String[] args) {
        BinarySearchTree t = new BinarySearchTree();
        t.root = new Node(13);
        t.insert(10);
        t.insert(8);
        t.insert(12);
        t.insert(7);
        t.insert(15);
        t.insert(14);
        t.insert(11);
        t.insert(16);
        t.insert(9);


        System.out.print("InOrder --> ");
        t.inOrder(t.root);
        System.out.println();

//        System.out.print("PreOrder --> ");
//        t.preOrder(t.root);
//        System.out.println();
//
//        System.out.print("PostOrder --> ");
//        t.postOrder(t.root);
//        System.out.println();

        t.delete(8);

        System.out.print("InOrder --> ");
        t.inOrder(t.root);
        System.out.println();
    }

    private void delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeft = true;

        while (current.data != key) {
            parent = current;
            if (key < current.data) {
                isLeft = true;
                current = current.ls;
            } else if (key > current.data) {
                isLeft = false;
                current = current.rs;
            }
            if (current == null) {
                System.out.println("Node Not Found");
                return;
            }
        }

        if (current.ls == null && current.rs == null) {
            if (current == root) {
                root = null;
            } else if (isLeft) {
                parent.ls = null;
            } else {
                parent.rs = null;
            }
        } else if (current.ls == null) {
            if (current == root) {
                root = current.rs;
            } else if (isLeft) {
                parent.ls = current.rs;
            } else {
                parent.rs = current.rs;
            }
        } else if (current.rs == null) {
            if (current == root) {
                root = current.ls;
            } else if (isLeft) {
                parent.ls = current.ls;
            } else {
                parent.rs = current.ls;
            }
        } else {
            Node successor = getSuccessor(current);

            if(current == root){
                root = successor;
            } else if(isLeft){
                parent.ls = successor;
            } else {
                parent.rs = successor;
            }
            successor.ls = current.ls;
        }
    }

    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rs;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.ls;
        }

        if (successor != delNode.rs) {
            successorParent.ls = successor.rs;
            successor.rs = delNode.rs;
        }
        return successor;
    }

    private Node get(int key, Node n) {
        if (n == null) {
            return null;
        }
        if (key == n.data) {
            return n;
        } else if (key < n.data) {
            return get(key, n.ls);
        } else {
            return get(key, n.rs);
        }
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

    private void preOrder(Node n) {
        if (n != null) {
            System.out.print(n.data + ", ");
            preOrder(n.ls);
            preOrder(n.rs);
        }
    }

    private void postOrder(Node n) {
        if (n != null) {
            postOrder(n.ls);
            postOrder(n.rs);
            System.out.print(n.data + ", ");
        }
    }
}

class Node {
    int data;
    Node ls, rs;

    public Node(int data) {
        this.data = data;
    }
}

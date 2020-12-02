package Lists;

// Links class
public class SingleLink {
    //Declaring the instance variable for data and link.
    int data;
    SingleLink next;

    //Constructor that create a node with given data.
    public SingleLink(int data) {
        this.data = data;
    }

    // Print the node data.
    public void print() {
        System.out.print(data + ", ");
    }
}

/* Tree node class*/
public class Node {
    /*Pointer for the left child of this node*/
    public Node left;

    /* Pointer for the right child of this node*/
    public Node right;

    /* Stores value of current Node */
    int value;

    /* Constructor that initialise node data to data*/
    Node( int data) {
        this.value = data;
    }
}

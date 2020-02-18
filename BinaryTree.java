/* Binary tree implementation*/
public class BinaryTree {
    /* Root node */
    public Node root;

    /* Function to insert an element into the tree*/
    public void insert( int data ) {
        /* Inserting in an empty tree */
        if( root == null ) {
            root = new Node(data);
        }
        else
        {
            /* Search for a place to insert the node */
            Node prev = null;
            Node current = root;

            /* Traverse tree till appropriate leaf node */
            while( current != null ) {

                prev = current;

                if( data < current.value ) {
                    current = current.left;
                }
                else {
                    current = current.right;
                }
            }

            /* Leaf Node found, Inserting element */
            if( data < prev.value)
                prev.left = new  Node( data );
            else
                prev.right = new Node( data);
        }
    }

    /* Function to print the element of a node */
    protected void visit(Node p) {
        System.out.print(p.value + " ");
    }

    /* Traverse tree from left to right subtree LVR*/
    public void preorder( Node current) {

        if( current != null) {
            visit(current);          //Visit left subtree before right subtree
            preorder(current.left);  //Traverse left subtree
            preorder(current.right); //Traverse Right subtree
        }
    }

    /* Traverse tree in order VLR*/
    public void inorder( Node current ) {

        if ( current != null) {
            inorder(current.left);  //Traverse left subtree
            visit(current);
            inorder(current.right); //Traverse Right subtree
        }
    }

    /* Traverse tree from right to left LRV*/
    public void postorder( Node current) {

            if( current != null) {
                postorder(current.left);  //Traverse left subtree
                postorder(current.right); //Traverse Right subtree
                visit(current);          //Visit left subtree before right subtree
            }
    }

    /* Graph to remove a node from the tree */
    public void delete( int data ) {
        //if tree is empty, then do nothing
        if(root == null) {
            return;
        }

        /*Search for tree to delete */
        Node prev = null;
        Node parent = null;
        Node current = root;

        /* Search for the node to delete */
        while( current != null && current.value != data) {

            parent = prev;
            prev = current;

            if(data < current.value)
                current = current.left;
            else
                current = current.right;
        }

        /* If node was not found in the tree */
        if ( current == null || current.value != data ) {
            System.out.println(" Value not in tree");
            return;
        }

        /* Now that the node was found */

        /* Case 1: Node is a leaf node */
        if( current.left == null && current.right == null ) {
            System.out.println("The node is a leaf node");
            /* Check which child of parent it*/
            if( prev.left == current)
                prev.left = null;
            else
                prev.right = null;

        }
        /* Case 2a: Node has only 1 child ( right child ) */
        else if ( current.left == null && current.right != null) {
            /* Check which child of the parent the node is */
            if( current == prev.left) //if it is the right child
                prev.left = current.right;
            else
                prev.right = current.right;
        }
        /* Case2b: Node has only 1 child (right child ) */
        else if ( current.left != null && current.right == null ) {

            /* Check which child of the parent the node is */
            if (current == prev.left) //if it is the right child
                prev.left = current.left;
            else
                prev.right = current.left;
        }
        /* Case3: Node has both children */
        else{
            /*Delete by merge or copying*/
        }

    }
}


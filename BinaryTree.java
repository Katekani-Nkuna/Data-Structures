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
        Node current = root;

        /* Search for the node to delete */
        while( current != null && current.value != data) {

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
            //deleteByMerge(prev, current);
            deleteByCopy ( prev, current);
        }

    }

    /* Function to delete by merging left and right subtrees of deleted node*/
   private void deleteByMerge( Node parent, Node node) {

        Node current = node.left;

        /* First find the rightmost node of the left subtree */
        while ( current.right != null ) {
            current = current.right;
        }

        /* Set left subtree Max node to node's right subtree*/
        current.right = node.right;

        /* left subtree should now sit in place of the node */

        /* If the node is the root node, then left subtree root, becomes tree root */
        if( parent == null ) {
            root = node.left;
        }
        else if( parent.left == node)
            parent.left = current;
        else
            parent.right = current;

        node.right = null;
    }

    /* Function to delete by merging left and right subtrees of deleted node*/
    private void deleteByCopy ( Node parent, Node node ) {

        Node current = node.left;
        Node prev = null;

        /* First find the rightmost node of the left subtree */
        while ( current.right != null ) {
            prev = current;
            current = current.right;
        }

        /* Copy the predecessor to new node*/
        node.value = current.value;

        if( current.left == null && current.right == null) {

            /* Case 1: Node is a leaf node */
            if( current.left == null && current.right == null ) {
                System.out.println("The node is a leaf node");
                /* Check which child of parent it is*/
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
        }
    }
}


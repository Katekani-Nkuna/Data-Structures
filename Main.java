public class Main {

    public static void main(String[] args){
        System.out.println("Hello World");

        BinaryTree tree = new BinaryTree();
        /* Test inserting on an empty tree*/
        tree.insert(15);

        /* Test inserting on a non-empty tree */
        tree.insert(10);

        tree.insert(30);
        /* Test inserting on a non-empty tree */
        tree.insert(5);

        tree.insert(11);
        tree.insert(20);
        tree.insert(40);
        tree.insert(12);


        tree.inorder(tree.root);

        tree.delete(15);
        System.out.println("");

        tree.inorder(tree.root);
    }
}

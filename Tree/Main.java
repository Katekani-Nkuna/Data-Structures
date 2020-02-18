public class Main {

    public static void main(String[] args){
        System.out.println("Hello World");

        BinaryTree tree = new BinaryTree();
        /* Test inserting on an empty tree*/
        tree.insert(15);

        /* Test inserting on a non-empty tree */
        tree.insert(4);

        tree.insert(3);
        /* Test inserting on a non-empty tree */
        tree.insert(17);

        tree.insert(20);


       //tree.insert(1);
        tree.inorder(tree.root);
        tree.delete(17);
        System.out.println("");
        tree.inorder(tree.root);

        tree.delete(17);
        System.out.println("");
        tree.inorder(tree.root);

        tree.delete(17);
        System.out.println("");
        tree.inorder(tree.root);
    }
}

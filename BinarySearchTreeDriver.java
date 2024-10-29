import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinarySearchTreeDriver<T extends Comparable<T>> {

    public static void main(String[] args) {

        // testing
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);

        bst.inOrder();

        bst.delete(15);

        bst.inOrder();
    }
}

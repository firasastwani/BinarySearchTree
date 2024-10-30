import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinarySearchTreeDriver<T extends Comparable<T>> {

    public static void main(String[] args) {


        if(args.length != 1) {
            System.out.println("no inputted file");
            return;
        }


        String fileName = args[0];

        File file = new File(fileName);

        Scanner scan;

        try{
            scan = new Scanner(file);
        } catch (FileNotFoundException e){

            System.out.println("inputted file was not found");
            return;
        }

        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter list type (i-int, d-double, s-string): ");

        String listType = inputScanner.nextLine();

        BinarySearchTree<?> bst = null;

        switch(listType) {
            case "i":
                BinarySearchTree<Integer> intBST = new BinarySearchTree<>();
                while(scan.hasNextInt()) {
                    intBST.insert(scan.nextInt());
                }
                bst = intBST;
                break;

            case "d":
                BinarySearchTree<Double> doubleBST = new BinarySearchTree<>();
                while(scan.hasNextDouble()) {
                    doubleBST.insert(scan.nextDouble());
                }
                bst = doubleBST;
                break;

            case "s":
                BinarySearchTree<String> stringBST = new BinarySearchTree<>();
                while(scan.hasNext()) {
                    stringBST.insert(scan.next());
                }
                bst = stringBST;
                break;

            default:
                System.out.println("Input not valid");
                return;
        }

        scan.close();
        inputScanner.close();

        bst.inOrder(); 








        /*
        testing: 

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);

        bst.delete(18);
        bst.inOrder();

        bst.retrive(10);
        bst.retrive(11);

        System.out.println(bst.getSingleParent());
        System.out.println(bst.getNumLeafNodes());

        System.out.println("Cousins: " + bst.getCousins(18));
        */
    }

}

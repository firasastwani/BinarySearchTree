import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@SuppressWarnings("unchecked")
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
                scan.close(); 
                inputScanner.close(); 
                return;
        }
        scan.close();

        System.out.println("Commands:");
        System.out.println("(i) - Insert Item");
        System.out.println("(d) - Delete Item");
        System.out.println("(p) - Print Tree");
        System.out.println("(r) - Retrieve Item");
        System.out.println("(l) - Count Leaf Nodes");
        System.out.println("(s) - Find Single Parents");
        System.out.println("(c) - Find Cousins");
        System.out.println("(q) - Quit program");

        Scanner scanner = new Scanner(System.in);

        boolean cont = true;

        // command handling
        while(cont){

            System.out.print("Enter a command: ");
            String command = scanner.nextLine(); 

            if(command.equals("p")){

                bst.inOrder();
            } else if(command.equals("q")){

                System.out.println("Exiting the program...");
                scanner.close();
                cont = false;
            } else if(command.equals("i")){

                bst.inOrder(); 
                System.out.print("Enter a value to insert: ");
                try {
                    if(listType.equals("i")) {
                        int value = scanner.nextInt();
                        scanner.nextLine();
                        ((BinarySearchTree<Integer>) bst).insert(value);
                        bst.inOrder();
                    } else if(listType.equals("d")) {
                        double value = scanner.nextDouble();
                        scanner.nextLine();
                        ((BinarySearchTree<Double>) bst).insert(value);
                        bst.inOrder();
                    } else if(listType.equals("s")) {
                        String value = scanner.nextLine();
                        ((BinarySearchTree<String>) bst).insert(value);
                        bst.inOrder();
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                    scanner.nextLine(); // clear the invalid input
                }

            } else if(command.equals("d")){

                bst.inOrder();
                System.out.print("Enter a value to delete: ");
                try {
                    if(listType.equals("i")) {
                        int value = scanner.nextInt();
                        scanner.nextLine();
                        ((BinarySearchTree<Integer>) bst).delete(value);
                        bst.inOrder();
                    } else if(listType.equals("d")) {
                        double value = scanner.nextDouble();
                        scanner.nextLine();
                        ((BinarySearchTree<Double>) bst).delete(value);
                        bst.inOrder();
                    } else if(listType.equals("s")) {
                        String value = scanner.nextLine();
                        ((BinarySearchTree<String>) bst).delete(value);
                        bst.inOrder();
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                    scanner.nextLine(); // clear the invalid input
                }

            } else if(command.equals("r")){

                System.out.print("Enter a value to retrieve: ");
                try {
                    if(listType.equals("i")) {
                        int value = scanner.nextInt();
                        scanner.nextLine();
                        if(((BinarySearchTree<Integer>) bst).retrieve(value)){
                            System.out.println("Item found in the tree.");
                        } else {
                            System.out.println("Item not found in the tree.");
                        }
                    } else if(listType.equals("d")) {
                        double value = scanner.nextDouble();
                        scanner.nextLine();
                        if(((BinarySearchTree<Double>) bst).retrieve(value)){
                            System.out.println("Item found in the tree.");
                        } else {
                            System.out.println("Item not found in the tree.");
                        }
                    } else if(listType.equals("s")) {
                        String value = scanner.nextLine();
                        if(((BinarySearchTree<String>) bst).retrieve(value)){
                            System.out.println("Item found in the tree.");
                        } else {
                            System.out.println("Item not found in the tree.");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                    scanner.nextLine(); // clear the invalid input
                }

            } else if(command.equals("l")){

                System.out.println("Number of leaf nodes: " + bst.getNumLeafNodes());

            } else if(command.equals("s")){

                System.out.println("Single parents: " + bst.getSingleParent());

            } else if(command.equals("c")){

                bst.inOrder();
                System.out.print("Enter a number: ");
                try {
                    if(listType.equals("i")) {
                        int value = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Cousins: " + ((BinarySearchTree<Integer>) bst).getCousins(value));
                    } else if(listType.equals("d")) {
                        double value = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Cousins: " + ((BinarySearchTree<Double>) bst).getCousins(value));
                    } else if(listType.equals("s")) {
                        String value = scanner.nextLine();
                        System.out.println("Cousins: " + ((BinarySearchTree<String>) bst).getCousins(value));
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                    scanner.nextLine(); // clear the invalid input
                }
            }

        }
// Testing




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

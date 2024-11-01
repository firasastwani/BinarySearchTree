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
        inputScanner.close(); 

        System.out.println("Commands:");
        System.out.println("(i) - Insert value");
        System.out.println("(d) - Delete value");
        System.out.println("(p) - Print list");
        System.out.println("(l) - length");
        System.out.println("(t) - Print reverse");
        System.out.println("(r) - Reverse list");
        System.out.println("(b) - Delete subsection");
        System.out.println("(s) - Swap alternate");
        System.out.println("(q) - Quit");

        Scanner scanner = new Scanner(System.in);

        boolean cont = true;


        // command handling
        while(cont){

            System.out.print("Enter a command: ");
            String command = scanner.nextLine(); 

            if(command.equals("p")){

                System.out.print("The tree in-order is: ");
                bst.inOrder();
            } else if(command.equals("q")){

                System.out.println("Exiting the program...");
                scanner.close();
                cont = false;
            } else if(command.equals("i")){

                System.out.print("Enter a value to insert: ");
                if (!scanner.hasNextLine()) {
                    System.out.println("No more input available. Exiting...");
                    break;
                }
                if(listType.equals("i")) {
                    if (scanner.hasNextInt()) {
                        int value = scanner.nextInt();
                        scanner.nextLine();
                        ((BinarySearchTree<Integer>) bst).insert(value);
                    } else {
                        System.out.println("Invalid input. Expected an integer.");
                        scanner.nextLine(); // clear the invalid input
                    }
                } else if(listType.equals("d")) {
                    if (scanner.hasNextDouble()) {
                        double value = scanner.nextDouble();
                        scanner.nextLine();
                        ((BinarySearchTree<Double>) bst).insert(value);
                    } else {
                        System.out.println("Invalid input. Expected a double.");
                        scanner.nextLine(); // clear the invalid input
                    }
                } else if(listType.equals("s")) {
                    String value = scanner.nextLine();
                    ((BinarySearchTree<String>) bst).insert(value);
                }

            } else if(command.equals("d")){

                System.out.print("Enter a value to delete: ");
                if (!scanner.hasNextLine()) {
                    System.out.println("No more input available. Exiting...");
                    break;
                }
                if(listType.equals("i")) {
                    if (scanner.hasNextInt()) {
                        int value = scanner.nextInt();
                        scanner.nextLine();
                        ((BinarySearchTree<Integer>) bst).delete(value);
                    } else {
                        System.out.println("Invalid input. Expected an integer.");
                        scanner.nextLine(); // clear the invalid input
                    }
                } else if(listType.equals("d")) {
                    if (scanner.hasNextDouble()) {
                        double value = scanner.nextDouble();
                        scanner.nextLine();
                        ((BinarySearchTree<Double>) bst).delete(value);
                    } else {
                        System.out.println("Invalid input. Expected a double.");
                        scanner.nextLine(); // clear the invalid input
                    }
                } else if(listType.equals("s")) {
                    String value = scanner.nextLine();
                    ((BinarySearchTree<String>) bst).delete(value);
                }

            } else if(command.equals("r")){

                System.out.print("Enter a value to retrieve: ");
                if(listType.equals("i")) {
                    int value = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(((BinarySearchTree<Integer>) bst).retrieve(value));
                } else if(listType.equals("d")) {
                    double value = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println(((BinarySearchTree<Double>) bst).retrieve(value));
                } else if(listType.equals("s")) {
                    String value = scanner.nextLine();
                    System.out.println(((BinarySearchTree<String>) bst).retrieve(value));
                }

            } else if(command.equals("l")){

                System.out.println("Number of leaf nodes: " + bst.getNumLeafNodes());

            } else if(command.equals("s")){

                System.out.println("Single parents: " + bst.getSingleParent());

            } else if(command.equals("c")){

                System.out.print("Enter a value to find cousins: ");
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

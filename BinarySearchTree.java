import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {

    // initializes the root of the tree 
    private NodeType<T> root;

    // inserts a new node with a given key
    public void insert(T key){

        NodeType<T> node = new NodeType<T>(key);
        NodeType<T> current = root; 

        if(root == null){
            root = node;
        } else {
            insertHelper(current, key);
        }

    }

    // helper method for the insert method
    public void insertHelper(NodeType<T> current, T key){

        if (key.compareTo(current.info) < 0) {
            if (current.left == null) {
                current.left = new NodeType<T>(key);
            } else {
                insertHelper(current.left, key);
            }
        } else if (key.compareTo(current.info) > 0) {
            if (current.right == null) {
                current.right = new NodeType<T>(key);
            } else {
                insertHelper(current.right, key);
            }
        }
    }

    // deletes a node with the given key 
    public void delete(T key){

        if(root == null || key == null){
            return;
        } else {
            root = deleteHelper(root, key);
        }
    }

    // helper method for the delete method
    public NodeType<T> deleteHelper(NodeType<T> curr, T key) {
        if (curr == null) {
            return null;
        }

        if (key.compareTo(curr.info) < 0) {
            curr.left = deleteHelper(curr.left, key);
        } else if (key.compareTo(curr.info) > 0) {
            curr.right = deleteHelper(curr.right, key);
        } else {
            if (curr.left == null) {
                return curr.right;
            } else if (curr.right == null) {
                return curr.left;
            }
            
            NodeType<T> pred = getPred(curr.left);
            curr.info = pred.info;
            curr.left = deleteHelper(curr.left, pred.info);
        }
        return curr;
    }

    // returns the predecessor of the given node
    public NodeType<T> getPred(NodeType<T> curr){

        while(curr.right != null){
            curr = curr.right; 
        }

        return curr; 
    }


    // returns true if item is found in the tree, false otherwise
    public boolean retrive(T item){

        return retrieveHelper(root, item);
    }

    // helper method for the retrieve method
    public boolean retrieveHelper(NodeType<T> curr, T item){

        if(curr == null){
            return false;
        }

        if(item.compareTo(curr.info) == 0){
            return true; 
        } else if(item.compareTo(curr.info) < 0){
            return retrieveHelper(curr.left, item);
        } else {
            return retrieveHelper(curr.right, item);
        }
    }

    // prints the nodes of the tree in order
    public void inOrder(){

        LinkedList<T> list =  new LinkedList<>(); 
        NodeType<T> curr = root;

        traverse(curr, list);
        System.out.println(list);
    }


    // helper method for the inOrder method 
    public List<T> traverse(NodeType<T> curr, LinkedList<T> list){

        if(curr.left != null){
            traverse(curr.left, list);
        }

        list.add(curr.info);

        if(curr.right != null){
            traverse(curr.right, list);
        }

        return list;
    }

    // prints the nodes that have only one child 
    public List<T> getSingleParent(){
    
        LinkedList<T> list = new LinkedList<>(); 

        return singleParentHelper(root, list);         
    }

    // helper method for the getSingleParent method
    public List<T> singleParentHelper(NodeType<T> curr, LinkedList<T> list){

        if(curr == null){
            return list; 
        }

        if(curr.left == null && curr.right != null || curr.left != null && curr.right == null){
            list.add(curr.info); 
        }

        singleParentHelper(curr.left, list);
        singleParentHelper(curr.right, list);

        return list; 
    }

    // returns the number of leaf nodes in the tree
    public int getNumLeafNodes(){

        return leafNodesHelper(root); 
    }

    // helper method for the getNumLeafNodes method
    public int leafNodesHelper(NodeType<T> curr){

        if(curr == null){
           return 0; 
        }

        if(curr.left == null && curr.right == null){
            return 1 ;
        }

        return leafNodesHelper(curr.left) + leafNodesHelper(curr.right); 
    }


    public void getCousins(){

        
    }

}

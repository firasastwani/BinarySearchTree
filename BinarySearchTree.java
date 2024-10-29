import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {

    private NodeType<T> root;


    public void insert(T key){

        NodeType<T> node = new NodeType<T>(key);
        NodeType<T> current = root; 

        if(root == null){
            root = node;
        } else {
            insertHelper(current, key);
        }

    }

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


    public void delete(T key){

        if(root == null || key == null){
            return;
        } else {
            root = deleteHelper(root, key);
        }
    }

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

    public NodeType<T> getPred(NodeType<T> curr){

        while(curr.right != null){
            curr = curr.right; 
        }

        return curr; 
    }



    public boolean retrive(T item){

    
    }


    public void inOrder(){

        LinkedList<T> list =  new LinkedList<>(); 
        NodeType<T> curr = root;

        traverse(curr, list);
        System.out.println(list);
    }


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


    public void getSingleParent(){
        

    }


    public void getNumLeafNodes(){


    }


    public void getCousins(){

        
    }
}

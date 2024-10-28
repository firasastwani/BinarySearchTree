public class NodeType <T extends Comparable<T>> {


    public T info;
    public NodeType<T> left;
    public NodeType<T> right;

    public NodeType(T item) {

        this.info = item;
        this.left = null;
        this.right = null;
    }

}

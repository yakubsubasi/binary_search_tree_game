public class Node {
    int key;
    Node left;
    Node right;
    int childrenNumber = 0;

    public Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString(){
        return "[" + key +", "+ childrenNumber +"]";
    }

}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree <E extends Comparable<E>> {

    /**
     * @description Inner Node
     */
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left   = null;
            right  = null;
        }
    }


    private Node root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Add element to tree
     * @param e
     */
    public void add(E e) {
       root = add(root, e);
    }


    /**
     * Insert element in to node as root binary search tree
     * Using recursion algorithm
     * @param node
     * @param e
     * @return Node
     */
    private Node add(Node node, E e) {
        if(node == null) {
            size++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0) {
           node.left = add(node.left, e);
        }
        else if(e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * Judgment element contains in tree
     * @param e
     * @return
     */
    public boolean contains(E e) {
       return contains(root, e);
    }


    /**
     * Search element using recursion algorithm
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {
        if(node == null) {
            return false;
        }

        if(e.compareTo(node.e) == 0) {
           return true;
        }
        else if(e.compareTo(node.e) < 0 ) {
            return contains(node.left, e);
        }
        else{
           return contains(node.right, e);
        }
    }

    /**
     * Pre order traverse
     */
    public void preOrder(){
       preOrder(root);
    }

    private void preOrder(Node node) {
       if(node == null) {
           return;
       }
       System.out.println(node.e);
       preOrder(node.left);
       preOrder(node.right);
    }

    /**
     * In Order traverse
     */
    public void inOrder() {
       inOrder(root);
    }

    private void inOrder(Node node) {
       if(node == null ) {
           return;
       }
       inOrder(node.left);
       System.out.println(node.e);
       inOrder(node.right);
    }

    public void postOrder() {
       postOrder(root);
    }

    private void postOrder(Node node) {
       if(node == null) {
           return;
       }

       postOrder(node.left);
       postOrder(node.right);
       System.out.println(node.e);
    }

    /**
     * Pre Order no recursion
     */
    public void preOrderNoR() {
        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if(cur.right != null) {
                stack.push(cur.right);
            }
            if(cur.left != null) {
                stack.push(cur.left);
            }
        }

    }


    /**
     * Level order traverse
     */
    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
           Node cur = q.remove();
           System.out.println(cur.e);

           if(cur.left != null) {
               q.add(cur.left);
           }
           if(cur.right != null) {
                q.add(cur.right);
           }
        }

    }

    /**
     * Search minimum element
     * @return
     */
    public E minimum() {
       if(size == 0 )  {
           throw new IllegalArgumentException("BST is empty");
       }
       Node minNode = minimum(root);
       return minNode.e;
    }

    private Node minimum(Node node) {
       if(node.left == null) {
           return node;
       }
       return minimum(node.left);
    }

    /**
     * Get maximum element
     * @return
     */
    public E maximum() {
        if(size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        Node maxNode = maximum(root);
        return maxNode.e;
    }

    private Node maximum(Node node) {
        if(node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * Remove minimum node in BST and return minimum element
     * @return
     */
    public E removeMin() {
       E ret = minimum();
       root = removeMin(root);
       return ret;
    }

    private Node removeMin(Node node) {
       if(node.left == null) {
           Node rightNode = node.right;
           node.right = null;
           size--;
           return rightNode;
       }

       node.left = removeMin(node.left);
       return node;
    }

    /**
     * Remove maximum node in BST and return maximum element
     * @return
     */
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {
       if(node.right == null) {
          Node nodeLeft = node.left;
          node.left = null;
          size--;
          return nodeLeft;
       }

       node.right = removeMax(node.right);
       return node;
    }


    public String toString() {
        StringBuilder res = new StringBuilder();
        generateString(root, 0, res);
        return res.toString();
    }

    private void generateString(Node node, int depth, StringBuilder res) {
        if(node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateString(node.left, depth + 1, res);
        generateString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
       StringBuilder res = new StringBuilder();
       for(int i = 0; i < depth; i ++) {
           res.append("--");
       }
       return res.toString();
    }

}

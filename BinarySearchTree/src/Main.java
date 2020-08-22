import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        removeTest();
        System.out.println("Binary test is work!");
    }

    // Test traverse tree
    private static void traverseTree(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for(int num: nums){
            bst.add(num);
        }

        /** binary tree **/
        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////

        // pre order
        bst.preOrder();
        System.out.println();

        // in order
        bst.inOrder();
        System.out.println();

        // post order
        bst.postOrder();
        System.out.println();

        System.out.println("--------------");
        // System.out.println(bst);

        // No recursion pre order
        bst.preOrderNoR();
        System.out.println();

        // level order
        bst.levelOrder();
    }

    private static void  minAndMax() {

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Random random = new Random();

        int n = 1000;
        for(int i = 0; i < n; i ++) {
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> nums = new ArrayList<>();
        while(!bst.isEmpty()) {
            nums.add(bst.removeMin());
        }

        System.out.println("------minimum values-------");
        System.out.println(nums);
        for(int i = 1; i< nums.size(); i++) {
            if(nums.get(i - 1) > nums.get(i)) {
                throw new IllegalArgumentException("BST minimum error!");
            }
        }

        // test maximum values
        for(int i = 0; i < n; i ++) {
            bst.add(random.nextInt(10000));
        }

        nums = new ArrayList<>();
        while(!bst.isEmpty()) {
            nums.add(bst.removeMax());
        }

        System.out.println("------maximum values-------");
        System.out.println(nums);
        for(int i = 1; i< nums.size(); i++) {
            if(nums.get(i - 1) < nums.get(i)) {
                throw new IllegalArgumentException("BST maximum error!");
            }
        }

        System.out.println("Remove test completed.");
    }

    public static void removeTest() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Random random = new Random();
        int n = 10000;
        for(int i = 0; i < n; i ++) {
            bst.add(random.nextInt(n));
        }

        Integer[] order = new Integer[n];
        for(int i = 0; i < n; i ++) {
            order[i] = i;
        }

        // [0...n) range all element
        for(int i = 0; i < n; i ++) {
            if(bst.contains(order[i])) {
                bst.remove(order[i]);
                System.out.println("After remove" + order[i] + ", size=" + bst.size());
            }
        }

        // shuffle order element
        shuffle(order);

        System.out.println("Finally BST size is: " + bst.size());

    }

    private static void shuffle(Object[] arr) {
        for(int i = arr.length - 1; i >= 0; i--) {
           int pos = (int) (Math.random() * (i + 1));
           Object t = arr[pos];
           arr[pos] = arr[i];
           arr[i] = t;
        }

    }

}

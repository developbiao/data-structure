public class Main {

    public static void main(String[] args) {
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
        System.out.println(bst);


        System.out.println("Binary test is work!");

    }
}

public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3,  4, 5, 6, 7, 7, 7, 8};
        ListNode listNode = new ListNode(arr);
        System.out.println("Before list node");
        System.out.println(listNode);
        Solution solution = new Solution();
        solution.removeElements(listNode, 7);
        System.out.println("After list node");
        System.out.println(listNode);
    }
}

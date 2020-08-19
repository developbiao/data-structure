public class Solution4 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return null;
        }

        ListNode res = removeElements(head.next, val);
        if(head.val == val) {
            return res;
        }
        else {
            head.next = res;
            return head;
        }
    }

    public static void main(String[] args){

        int[] nums = {1, 2, 6, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution4()).removeElements(head, 6);
        System.out.println(res);
    }
}

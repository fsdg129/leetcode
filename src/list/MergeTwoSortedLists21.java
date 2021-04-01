package list;

public class MergeTwoSortedLists21 {

	private String name = "21. Merge Two Sorted Lists";
	private String url = "https://leetcode.com/problems/merge-two-sorted-lists/";
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode root = new ListNode(0);
        ListNode current1 = l1;
        ListNode current2 = l2;
        ListNode mergeNode = root;

        while(current1 != null || current2 != null){
            if(current2 == null || (current1 != null && current1.val <= current2.val)){
                mergeNode.next = current1;
                current1 = current1.next;               
            } else {
                mergeNode.next = current2;
                current2 = current2.next;
            }

            mergeNode = mergeNode.next;
        }


        return root.next;
    }
    
    private static String printList(ListNode root){
        StringBuilder sb = new StringBuilder();
        ListNode current = root;
        while(current != null){
            sb.append(current.val);
            sb.append("->");
            current = current.next;
        }
        sb.append("null");

        return sb.toString();
    }
    
    private static ListNode parseListNode(int[] nums){
        if(nums.length <= 0){
            return null;
        }
        ListNode root = new ListNode(0);
        ListNode current = root;
        for(int i=0; i<nums.length; i++){
            current.next = new ListNode(nums[i]);
            current = current.next;
        }

        return root.next;
    }
}

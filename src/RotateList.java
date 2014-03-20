public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) return head;
        int len = 0;
        
        ListNode fast = head;
        while (n > 0) {
            n--;
            if (fast.next != null)
                fast = fast.next;
            else
                fast = head;
        }
        if (fast == head) return head;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}

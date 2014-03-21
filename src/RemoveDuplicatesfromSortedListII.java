public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null) {
            ListNode n_cur = prev.next;
            while (n_cur.next != null && n_cur.next.val == prev.next.val)
                n_cur = n_cur.next;
            if (n_cur != prev.next)
                prev.next = n_cur.next;
            else
                prev = n_cur;
        }
        return dummyHead.next;
    }
}

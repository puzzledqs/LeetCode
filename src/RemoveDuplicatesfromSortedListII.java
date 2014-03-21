public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null) {
            ListNode n_cur = prev.next.next;
            while (n_cur != null && n_cur.val == prev.next.val)
                n_cur = n_cur.next;
            if (n_cur == prev.next.next)
                prev = prev.next;
            else
                prev.next = n_cur;
        }
        return dummyHead.next;
    }
}

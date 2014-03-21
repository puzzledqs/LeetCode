public class PopulateNextRightPointersII {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode head = root;
        while (head != null) {
            TreeLinkNode n_cur = head;
            TreeLinkNode p1 = null, nextHead = null;
            while (n_cur != null) {
                if (n_cur.left != null) {
                    if (nextHead == null)
                        nextHead = n_cur.left;
                    if (p1 == null)
                        p1 = n_cur.left;
                    else {
                        p1.next = n_cur.left;
                        p1 = p1.next;
                    }
                }
                if (n_cur.right != null) {
                    if (nextHead == null)
                        nextHead = n_cur.right;
                    if (p1 == null)
                        p1 = n_cur.right;
                    else {
                        p1.next = n_cur.right;
                        p1 = p1.next;
                    }
                }
                n_cur = n_cur.next;
            }
            head = nextHead;
        }
    }
}

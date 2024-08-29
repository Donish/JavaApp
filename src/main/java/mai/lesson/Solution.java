package mai.lesson;

import java.awt.*;

public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = new ListNode();
        int sum = 0;

        sum = l1.val + l2.val;
        res.val = sum % 10;
        if (l1.next != null || l2.next != null) res.next = new ListNode();
        if (sum / 10 == 1) res.next = new ListNode();
        recAdd(res.next, l1.next, l2.next, sum / 10);


        return res;
    }

    private static void recAdd(ListNode res, ListNode l1, ListNode l2, int extra) {

        if (l1 == null && l2 == null && extra == 0) {
            return;
        } else if (l1 == null && l2 == null && extra == 1) {
            res.val = 1;
            return;
        }
        int sum = 0;
        if (l1 == null) {
            sum = l2.val + extra;
            res.val = sum % 10;
            if (l2.next != null && sum / 10 == 0)res.next = new ListNode();
            recAdd(res.next, l1, l2.next, sum / 10);
        } else if (l2 == null) {
            sum = l1.val + extra;
            res.val = sum % 10;
            if (l1.next != null && sum / 10 == 0) res.next = new ListNode();
            recAdd(res.next, l1.next, l2, sum / 10);
        } else {
            sum = l1.val + l2.val + extra;
            res.val = sum % 10;
            if ((l1.next != null || l2.next != null) && sum / 10 == 0) res.next = new ListNode();
            recAdd(res.next, l1.next, l2.next, sum / 10);
        }

    }
}

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public static void main(String[] args) {
        System.out.println(getNum());
    }

    public static long getNumber(ListNode binary) {
        ListNode temp = binary;
        long num = 0;
        int length =0;
        while(temp != null) {
            temp = temp.next;
            length++;
        }

        temp = binary;

        while(length >0) {
            num += temp.val * Math.pow(2, length);
            length--;
            temp = temp.next;
        }

        return num;
    }
}
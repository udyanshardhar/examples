package learn;


class ListNode {
    public int value;
    public ListNode nextNode;
    public ListNode(int value){
        this.value =value;
    }
    public ListNode(int value, ListNode nextNode){
        this.value =value;
        this.nextNode = nextNode;
    }

}
public class MergeTwoLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3, new ListNode(7, new ListNode(11)));
        ListNode l2 = new ListNode(2, new ListNode(9, new ListNode(10)));
        ListNode x = new MergeTwoLinkedList().mergeTwoSortedList(l1, l2);
        System.out.println(x);
    }

    public ListNode mergeTwoSortedList(ListNode l1, ListNode l2){

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            if(l1.value >= l2.value){
                dummy.nextNode = l2;
                l2 = l2.nextNode;
            }else {
                dummy.nextNode = l1;
                l1 = l1.nextNode;
            }

            dummy = dummy.nextNode;
        }
        if (l1 != null) {
            dummy.nextNode = l1;
        }else {
            dummy.nextNode = l2;
        }
    return head.nextNode;
    }
}

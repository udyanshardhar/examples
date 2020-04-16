package com.us.solutions.list;

import java.util.List;

public class ListTest {
    public static void main(String[] args) {
/*        Solution.ListNode third1=  new Solution.ListNode(3);
        Solution.ListNode second1 =  new Solution.ListNode(2);
        second1.next = third1;
        Solution.ListNode l1 = new Solution.ListNode(1);
        l1.next = second1;



        Solution.ListNode third2 =  new Solution.ListNode(6);
        Solution.ListNode second2 =  new Solution.ListNode(5);
        second2.next = third2;
        Solution.ListNode l2 = new Solution.ListNode(4);
        l2.next = second2;*/


        TreeNode t1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node3.left = new TreeNode(5);

        t1.left = node3;
        t1.right = new TreeNode(2);

        TreeNode t2 = new TreeNode(2);
        TreeNode t2_3 = new TreeNode(3);
        TreeNode t2_1 = new TreeNode(1);
        t2.left = t2_1;
        t2.right = t2_3;
        t2_3.right = new TreeNode(7);
        t2_1.right = new TreeNode(4);
        TreeNode treeNode = new Solution().mergeTrees(t1, t2);
        System.out.println(treeNode);


/*
        Solution.ListNode second1 =  new Solution.ListNode(8);
        Solution.ListNode l1 = new Solution.ListNode(1);
        l1.next = second1;
        Solution.ListNode l2 = new Solution.ListNode(0);
*/


/*        Solution.ListNode l1 = new Solution.ListNode(1);
        Solution.ListNode l2 = new Solution.ListNode(9);
        l2.next = new Solution.ListNode(9);*/

/*        Solution.ListNode listNode = new Solution().addTwoNumbers(l1, l2);

        Solution.ListNode pr = listNode;
        String arrow = "";
        while (pr != null ){
            System.out.print(pr.val);
            arrow = pr.next != null ? " -> " : "\n";
            System.out.print(arrow);
            pr = pr.next;
        }*/

        // int[] nums = {0,3,0,1,1,-1};
        Solution solution = new Solution();
        //solution.threeSum(nums);
        List<String> strings = solution.letterCombinations("23");
        System.out.println(strings);

    }

}

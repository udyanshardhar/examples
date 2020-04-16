package com.us.solutions.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 =  new ListNode(0);
        ListNode temp3 = l3;

        while (l1 != null || l2 != null){
            if(l2 != null && (l1 == null || l1.val > l2.val)){
                temp3.next = new ListNode(l2.val);
                l2 = l2.next;
            }else if(l2 == null || l1.val <= l2.val){
                temp3.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            temp3 = temp3.next;
        }
        l3 = l3.next;

        return l3;

    }




    public static void main(String[] args) {
        new Solution().removeInvalidParentheses("()())()");
    }
    private List<String> removeInvalidParentheses(String s) {
        int openIndex = 0;
        int closeIndex = 0;
        int i = 0;
        while(i < s.length()) {
            if(s.charAt(i) == '('){
                openIndex = i;
                break;
            }
            i++;
        }
        i = s.length() - 1;
        while(i >= 0) {
            if(s.charAt(i) == ')'){
                closeIndex = i;
                break;
            }
            i--;
        }
        if(openIndex >= closeIndex) {
            return new ArrayList<>();
        }
        String correctInput = s.substring(openIndex, closeIndex+1);
        if(correctInput.length() <= 0)
            return new ArrayList<>();

        char[] inputArray = correctInput.toCharArray();
        int sum  = 0;
        i = 0;
        StringBuilder sb = new StringBuilder(correctInput);
        List<Integer> closeList = new ArrayList<>();
        List<Integer> openList = new ArrayList<>();
        List<String> result = new ArrayList<>();
        List<String> tempRes = new ArrayList<>();
        while(i < inputArray.length) {
            boolean isSelf = false;
            if(inputArray[i] == ')'){
                closeList.add(i);
                if(sum > 0){
                    sum = sum - 1;
                }else {
                    String temp1 = sb.substring(0, i+1);
                    inputArray = sb.toString().toCharArray();
                    isSelf = true;
                    for(int node : closeList){
                        StringBuilder temp = new StringBuilder(temp1);
                        tempRes.add(temp.deleteCharAt(node).toString());
                    }
                }
            }else {
                openList.add(i);
                sum = sum + 1;
            }
            //add(tempRes, result);
            if(isSelf){
                i = 0;
            }else {
                i++;
            }
        }

        System.out.println(inputArray);
        return new ArrayList<>();
    }

/*    private void add(List<String> addon, List<String> result) {
        if(result.size() != 0){
            result.stream().
        }
    }*/


    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
            return null;
        }

        if(t1 != null && t2 == null){
            return t1;

        }
        if(t1 == null && t2 != null){
            return t2;
        }

        TreeNode tempNode = new TreeNode(t1.val + t2.val);
        tempNode.left = mergeTrees(t1.left, t2.left);
        tempNode.right = mergeTrees(t1.right, t2.right);
        return tempNode;
    }

    public List<String> letterCombinations(String digits) {
        if(digits.equals("") || digits.length() == 0 || digits.indexOf(1) > 0) {
            return new ArrayList<>();
        }
        HashMap<Character, String> mapping = getMapping();
        List<String> listOfinputs = new ArrayList<>();
        for(char in : digits.toCharArray()) {
            listOfinputs.add(mapping.get(in));
        }

        List<String> result = new ArrayList<>();

        getPossibleCombination(listOfinputs, new StringBuilder(), result);
        return result;
    }

    private void getPossibleCombination(List<String> listOfinputs, StringBuilder curRes, List<String> result) {
        if(curRes.length() == listOfinputs.size()) {
            result.add(curRes.toString());
            return;
        }
        String input = listOfinputs.get(curRes.length());
        for(int i = 0; i < input.length(); i++) {
            curRes = curRes.append(input.charAt(i));
            getPossibleCombination(listOfinputs, curRes, result);
            curRes.deleteCharAt(curRes.length() - 1);
        }
    }


    public static HashMap<Character, String> getMapping(){
        HashMap<Character, String> mapping = new HashMap<>();
        mapping.put('2', "abc");
        mapping.put('3', "def");
        mapping.put('4', "ghi");
        mapping.put('5', "jkl");
        mapping.put('6', "mno");
        mapping.put('7', "pqrs");
        mapping.put('8', "tuv");
        mapping.put('9', "wxyz");
        return mapping;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3) return result;
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length - 2) {
            if(nums[i] > 0) break;
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    System.out.println(nums[i] +", "+  nums[j]+","+nums[k]);
                }
                if(sum <= 0){
                    while(nums[j] == nums[++j] && j < k);
                }
                if(sum >= 0){
                    while(nums[k--] == nums[k] && j < k);
                }
            }
            while(nums[i] == nums[++i] && i < nums.length - 2);
        }
        return result;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String numberList1 = "";
        String numberList2 = "";
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while(temp1 != null || temp2 != null){
            if(temp1 != null) {
                numberList1 = numberList1+temp1.val;
                temp1 = temp1.next;
            }

            if(temp2 != null) {
                numberList2 = numberList2+temp2.val;
                temp2 = temp2.next;
            }
        }

        char[] input1 = numberList1.toCharArray();
        char[] input2 = numberList2.toCharArray();

        ListNode parent = null;

        if(input1.length == 1 && input2.length == 1) {
            int temp = Integer.valueOf((String.valueOf(input1[0]))) + Integer.valueOf((String.valueOf(input2[0])));
            if(temp < 10) {
                return new ListNode(temp);
            }
            String t1 =  String.valueOf(temp);
            parent = new ListNode(Integer.valueOf(t1.substring(1)));
            parent.next = new ListNode(Integer.valueOf(t1.substring(0, 1)));
            return parent;
        }
        int loopLength = input1.length > input2.length ? input1.length : input2.length ;
        ListNode previousNode = null;
        int carryForward = 0;
        int i = 0;
        while (i < loopLength || carryForward != 0) {
            int temp  = 0;
            if(i < input1.length){
                temp = temp + Integer.valueOf((String.valueOf(input1[i])));
            }
            if(i < input2.length){
                temp = temp + Integer.valueOf((String.valueOf(input2[i])));
            }
            temp = carryForward + temp;
            carryForward = 0;
            if(temp > 9) {
                String s = String.valueOf(temp);
                carryForward = 1;
                temp = Integer.valueOf(s.substring(1));

            }
            ListNode currentNode = new ListNode(temp);
            if(parent == null) {
                parent = currentNode;
                previousNode = currentNode;
            }else {
                previousNode.next = currentNode;
                previousNode = currentNode;
            }

            i++;
        }
        return parent;

    }
}

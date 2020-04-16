package com.us.solutions;

import com.us.solutions.tree.Palindrome;

import java.util.Arrays;

public class LinksToAllProblems {
    public static void main(String[] args) {
        System.out.println(new Anagram().isAnagram("udyan", "uadyn"));
        System.out.println(new ArrayContainsDuplicate().containsDuplicate(new int[]{3,3,5,5,3,4,4}));
        System.out.println(new FindFirstIndexOfNeedle().findNeedle("helullo", "ll"));
        System.out.println(LongestCommonPrefix.getLongestCommonPrefix(Arrays.asList("flower", "flow", "flower")));
        System.out.println(new LongestCommonString().longestCommonString(new String[]{"cc", "c"}));
        System.out.println(new MaxSubArray().findMaxArray(new int[]{-1, 2, 3, -5, 4}));
        System.out.println(new MejorityElement().majorityElement(new int[]{1, 3, 3, 3, 3, 2, 3, 4}));
        System.out.println(new MissingNumberInArray().find(new int[]{1,0, 3, 4}));
        System.out.println(Arrays.toString(new MoveZeroToEnd().move(new int[]{0, 0, 5, 0, 4, 6})));
        System.out.println(new PowerOfTwoNumber().isPowerOfTwo(16));
        System.out.println(new PrimeCount().count(10));
        System.out.println(new RemoveDuplicatesInArrayInPlace().removeDuplicateInPlace(new int []{1, 1, 5, 5, 5, 7}));
        System.out.println(new RemoveElementFromArrayInPlace().removeElementInPlace(new int []{1, 1, 5, 5, 5, 7}, 5));
        System.out.println(Arrays.toString(new ReverseIntArray().reverse(new int[]{1, 2, 3, 4, 5})));
        System.out.println(new ReverseCharArray().reverseCharArray(new char[]{'s', 'd', 'f'}));
        System.out.println(new ReverseInteger().reverseInteger(-412));
        System.out.println(new ReverseString().reverse("dsfsdfsdf"));
        System.out.println(ReverseStringByRecursion.reverseStringByRecursion("udyan", ""));
        System.out.println(new ReverseVowelsOfString().reverseVowelsOfString("leetcode"));
        System.out.println(new RomanToInteger().convert("LVIII"));
        System.out.println(new SquareRoot().findsqrt(16));
        FindDuplicateCharactersInString.printDuplicateCharacters("dfgfdsdg");
        FindPermutationOfString.permutation("", "abc");
        new FindAllSubString().findAllSubString("dsfdsff");
        CheckStringMadeOfNumber.checkStringMadeOfNumber(new String[]{"123", "-123" , "123.12", "abcd123"});
        System.out.println(Palindrome.isPalindromString("abba"));
    }
}

package learn.str;

import java.util.*;

public class IntegerProblem {
    public static void main(String[] args) {

        // one missing number
        //printMissingNumber(new int[]{1, 2, 3, 4, 6}, 6);

        // two missing number
        //printMissingNumber(new int[]{1, 2, 3, 4, 6, 7, 9, 8, 10}, 10);

        // three missing number
        //printMissingNumber(new int[]{1, 2, 3, 4, 6, 9, 8}, 10);

        // four missing number
        //printMissingNumber(new int[]{1, 2, 3, 4, 9, 8}, 10);

        // Only one missing number in array
        //int[] iArray = new int[]{1, 2, 3, 5};
        //int missingNumber = getMissingNumber(iArray, 5, 1);

        // removeDuplicateFromInt(new int[]{1, 3, 3, 4, 5});
        // maxMinOfArray(new int[]{1, 3, 55, 65, 0, 34, 3, 4, 5}, 0);
        // printPairsForSum(new int[]{1, 3, 3, 4, 5}, 10);
        // intersectionOfArray(new int[]{1, 3, 3, 4, 5}, new int[]{1, 3, 4, 5});
        //System.out.println(Arrays.toString(res));
        // System.out.println(findSingle(new int[]{1, 3, 3, 4, 5, 5, 1}));
        // findCommon(new int[]{1, 2, 3, 4, 5, 8, 9}, new int[]{1, 2, 3, 5, 1}, new int[]{2, 5, 6, 7, 9});
        // System.out.println(findFirstRepeating(new int[]{1, 2, 2, 3, 4, 5, 1, 8, 9}));
        // System.out.println(findFirstNonRepeating(new int[]{1, 2, 2, 3, 4, 5, 1, 8, 9}));
        // findTopTwoMax(new int[]{1, 2, 2, 3, 4, 5, 1, 8, 9});
         // System.out.println(findSmallestSum(new int[]{1, 2, 4, 5, 8, 9}));
        //System.out.println(subArraySumZeroExists(new int[]{4, 2, -3, 1, 6}));
        // System.out.println(getMaxConsOnes(new int[]{1, 1, 1, 1, 0, 0}));
        int[] pairEqualToSum = findPairSumEqualToTarget(new int[]{3,2,4}, 6, 2);
        System.out.println(pairEqualToSum);

        // String s = "dddddddd";
        //System.out.println(getLongPalindrome(s));
    }

    // Given nums = [2, 7, 11, 15], target = 9,
    //Because nums[0] + nums[1] = 2 + 7 = 9,
    //return [0, 1].
    private static int[] findPairSumEqualToTarget(int[] nums, int target, int method) {
        if(method == 1){
            for(int i =0; i < nums.length; i++){
                int j = i +1;
                while(j < nums.length){
                    if(nums[i]+ nums[j] == target){
                        return new int[]{i, j};
                    }
                    j++;
                }
            }
        }else {
            Map<Integer,Integer> hashMap = new HashMap<>();
            int diff;
            int result[] = new int[2];
            for(int i=0;i<nums.length;i++){
                diff = target - nums[i];
                if(hashMap.containsKey(diff)){
                    result[0] = hashMap.get(diff);
                    result[1] = i;
                    break;
                }else {
                    hashMap.put(nums[i],i);
                }
            }
            return result;
        }
        return new int[]{};
    }

    // FIND UNIQUE LIST OF THREE ELEMENTS THEIR SUM EQUALS TO ZERO.
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

    // This will find the longest Max consucutive 1's in 0,1 array
    public static int getMaxConsOnes(int[] inputArray) {

        int result = 0;
        int temp = 0;
        for(int input: inputArray) {
            if(input == 1){
                temp ++;
                if(temp > result){
                    result = temp;
                }

            }else {
                temp = 0;
            }
        }
        return result;
    }

    /**
     * A general method to find missing values from an integer array in Java.
     * This method will work even if array has more than one missing element.
     */
    private static String getLongPalindrome(String s){
        char[] input = s.toCharArray();
        int arrayLength = input.length;
        String result = String.valueOf(input[0]);

        if(arrayLength == 2){
            if(input[0] == input[1])
                return ""+input[0] + input[1];
        }
        for(int i = 0; i < input.length; i++){

            int j = 1;
            String  midChar = String.valueOf(input[i]);
            while(((i+j) < arrayLength) && ((i-j) >= 0)) {

                String leftChar = String.valueOf(input[i - j]);
                String  rightChar = String.valueOf(input[i + j]);
                String center = "";

                if(input[i-1] == (input[i])){
                    center = ""+input[i-1]+input[i];
                    String temp = getPalindromeForEvenLengthString(i-2, center, i+1, input);
                    if(temp.length() > result.length()){
                        result = temp;
                    }
                }
                if(input[i] == (input[i+1])){
                    center = ""+input[i]+input[i+1];
                    String temp = getPalindromeForEvenLengthString(i-1, center, i+2, input);
                    if(temp.length() > result.length()){
                        result = temp;
                    }
                }

                if((leftChar.equals(rightChar))) {
                    String temp = leftChar+midChar+rightChar;
                    midChar = temp;
                    if(temp.length() > result.length()){
                        result = temp;
                    }
                }else {
                    break;
                }
                j++;
            }
        }

        return result;
    }

    private static String getPalindromeForEvenLengthString(int leftIndex, String midChar, int rightIndex, char[] input) {
        String tempRes = midChar;
        if((leftIndex < 0) && rightIndex ==  input.length -1){
            if(StringProblems.isPalindromString(midChar+input[input.length -1])){
                tempRes = midChar+input[input.length -1];
            }

        }
        if(leftIndex >= 0 && rightIndex < input.length){
            String leftChar = String.valueOf(input[leftIndex]);
            String  rightChar = String.valueOf(input[rightIndex]);
            while (leftIndex >= 0 && rightIndex < input.length) {
                if((leftChar.equals(rightChar))) {
                    String temp = leftChar+midChar+rightChar;
                    if(temp.length() > tempRes.length()){
                        tempRes = temp;
                    }
                }else {
                    break;
                }
                leftIndex--;
                rightIndex++;
            }
        }

        return tempRes;
    }
    /**
     * A general method to find missing values from an integer array in Java.
     * This method will work even if array has more than one missing element.
     */
    private static String getLargestPalindrome1(String s){
        char[] input = s.toCharArray();
        int length = input.length;
        String result = ""+ input[0];
        String rs = StringProblems.reverse(s);
        for(int i = 0; i < length; i++) {
            String subs = s.substring(i);
            for(int j = 0; j <= subs.length(); j++){
                String sub = subs.substring(0, j);
                if(rs.contains(sub)){
                    if(result.length() < sub.length()){
                        result = sub;
                    }
                }
            }
        }

        return result;
    }



    /**
     * A general method to find missing values from an integer array in Java.
     * This method will work even if array has more than one missing element.
     */
    private static String getLargestPalindrome(String s){
        String result = "";
        int i = 1;
        int le = s.length()/2;
        while (i <= le) {
            String subs = s.substring(i);
            String rssub = StringProblems.reverse(subs);
            if(subs.contains(rssub)){
                if(result.length() < subs.length()){
                    result = subs;
                }
            }else {
                subs = s.substring(0, s.length() - i);
                rssub = StringProblems.reverse(subs);
                if(subs.contains(rssub)){
                    if(result.length() < subs.length()){
                        result = subs;
                    }
                }
            }
            i++;
        }

        return result;
    }

    private static int getMissingNumber(int[] inputArray, int elementCount, int methodId) {
        if (methodId == 1) {
            int expectedSum = elementCount * ((elementCount + 1) / 2);
            int actualSum = 0;
            for (int i : inputArray) {
                actualSum += i;
            }

            return expectedSum - actualSum;
        }

        if (methodId == 2) {
            {
                int x1 = inputArray[0];
                int x2 = 1;

        /* For xor of all the elements
           in array */
                for (int i = 1; i < elementCount; i++)
                    x1 = x1 ^ inputArray[i];

        /* For xor of all the elements
           from 1 to n+1 */
                for (int i = 2; i <= elementCount + 1; i++)
                    x2 = x2 ^ i;

                return (x1 ^ x2);
            }
        }
        if (methodId == 3) {
            int missingCount = elementCount - inputArray.length;
            BitSet bitSet = new BitSet(elementCount);

            for (int number : inputArray) {
                bitSet.set(number - 1);
            }

            System.out.printf("Missing numbers in integer array %s, with total number %d is %n", Arrays.toString(inputArray), elementCount);
            int lastMissingIndex = 0;

            for (int i = 0; i < missingCount; i++) {
                lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
                System.out.println(++lastMissingIndex);
            }
        }
        if (methodId == 4) {
            boolean[] ud = new boolean[elementCount+1];
            for(int number : inputArray) {
                ud[number] = true;
            }

            for(int i = 1; i<= elementCount; i++) {
                if(!ud[i]){
                    System.out.println(i);
                }
            }
        }
        return 0;
    }



    public static void removeDuplicateFromInt(int [] input) {
        Arrays.sort(input);
        int [] result = new int[input.length];
        int previous = input[0];
        int resultIndex = 0;
        result[0] = previous;
        for(int i = 0; i<input.length; i++){
            int value = input[i];
            if(value != previous) {
                result[resultIndex] = value;
                resultIndex++;
            }
            previous = value;
        }

        System.out.println(Arrays.toString(result));
    }

    public static <T> boolean contains(final T[] inputArray, final T value, int methodNumber) {
        if(methodNumber == 1) {
            for (final T e: inputArray){
                if(e == value || (value != null && value.equals(e))){
                    return true;
                }
            }
        }else {
            return Arrays.asList(inputArray).contains(value);
        }

        return false;
    }

    public static void maxMinOfArray(final int[] inputArray, int methodNumber) {
        if(methodNumber == 1){
            int smallest = inputArray[0];
            int largest = inputArray[0];
            for(int number: inputArray) {
                if(number > largest) {
                    largest = number;
                }else if(number < smallest){
                    smallest = number;
                }
            }
            System.out.println("smallest = "+ smallest);
            System.out.println("largest = " + largest);
        }else {
            int largest = Integer.MIN_VALUE;
            int smallest = Integer.MAX_VALUE;
            for(int number: inputArray) {
                if(number > largest) {
                    largest = number;
                }else if(number < smallest){
                    smallest = number;

                }
            }
            System.out.println("smallest = "+ smallest);
            System.out.println("largest = " + largest);
        }
    }

    /**
     * Prints all pair of integer values from given array whose sum is is equal to given number.
     * complexity of this solution is O(n^2)
     */
    public static void printPairsForSum(int[] inputArray, int sum) {
        for(int i =0; i < inputArray.length; i++) {
            int first = inputArray[i];
            for(int j = i+1; j < inputArray.length; j++) {
                int second = inputArray[j];
                if(first + second == sum){
                    System.out.printf("(%d, %d) %n", first, second);
                }
            }
        }
    }

    // Java Program to find first duplicate, non-repeated character in a String.

    public static char findFirstNonRepeatedChar(String inputString, int methodName) {
        if(methodName == 1) {
            Map<Character, Integer> count = new LinkedHashMap<>(inputString.length());
            for (char in : inputString.toCharArray()) {
                count.put(in, count.get(in) != 0 ? count.get(in)+1: 1);
            }

            for (Map.Entry<Character, Integer> input: count.entrySet()) {
                if(input.getValue() == 1) {
                    return input.getKey();
                }
            }
        }else {

            Set<Character> repeating = new HashSet<>();
            List<Character> nonRepeating = new ArrayList<>();

            for (char in: inputString.toCharArray()) {
                if(repeating.contains(in)){
                    continue;
                }

                if(nonRepeating.contains(in)){
                    nonRepeating.remove(in);
                    repeating.add(in);

                }else {
                    nonRepeating.add(in);
                }
            }

            return nonRepeating.get(0);
        }
        return 'N';
    }

    // Remove duplicates from array
    public static int[] removeDuplicate(int [] inputArray) {

        Arrays.sort(inputArray);

        int[] result = new int[inputArray.length];
        int previous = inputArray[0];
        result[0] = previous;

        for(int i = 1; i< inputArray.length; i++) {
            int ch = inputArray[i];

            if(ch != previous) {
                result[i] = ch;
            }
            previous = ch;
        }
        return result;
    }

    // find intersection of two sorted arrays in Java.

    public static int[] intersectionOfArray(int[] inputArray1, int[] inputArray2) {
        int resultLength = inputArray1.length >= inputArray2.length ? inputArray2.length : inputArray1.length;
        int[] result = new int[resultLength];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < inputArray1.length && j < inputArray2.length) {
            if(inputArray1[i] > inputArray2[j]) {
                j++;
            }else if(inputArray1[i] < inputArray2[j]) {
                i++;
            }else {
                System.out.println(inputArray2[j]);
                //result[k] = inputArray2[j];
                i++;
                j++;
                //k++;
            }
        }
        return result;
    }

    // Find the element that appears once in an array where every other element appears twice.
    public static int findSingle(int[] input) {
        int result = input[0];

        for(int i = 1; i < input.length; i++) {
            result = result ^ input[i];
        }

        return result;
    }


    // Find Kth smallest number from array

    public  static int kthSmallestElement(int [] input, int k) {
        Arrays.sort(input);
        return input[k-1];
    }


    // Find kth largest elements in an array
    public  static int kthLargestElement(Integer [] input, int k) {
        Arrays.sort(input, Collections.reverseOrder());
        return input[k - 1];
    }

    // FIND COMMON ELEMENT IN THREE SORTED ARRAYS
    private static void findCommon(int[] input1, int[] input2, int[] input3) {
        int i = 0, j = 0, k = 0;
        while(i < input1.length && j < input2.length && k < input3.length) {
            if(input1[i] == input2[j] && input2[j] == input3[k]) {
                System.out.println(input1[i] + " ");
                i++;j++;k++;
            } else if(input1[i] < input2[j]) {
                i++;
            } else if (input2[j] < input3[k]) {
                j++;
            } else {
                k++;
            }
        }
    }


    // find first repeating element in int array
    private static int findFirstRepeating(int [] inputArray) {
        int min  = -1;
        Set<Integer> set = new HashSet<>();
        for(int i = inputArray.length -1; i>=0; i--) {
            if(set.contains(inputArray[i])){
                min = i;
            }else {
                set.add(inputArray[i]);
            }
        }


        if(min != -1) {
            return inputArray[min];
        } else {
            return -1;
        }
    }

    // find first non repeating element in int array
    private static int findFirstNonRepeating(int [] inputArray) {
        Set<Integer> repeating = new HashSet<>();
        List<Integer> nonRepeating = new ArrayList<>();

        for(int in: inputArray) {
            if(nonRepeating.contains(in)){
                nonRepeating.remove(Integer.valueOf(in));
                repeating.add(in);
            }else {
                nonRepeating.add(in);
            }
        }
        return nonRepeating.get(0);
    }

// Find top two max number in Array in one pass
    private static void findTopTwoMax(int[] inputArray) {
        int top1 = inputArray[0];
        int top2 = Integer.MAX_VALUE;
        for(int in: inputArray) {
            if(in > top1) {
                top2 = top1;
                top1 = in;
            }
        }

        System.out.println("top1 =" + top1);
        System.out.println("top2 =" + top2);


        // second solution
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int number : inputArray) {
            if (number > max1) {
                max2 = max1;
                max1 = number;
            }
        }
        System.out.println("Max1 =" + max1);
        System.out.println("Max2 =" + max2);

    }

    // find smallest value that can not be represented as sum of subset of given sorted array.
    private static int findSmallestSum(int [] inputArray){

        int res = 1;
        for(int i = 0; i < inputArray.length && inputArray[i] <= res; i++) {
            res = res + inputArray[i];
        }

        return res;
    }

    // A Java program to find if there is a zero sum subArray
    public static boolean subArraySumZeroExists(int [] inputArray) {
        Map<Integer, Integer> hm = new HashMap<>();

        int sum = 0;

        for(int i = 0; i < inputArray.length; i++) {
            sum = sum + inputArray[i];
            if(inputArray[i] == 0 || sum == 0 || hm.get(sum) != null) {
                return true;
            }
            hm.put(sum, i);
        }

        return false;
    }


    private static int getLargestContigiousSum(String input){
        return 0;
    }
}

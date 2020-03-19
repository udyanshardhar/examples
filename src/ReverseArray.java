public class ReverseArray {
    public static void main(String[] args) {
        int[] reverse = new ReverseArray().reverse(new int[]{1, 2, 3, 4, 5});
        System.out.println(reverse);
        System.out.println(new ReverseArray().reverse(new int[]{1}));
        System.out.println(new ReverseArray().reverse(new int[]{}));
    }

    private int[] reverse(int[] nums) {

        for(int index = 0; index < nums.length/2; index++){
            int temp = nums[index];
            nums[index] = nums[nums.length-index-1];
            nums[nums.length-index-1] = temp;
        }

        return nums;
    }

    private char[] reverseCharArray(char[] s) {

        for(int index = 0; index < s.length/2; index++){
            char temp = s[index];
            s[index] = s[s.length-index-1];
            s[s.length-index-1] = temp;
        }

        return s;
    }
}

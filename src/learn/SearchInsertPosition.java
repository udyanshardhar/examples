package learn;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int [] array = new int []{1, 3, 5, 6};
        int numberToFind = 7;
        System.out.println(new SearchInsertPosition().search(array, numberToFind));
    }

    private int search(int[] nums, int target) {
        for (int position = 0; position < nums.length; position++){
            if(nums[position] == target || nums[position] > target){
                return position;
            }
        }
        return nums.length;
    }
}

public class ContainDuplicateWithinRangeK {
    // TODO why not accepting
    public static void main(String[] args) {
        System.out.println(new ContainDuplicateWithinRangeK().findDuplicate(new int[]{99,99}, 1));
        System.out.println(new ContainDuplicateWithinRangeK().findDuplicate(new int[]{1,2,3,1}, 3));
        System.out.println(new ContainDuplicateWithinRangeK().findDuplicate(new int[]{1,0,1,1}, 1));
        System.out.println(new ContainDuplicateWithinRangeK().findDuplicate(new int[]{1, 2,3, 1,2,3}, 2));
    }

    private boolean findDuplicate(int[] nums, int k) {
        for(int position =0; position <nums.length -k; position++){
            if(nums[position] == nums[position+k]){
                return true;
            }
        }
        return false;
    }
}

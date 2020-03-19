import java.util.HashMap;

public class MejorityElement {
    public static void main(String[] args) {
        System.out.println(new MejorityElement().majorityElement(new int[]{1, 3, 3, 3, 3, 2, 3, 4}));
    }

    private int majorityElement(int[] nums) {
        int length = nums.length;
        if(length == 1)
            return nums[0];
        HashMap<Integer, Integer> elementCount = new HashMap<>();
        for(int element: nums){
            if(elementCount.get(element) != null){
                int temp = elementCount.get(element) +1;
                if(temp > length/2){
                    return element;
                }
                elementCount.put(element, temp);
            }else {
                elementCount.put(element, 1);
            }
        }
        return 0;
    }
}

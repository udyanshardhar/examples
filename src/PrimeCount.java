import java.util.HashMap;
import java.util.HashSet;

public class PrimeCount {
    public static void main(String[] args) {
        System.out.println(new PrimeCount().count(10));
        System.out.println(new PrimeCount().count(100));
    }

    private int count(int n) {
        boolean [] nums = new boolean[n];
        for(int i = 0; i <n; i++){
            nums[i] = true;
        }

        for(int i =2; i * i < n; i++){
            if(nums[i]){
                for(int j =2; j * i < n; j++){
                    nums[i*j]= false;
                }
            }
        }

        int count = 0;

        for(int i =2; i < n; i++){
           if(nums[i]){
               count++;
           }
        }
        return count;
    }
}

public class FirstBadVersion {
    // leetcode 278
    public static void main(String[] args) {
        System.out.println(new FirstBadVersion().findBadVersion(8));
    }

    private int findBadVersion(int n) {
        int min = 1;
        int max = n;

        while(min < max){
            int mid = min + Math.decrementExact((max-min)/2);
            if(isBadVersion(mid)){
                max = mid;
            }else{
                min = mid+1;
            }
        }

        return min;
    }

    private boolean isBadVersion(int mid) {
       if(mid <= 10 && mid >= 6){
           return true;
        }
       return false;
    }
}

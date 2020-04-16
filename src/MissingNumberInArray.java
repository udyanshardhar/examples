public class MissingNumberInArray {
    public static void main(String[] args) {
        System.out.println(new MissingNumberInArray().find(new int[]{1,0, 3, 4}));
    }

    private int find(int[] ints) {
        int n = ints.length;
        int expectedSum = n * (n+1)/2;
        int actualSum = 0;
        for(int i : ints){
            actualSum = actualSum  + i;
        }

        return expectedSum - actualSum;
    }

}

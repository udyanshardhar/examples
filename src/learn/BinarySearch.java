package learn;

public class BinarySearch {

    public static void main(String[] args) {
        int[] input = new int[]{2, 5, 6, 45, 67, 77};
        int right = input.length -1;
        int left = 0;
        int search = new BinarySearch().search(input, left, right, 10);
        System.out.println(search);
    }

    private int search(int[] input, int leftIndex, int rightIndex, int element) {
        if(leftIndex <= rightIndex) {
            int middle =leftIndex + (rightIndex -1)/2;

            if(element == input[middle])
                return middle;

            if(element < input[middle]) {
                search(input, leftIndex, rightIndex-1, element);
            }else {
                search(input, middle+1, input.length-1, element);
            }
        }

        return -1;
    }
}

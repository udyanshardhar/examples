package learn;

public class RemoveElementInPlace {
    public static void main(String[] args) {
        int[] input = new int []{1, 1, 5, 5, 5, 7};
        System.out.println(new RemoveElementInPlace().removeElementInPlace(input, 5));
    }

    private int removeElementInPlace(int[] input , int in) {

        int p1 =0;
        for (int p2 =0; p2< input.length; p2++){
            if(input[p2] != in){
                input[p1] = input[p2];
                p1 =p1+1;
            }
        }
        return p1;
    }
}

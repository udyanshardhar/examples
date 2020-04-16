public class MoveZeroToEnd {
    public static void main(String[] args) {
        int[] move = new MoveZeroToEnd().move(new int[]{0, 0, 5, 0, 4, 6});
        System.out.println(move);
    }

    private int[] move(int[] ints) {
        int explore = 0;
        int anchor = 0;
        while(explore < ints.length){
            if(ints[explore] != 0 && ints[anchor] != 0){
                explore ++;
                anchor ++;
            }else if(ints[explore] != 0 && ints[anchor] == 0){
               int temp = ints[explore];
               ints[explore] = ints[anchor];
               ints[anchor] = temp;
                explore ++;
                anchor ++;
            }else if(ints[explore] == 0){
                explore ++;
            }
        }
        return ints;
    }

}

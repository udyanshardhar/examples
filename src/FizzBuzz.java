public class FizzBuzz {
    // leetcode 412
    public static void main(String[] args) {
        String[] convert = new FizzBuzz().convert(12);
        System.out.println(convert);
    }

    private String[] convert(int n) {

        String[] result = new String[n];

        for(int position =1; position <= n; position++){
            String temp = "";
            if(position % 3 == 0){
                temp = "Fizz";
            }else if(position % 5==0){
                temp = "Buzz";
            }else {
                temp = "" + position;
            }

            if(position % 3 == 0 && position % 5 == 0){
                temp = "FizzBuzz";
            };
            result[position-1] = temp;
        }
        return result;
    }
}

package learn;

public class StringUtil {


    // Java program to output the maximum occurring character
    // in a string. time complexity O(n) and space complexity O(1)

    static final int ASCII_SIZE = 256;

    private static char getMaxOccurrence(String str){
        // Create array to keep the count of individual
        // characters and initialize the array as 0
        int count[] = new int[ASCII_SIZE];

        // Construct character count array from the input
        // string.
        int len = str.length();
        for (int i=0; i<len; i++)
            count[str.charAt(i)]++;

        int max = -1;  // Initialize max count
        char result = ' ';   // Initialize result

        // Traversing through the string and maintaining
        // the count of each character
        for (int i = 0; i < len; i++) {
            if (max < count[str.charAt(i)]) {
                max = count[str.charAt(i)];
                result = str.charAt(i);
            }
        }

        return result;
    }

    // Reverse a string using recursive method.
    private static String reverse(String input, String result){
        if(input.length() == 1){
            result = result.concat(input);
            return result;
        }
       return result.concat(input.substring(input.length()-1)) + reverse(input.substring(0, input.length()-1), result);
    }

    public static void main(String[] args) {
        /* char result = StringUtil.getMaxOccurrence("Hello_Udyan_How_Are_You");
            System.out.println("result : "+result);
        */
        System.out.println("reverse of udyan is "+ reverse("udyan", ""));
    }

}

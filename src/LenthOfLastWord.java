public class LenthOfLastWord {
    // leetCode 58
    public static void main(String[] args) {
        String input = "hello udy an";
        System.out.println(new LenthOfLastWord().count(input));
    }

    private int count(String s) {

        if(s.isEmpty())
            return 0;
        String[] split = s.trim().split(" ");
        String result = split[split.length-1];
        return result.trim().length();
    }
}

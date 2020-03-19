public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring1("dvdf"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring1("abcabcbb"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring1("bbbbbbbb"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring1("bwf"));
    }

    private int lengthOfLongestSubstring(String s) {

        int result = 0;
        if(s == null || s.length() == 0)
            return 0;

        int pointer1 = 0;

        while (pointer1 < s.length()){
            int pointer2 = pointer1+1;
            String tempStr= s.substring(pointer1, pointer2);
            while(pointer2 < s.length()  && tempStr.indexOf(s.charAt(pointer2)) == -1 ) {
                tempStr = tempStr + s.charAt(pointer2);
                pointer2++;
            }
            if(tempStr.length() >= result){
                result = tempStr.length();
            }
            pointer1++;
        }

        return result;
    }

    private int lengthOfLongestSubstring1(String s) {

        int result = 1;
        if(s == null || s.length() == 0)
            return 0;

        int pointer1 = 0;
        int pointer2 = 1;

        String tempStr= s.substring(pointer1, pointer2);
        while (pointer2 < s.length()){
            if(tempStr.indexOf(s.charAt(pointer2)) != -1){
                pointer1++;
                pointer2 = pointer1+1;
                tempStr= s.substring(pointer1, pointer2);
            }else {
                tempStr = tempStr + s.charAt(pointer2);
                pointer2++;
            }
            if(result < tempStr.length()){
                result = tempStr.length();
            }

        }

        return result;
    }

    private int lengthOfLongestSubstring2(String s) {

        int result = 1;
        if(s == null || s.length() == 0)
            return 0;

        int pointer1 = 0;
        int pointer2 = 1;

        String tempStr= s.substring(pointer1, pointer2);
        while (pointer2 < s.length()){
            if(tempStr.indexOf(s.charAt(pointer2)) != -1){
                pointer1 = pointer2;
                pointer2 = pointer1+1;
                tempStr= s.substring(pointer1, pointer2);
                if(result > (s.length() - pointer2)) {
                    return result;
                }
            }else {
                tempStr = tempStr + s.charAt(pointer2);
                pointer2++;
            }

            if(result < tempStr.length()){
                result = tempStr.length();
            }

        }

        return result;
    }
}

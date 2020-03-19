public class ValidPalindrome {
    public static void main(String[] args) {
        //System.out.println(new ValidPalindrome().isPalindrome("dsfsdf"));
        //System.out.println(new ValidPalindrome().isPalindrome("abcba"));
       //  System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new ValidPalindrome().isPalindrome("Aa"));
        System.out.println(new ValidPalindrome().isPalindrome(""));
    }

    private boolean isPalindrome(String s) {
        if(s == null)
            return false;
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        if(s.length() == 0)
            return true;
        s = s.toLowerCase();
        int startIndex = 0;
        int lastIndex = s.length()-1;
        while (startIndex <= lastIndex){
            if(s.charAt(startIndex) != s.charAt(lastIndex))
                return false;
            startIndex++;
            lastIndex--;
        }
        return true;
    }
}

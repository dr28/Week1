package week1.challenges;
/*
Challenge 4 - Palindrome detection
A palindrome is a word, phrase, or sequence of characters that reads the same backward as forward, e.g., madam or nurses run.

Write a program which takes a String as input and returns a boolean value which is true if the input is a palindrome and false if it is not, considering only alphanumeric characters and ignoring case.

Example:

"A man, a plan, a canal: Panama" is a palindrome and should return true
"race a car" is not a palindrome and should return false */
public class Challenge4 {

    // My Solution
    public boolean isPalindrome(String a) {
        int len = a.length();
        int i = 0;
        int j = len - 1;

        while (i < j) {

            while (i < j && !Character.isLetterOrDigit(a.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(a.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(a.charAt(i)) != Character.toLowerCase(a.charAt(j))) {
                return false;
            }

            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args){
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new Challenge4().isPalindrome(s));
        System.out.println(new Challenge4().isPalindrome1(s));
    }

    // Solution provided
    public int isPalindrome1(String A) {

        StringBuffer strBuf = new StringBuffer();

        for (int i = 0; i < A.length(); i++) {
            if ((A.charAt(i) >= 'a' && A.charAt(i) <= 'z') || (A.charAt(i) >= 'A' && A.charAt(i) <= 'Z') || (A.charAt(i) >= '0' && A.charAt(i) <= '9'))
                strBuf.append(Character.toLowerCase(A.charAt(i)));
        }

        String str = strBuf.toString();
        int n = str.length();

        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1))
                return 0;
        }

        return 1;

    }
}

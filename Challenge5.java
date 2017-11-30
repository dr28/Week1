package week1.challenges;
/*
Write a program which takes a String as input and returns a String which is the longest palindromic substring in the input, given the following assumptions about the input string:

its maximum length is 1000
it contains one unique, longest palindromic substring
Examples:

"abdbabbdba" should return "abdba"
"abdbbbbdba" should return "abdbbbbdba"*/

public class Challenge5 {

    // My Solution
    public String longestPalindrome(String a) {
        int n = a.length();
        if(n <= 1)
            return a;
        int start = 0;
        int maxLen = 0;
        int leftIndex;
        int rightIndex;

        int k = 1;

        for(int index = 1; index < n; index++){
            leftIndex = index-1;
            rightIndex = index+1;

            while(rightIndex < n && a.charAt(rightIndex) == a.charAt(index))
                rightIndex++;

            while(leftIndex >= 0 && a.charAt(leftIndex) == a.charAt(index))
                leftIndex--;


            while(leftIndex >= 0 && rightIndex < n && a.charAt(leftIndex) == a.charAt(rightIndex)){
                leftIndex--;
                rightIndex++;

            }

            if(rightIndex - leftIndex - 1 > maxLen){
                maxLen = rightIndex - leftIndex - 1;
                start = leftIndex + 1;

            }
        }
        if(maxLen == 1)
            return a.substring(0, 1);
        return a.substring(start, start + maxLen);
    }

    public static void main(String[] args){
        String a = "abdbabbdba";
              // a = "abdbbbbdba";
        System.out.print(new Challenge5().longestPalindrome(a));
    }

    // Solution provided
    public String longestPalindrome1(String A) {

        int n;
        boolean [][] dp;
        int i;
        int k = 1;
        n = A.length();

        dp = new boolean[n][n];

        for (i = 0; i < n; i++)
            dp[i][i] = true;

        for (int len = 2; len <= n; len++) {

            int j;
            System.out.println("k ------------------------- "+k++);

            for (i = 0; i < n - len + 1; i++) {

                j = i + len - 1;

                if (len == 2) {
                    System.out.println("k if "+k++);

                    if (A.charAt(i) == A.charAt(j)) {
                        dp[i][j] = true;
                    }
                } else {
                    System.out.println("k else "+k++);

                    if (A.charAt(i) == A.charAt(j) && dp[i + 1][j - 1])
                        dp[i][j] = true;
                }

            }

        }

        int start = -1;
        int len = -1;

        for (i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (dp[i][j] && j - i + 1 > len) {
                    len = j - i + 1;
                    start = i;
                }
            }
        }


        return A.substring(start, start + len);
    }
}

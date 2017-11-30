package week1.challenges;
/*
Write a program which takes a String[] as input and returns a String which is the longest common prefix, or an empty string if there is none.

Examples:

{"bceefgh", "bcfghijk", "bcefgh"} should return "bc"
{"abcdefgh", "aefghijk", "abcefgh"} should return "a"
{"", "aefghijk", "abcefgh"} should return ""
*/
public class Challenge6 {
    String longestCommonPrefix (String[] a) {

        StringBuilder result = new StringBuilder();
        Boolean match = true;
        if(a.length == 0 ) return result.toString();
        if(a.length == 1 ) return result.append(a[0]).toString();

        int min = Math.min(a[0].length(), a[1].length());

        for(int i=0; i<min; i++) {

            for (int j=1; j<a.length; j++) {
                if(a[0].charAt(i) != a[j].charAt(i))
                    return result.toString();
            }
            result.append(a[0].charAt(i));
        }
        return result.toString();
    }

    public static void main(String[] args){

        String[] input = {"bceefgh", "bcfghijk", "bcefgh"};
        //String[] input = {"abcdefgh", "aefghijk", "abcefgh"};
        //String[] input = {"", "aefghijk", "abcefgh"};
        //String[] input = {"abcefghk"};

        System.out.println(new Challenge6().longestCommonPrefix(input));

        java.util.ArrayList A = new java.util.ArrayList();
        A.add("bceefgh");
        A.add("bcfghijk");
        A.add("bcefgh");

        //System.out.println(new Challenge6().longestCommonPrefix(A));

    }

    public String longestCommonPrefix(java.util.ArrayList<String> A) {

        if (A.size() == 0)
            return "";

        String str;
        StringBuffer prefix = new StringBuffer();
        int min = Integer.MAX_VALUE;
        int k = 1;

        for (int i = 0; i < A.size(); i++) {
            min = Math.min(min, A.get(i).length());
        }

        for (int i = 0; i < min; i++) {

            char c = A.get(0).charAt(i);

            for (int j = 1; j < A.size(); j++) {
                System.out.println("k "+k++);

                if (c != A.get(j).charAt(i))
                    return prefix.toString();
            }

            prefix.append(c);

        }

        return prefix.toString();

    }

}

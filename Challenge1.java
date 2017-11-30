package week1.challenges;
/*This problem is concerned with deleting repeated elements from a sorted array.

Write a program which takes as input a sorted int[] and updates it such that:

all duplicates have been removed and
all remaining valid elements have been shifted left to fill the emptied indices
all remaining empty indices have values set to 0
the function returns the number of remaining valid elements (the array size minus the number of removed elements)
For example, given an input array with the values {2,3,5,5,7,11,11,11,11,13}, after the function completes, the values in the array should be {2,3,5,7,11,13,0,0,0}, and the function should return 6.

Hint: There is an O(n) time and O(1) space solution.*/

public class Challenge1 {

    // My Solution
    int deleteDuplicates(int[] a) {

        int[] resultarr = new int[a.length-1];
        int result = 0;

        for (int i = 1; i < a.length; i++) {

            if(a[i] != a[i-1]) {
                resultarr[result++] = a[i-1];
                if(i == a.length-1)  resultarr[result++] = a[i];
            }
        }

        for (int i = 0; i < resultarr.length; i++) {

            System.out.print(resultarr[i] + " ");
        }
        System.out.println("");

        return result;

    }

    public static void main(String[] args){

        int[] input = {2,3,5,5,7,11,11,11,11,13};
        System.out.println(new Challenge1().deleteDuplicates(input));
    }

    // Solution during week session
    int removeDuplicates(int[] a) {   //[1, 2, 2, 5]

        java.util.HashSet<Integer> numbers = new java.util.HashSet<>();
        int counter = 0;

        for(int i = 0; i<a.length; i++) {
            if (numbers.contains(a[i])) {
                continue;
            }

            numbers.add(a[i]);
            a[counter++] = a[i];
        }

        int numOfUniques = counter;

        for(int i = counter; i<a.length; i++) {
            a[i] = 0;
        }

        for(int i = 0; i<a.length; i++)
            System.out.println(a[i]);

        return numOfUniques;
    }

    // Solution provided
    public int removeDuplicates(java.util.ArrayList<Integer> A) {
        int index = 1;
        int n = A.size();

        if (A == null || A.size() == 0)
            return 0;

        for (int i = 1; i < n; i++) {

            if (A.get(i).intValue() != A.get(i - 1).intValue()) {
                int temp = A.get(index);
                A.set(index, A.get(i));
                index++;
            }
        }

        return index;

    }
}

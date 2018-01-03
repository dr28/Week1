package week1.intq;
/*Alice is a kindergarten teacher. She wants to give some candies to the children in her class.  All the children sit in a line (their
positions are fixed), and each  of them has a rating score according to his or her performance in the class.  Alice wants to give at least 1
candy to each child. If two children sit next to each other, then the one with the higher rating must get more candies. Alice wants to save
money, so she needs to minimize the total number of candies given to the children.

Input Format

The first line of the input is an integer , the number of children in Alice's class. Each of the following  lines contains an integer that
indicates the rating of each child.

Constraints
1<= N <= 10 raise 5
1<= ratings<= 10 raise 5

Output Format

Output a single line containing the minimum number of candies Alice must buy.

Sample Input 0

3 -> 1 2 2
Sample Output 0

4
Explanation 0

Here 1, 2, 2 is the rating. Note that when two children have equal rating, they are allowed to have different number of candies. Hence optimal
distribution will be 1, 2, 1.

Sample Input 1

10 -> 2 4 2 6 1 7 8 9 2 1
Sample Output 1

19
Explanation 1

Optimal distribution will be 1,2,1,2,1,2,3,4,2,1*/
public class Candies {

    static java.lang.Long candies(int n, int[] arr) {

        int[] cand = new int[n];

        for(int i = 0; i < n; i++) { //min for all
            cand[i] = 1;
        }


        for(int i = 1; i < n; i++) {
            if(arr[i] > arr[i-1]) { // right is greater than left
                cand[i] = cand[i-1]+1; // left no + 1
            }
        }



        for(int i = n-2; i >= 0; i--) {
            if(arr[i] > arr[i+1]) { // left is greater than right
                cand[i] = Math.max(cand[i], cand[i+1]+1); // max
            }

        }

        java.lang.Long count = 0L;
        for(int i = 0; i < n; i++)
        {
            count = count + cand[i];
        }

        return count;
    }

    public static void main(String[] args) {

        //int [] input = {2, 4, 2, 6, 1, 7, 8, 9, 2, 1};
        int[] input = {1, 2, 2};
        java.lang.Long result = candies(input.length, input);
        System.out.println(result);
    }
}

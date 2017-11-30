package week1.challenges;
import java.util.ArrayList;
import java.util.List;

/*
A matrix is a two-dimensional array of r rows, each with c columns, such that the total number of elements in the matrix is r * c.

The spiral order of such a matrix is the list of all its elements starting at index (0, 0) and proceeding in clockwise order from the outermost values to innermost values.

Write a program that takes an int[][] matrix as its input and returns an int[] of all the input's values in spiral order.

Example: Given the following matrix:

int[][] matrix = {
  { 1, 2, 3 },
  { 4, 5, 6 },
  { 7, 8, 9 }
};
Your program should return {1,2,3,6,9,8,7,4,5}*/
public class Challenge3 {

    // My Solution
    int[] spiralOrder(int[][] matrix) {

        int r = matrix.length;
        int c = matrix[0].length;

        int[] result = new int[(r*c)];
        int cur = 0;

        int top = 0;
        int down = r-1;
        int left = 0;
        int right = c-1;
        int direction = 0; //0 - left to right, 1 - top to bottom, 2 - right ti left and 3 - bottom to top

        while(top <= down && left <= right) {


            if (direction == 0) {
                for (int i = left; i <= right; i++)
                    result[cur++] = matrix[top][i];

                direction++;
                top++;

            } else if (direction == 1) {

                for (int i = top; i <= down; i++)
                    result[cur++] = matrix[i][right];

                direction++;
                right--;

            } else if (direction == 2) {

                for (int i = right; i >= left; i--)
                    result[cur++] = matrix[down][i];

                direction++;
                down--;

            } else if (direction == 3) {

                for (int i = down; i >= top; i--)
                    result[cur++] = matrix[i][left];

                direction = 0;
                left++;

            }
        }
        return result;
    }

    public static void main(String[] args){
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int [] result = new Challenge3().spiralOrder(matrix);
        for (int i =0; i<result.length; i++) {
            System.out.print(result[i]); System.out.print(" ");

        }
    }

    // Solution provided
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // Populate result;
        int m, n;

        m = A.size();
        n = A.get(0).size();

        if (m == 0)
            return result;

        int len;
        int dir = 0; // right
        int row, col, layer;
        row = col = layer = 0;

        result.add(A.get(0).get(0));


        for (int step = 1; step < m * n; step++) {

            switch(dir) {

                // Go right
                case 0:

                    if (col == n - layer - 1) {
                        dir = 1;
                        row++;
                    } else {
                        col++;
                    }

                    break;

                // Go down
                case 1:

                    if (row == m - layer - 1) {
                        dir = 2;
                        col--;
                    } else {
                        row++;
                    }

                    break;

                // Go left
                case 2:

                    if (col == layer) {
                        dir = 3;
                        row--;
                    } else {
                        col--;
                    }

                    break;

                // Go up
                case 3:

                    if (row == layer + 1) {
                        dir = 0;
                        col++;
                        layer++;
                    } else {
                        row--;
                    }

                    break;

            }

            //System.out.println(row + " " + col);
            result.add(A.get(row).get(col));

        }
        return result;
    }
}

package week1.intq;

import java.math.BigInteger;

public class GoldStars {

    public int getMinimumNumberOfStars(int[] ratings, boolean bonusObjective) {
        if (ratings == null || ratings.length == 0) return 0;

        int[] stars = new int[ratings.length];

        // from left to right
        for (int i = 0; i < ratings.length; i++) {
            // if the child's rating is higher than the preceding neighbor's
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                // assign the child's star count to one more than preceding neighbor's
                stars[i] = stars[i - 1] + 1;
            } else {
                // otherwise assign 1
                stars[i] = 1;
            }
        }

        int result = 0;

        // from right to left
        for (int i = ratings.length - 1; i >= 0; i--) {
            int neighbor = i == ratings.length - 1 ? i - 1 : i + 1;
            int cur = stars[i];
            // if the child's rating is higher than the following neighbor's
            if (ratings[i] > ratings[neighbor]) {
                // temp. assign the child's star count to one more than the following neighbor's
                cur = stars[neighbor] + 1;
            } else if (bonusObjective) {
                if (ratings[i] == ratings[neighbor] && stars[i] < stars[neighbor]) {
                    // if the neighbor's rating is the same but star count is different
                    cur = stars[neighbor];
                }
            }

            // increment the result by the greater of the two
            result += Math.max(cur, stars[i]);
            // update the child's star count
            stars[i] = cur;
        }

        //System.out.println(java.util.Arrays.toString(ratings) + " >> " + java.util.Arrays.toString(stars) + " == " + result);
        return result;
    }

    public static void main(String[] args){

        //int[] d = {2, 2, 2};
        //int[] d = {2, 4, 2,6,1,7,8,9,2,1};
        int[] d = new int[100000];
        for(int i = 1; i <100001; i++ ) {
            d[i-1] = i;
            if(i==(100000)) {
                System.out.println("----- "+i);

                //System.out.println("d["+i+"] "+d[i]);
            }


        }




        //System.out.println(new GoldStars().getMinimumNumberOfStars(d, false));
        //System.out.println(new GoldStars().getMinNumberOfStars(d, false));
       // System.out.println(new GoldStars().getMinStars(d, true));
        System.out.println(new GoldStars().getMinStarsRatings(d));

    }

    java.lang.Long getMinStarsRatings(int[] ratings){
        int size = ratings.length;
        int[] cand = new int[ratings.length];

        // give all children candies equal to 1
        // local minimas will get 1
        for(int i = 0; i < size; i++)
        {
            cand[i] = 1;
        }


        // increase count on the right of local minimas
        // transient nodes (S) R(S+1) > R(S) get updated
        for(int i = 1; i < size; i++)
        {
            if(ratings[i] > ratings[i-1])
            {
                cand[i] = cand[i-1]+1;
            }
        }


        // increase count on the left of local minimas
        // transient nodes (S) R(S) > R(S+1) gets updated
        // local maximas should be max of left and right
        for(int i = size-2; i >= 0; i--)
        {
            if(ratings[i] > ratings[i+1])
            {
                cand[i] = Math.max(cand[i], cand[i+1]+1);
            }

        }

        // get the sum
        java.lang.Long count = 0L;
        for(int i = 0; i < size; i++)
        {
            count = count + cand[i];
        }
        System.out.println("count "+count);

        return count;
    }

    int getMinStarsRatings2(int[] ratings){
        int[] dp = new int[ratings.length];

        for(int i=1; i < ratings.length; i++){
            //scanf("%d", ra+i);

            if( ratings[i] > ratings[i-1] )
                dp[i] = dp[i-1] + 1;
            else if( dp[i-1] == 1 ){
                dp[i] = 1;
                for( int j=i-1; j>0; j-- )
                    if( ratings[j] > ratings[j+1] )
                        dp[j] = Math.max ( dp[j+1] + 1, dp[j] );
                    else
                        break;
            }
            else
                dp[i] = 1;
        }
        java.lang.Long sum = 0L;
        for(int i = 1;i < ratings.length; i++) sum+= dp[i];
        //printf("%lld\n",sum);
        System.out.println("---"+sum);

        return sum.intValue();
    }


    public int getMinStars(int[] ratings, boolean bonusObjective) {
        int[] stars = new int[ratings.length];

        int result = 0;
        boolean match = false;
        boolean equalsRating = true;

        for (int i = 0; i < ratings.length; i++) {

            int j = i == 0 ? ratings.length - 1 : i - 1;
            int k = i == ratings.length - 1 ? 0 : i + 1;
           // System.out.println("ratings["+i+"] "+ ratings[i]);
           // System.out.println("ratings["+j+"] "+ ratings[j]);
            //System.out.println("ratings["+k+"] "+ ratings[k]);

            //System.out.println("java.util.Arrays.toString(stars) "+java.util.Arrays.toString(stars) );
            stars[i] = 1;
            result++;

            if ((j != ratings.length - 1) && (ratings[i] > ratings[j])) {
                stars[i] = stars[i] + 1;
                result++;
                match = true;

            }

            /*if (!match && bonusObjective && (j != ratings.length - 1) && (ratings[i] == ratings[j])) {
                stars[i] = stars[i] + 1;
                result++;
                match = true;
            }*/


            if (!match && (k != 0) && (ratings[i] > ratings[k])) {
                //System.out.println("ratings["+k+"] k== "+ ratings[k]);


                stars[i] = stars[i] + 1;
                result++;
                match = true;

                // System.out.println(java.util.Arrays.toString(stars) );
            }

            /*if (!match && bonusObjective && (k != 0) && (ratings[i] == ratings[k])) {
                stars[i] = stars[i] + 1;
                result++;
                match = true;
            }*/

            if(bonusObjective) {

                if(equalsRating) {
                    int[] starstemp = new int[ratings.length];

                    for (int k1 = 0; k1 < ratings.length; k1++) {
                        int k2 = k1 + 1;
                        if((k1 != ratings.length-1) && ratings[k1] != ratings[k2]) {
                            equalsRating = false;
                            break;
                        }
                        else {
                            starstemp[k1] = 1;
                        }
                    }

                    if (equalsRating) {
                        stars = starstemp;
                        result = ratings.length;
                        System.out.println(java.util.Arrays.toString(ratings) + " >> " + java.util.Arrays.toString(stars) + " == " + result);

                        return result;

                    }

                }

                if(!equalsRating) {

                    if (!match && (j != ratings.length - 1) && (ratings[i] == ratings[j])) {
                        stars[i] = stars[i] + 1;
                        result++;
                        match = true;
                    }

                    if (!match && bonusObjective && (k != 0) && (ratings[i] == ratings[k])) {
                        stars[i] = stars[i] + 1;
                        result++;
                        match = true;
                    }
                }

            }

            match = false;


        }
        //System.out.println("toString "+ java.util.Arrays.toString(stars) );
        return result;
    }


    public int getMinNumberOfStars(int[] ratings, boolean bonusObjective) {
        int[] stars = new int[ratings.length];

    int result = 0;
    boolean match = false;
        for (int i = 0; i < ratings.length; i++) {

            int j = i == 0 ? ratings.length - 1 : i - 1;
            int k = i == ratings.length - 1 ? 0 : i + 1;
            System.out.println("ratings["+i+"] "+ ratings[i]);
            System.out.println("ratings["+j+"] "+ ratings[j]);
            System.out.println("ratings["+k+"] "+ ratings[k]);

            System.out.println(java.util.Arrays.toString(stars) );

            if (ratings[i] > ratings[j]) {
                System.out.println("ratings["+j+"]00 "+ ratings[j]);

                stars[i] = stars[j] + 1;
                result = result+1;
                match = true;
                System.out.println(java.util.Arrays.toString(stars) );

            } /*else {
                stars[i] = 1;
                result = result+1;

            }*/

            if (ratings[i] > ratings[k]) {
                System.out.println("ratings["+k+"] k== "+ ratings[k]);

                stars[i] = stars[k] + 1;
                result = result+1;
                match = true;
               // System.out.println(java.util.Arrays.toString(stars) );

            } /*else {
                stars[i] = 1;
                result = result+1;

            }*/
            if(!match) {
                stars[i] = 1;
                result = result+1;

            }

            match = false;


        }
        System.out.println(java.util.Arrays.toString(stars) );
return result;
    }

}

package Controller;

public class DynamicController {

    //Method for Factorial
    public long factorial (int n){

        //In case n is a 0 or 1
        if (n == 0 || n == 1) {
            return 1;
        }

        long[] t = new long[n + 1];
               t[0] = 1;
               t[1] = 1;

        for (int i = 2; i <= n; i++) {
            t[i] = t[i - 1] * i;
        }

        return t[n];

    }

    //Method for Fibonnaci
    public long fibonacci (int n){

    }

    //Method for Coin change
    public static int coinChange(int [] coins , int sum){

        //In case n is 0
        if(sum==0) return 0;

        //We initialize an array
        int n = coins.length;
        int t [] = new int[sum+1];

        //Using the for to loop through each amount to the target
        for(int i = 0; i < n ;i++){

            for(int j =coins[i]; j<=sum ; j++){

                t[j]+= t[j - coins[i]];

            }

        }

        return t[sum];
    }
}

package org.example.dp;

import java.util.Arrays;

import static java.lang.System.out;

public class MaxProfit {
    public  int maxProfitRec(int[] current, int[] future, int budget, int i, int[][] dp) {
        if(i==current.length) return 0;
        int profit=maxProfitRec(current, future, budget, i+1, dp);
        if( budget-current[i]>=0) {
            profit = Math.max(profit, future[i] - current[i] + maxProfitRec(current, future, budget - current[i], i + 1, dp));
        }
        return profit;
    }
    public  int maxProfitDp(int[] current, int[] future, int budget, int i, int[][] dp) {
        if(i==current.length) return 0;
        if(dp[i][budget]!=-1) return dp[i][budget];
        dp[i][budget]=maxProfitRec(current, future, budget, i+1, dp);
        if( budget-current[i]>=0) {
            dp[i][budget] = Math.max(dp[i][budget], future[i] - current[i] + maxProfitRec(current, future, budget - current[i], i + 1, dp));
        }
        return dp[i][budget];
    }

    public  int maxProfitDpBottomUp(int[] current, int[] future, int budget) {
        int[][] dp=new int[current.length+1][budget+1];

        for(int i=current.length-1;i>=0;i--){
            for(int j=0;j<=budget;j++){
                dp[i][j]=dp[i+1][j];
                if( j-current[i]>=0) {
                    dp[i][j] = Math.max(dp[i][j], future[i] - current[i] + dp[i+1][j - current[i]]);
                }
                out.print(dp[i][j]);
            }
            out.println("\n");
        }
        Arrays.stream(dp).forEach(a-> {
            Arrays.stream(a).forEach(value -> out.print(" "+value));
            out.println("\n");
        });
        return dp[0][budget];
    }

    public  int maxProfitDpBottomUpOpt(int[] current, int[] future, int budget) {
        int[] dp=new int[budget+1];

        for(int i=0;i< current.length;i++){
            for(int j=budget;j>=current[i];j--){
                dp[j]=Math.max(dp[j],future[i]-current[i]+dp[j-current[i]]);
            }
            Arrays.stream(dp).forEach( value -> out.print(" "+value));
            out.println("\n");
        }
        Arrays.stream(dp).forEach( value -> out.print(" "+value));
        out.println("\n");
        return dp[budget];
    }
}

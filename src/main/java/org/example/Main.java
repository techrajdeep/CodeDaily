package org.example;

import org.example.oa.FeatureCompletion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.System.*;

public class Main {
    public static class Feature{
        public int devTime;
        public int intTime;
        public Feature(int devTime, int intTime){
            this.devTime = devTime;
            this.intTime = intTime;
        }
    }

    public static void main(String[] args) {
//        int[] current={2, 4, 3};
//        int[] future={5, 6, 7};
//        int budget=7;
//        int[][] dp= new int[current.length+1][budget+1];
//        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
//        int profit=maxProfitRec(current,future,budget,0,dp);
//        int profit=maxProfitDp(current,future,budget,0,dp);
//        int profit=maxProfitDpBottomUp(current,future,budget);
//  i=0,c=2,f=5 ; b=7 dp[7]= max(dp[7],3+dp[7-2])=max(0,3+0)=3; b=6 dp[6]=3,dp[5]=3,..till b>=2
//  i=1,c=4,f=6 ; dp[7]=max(dp[7],2+dp[7-4])=max(3,5)=5 , dp[6]=max(3,)
//  i=2 ,c=3, f=7 ;dp[7]=max(dp[7],4+dp[4]) =max(5,7) =7
//        int profit=maxProfitDpBottomUpOpt(current,future,budget);

//        int[] devTime={3,4,5,9};
//        int[] intTime={3,2,5,5};
        int[] devTime={1,5,7,2};
        int[] intTime={1,1,3,3};
        FeatureCompletion featureCompletion = new FeatureCompletion();
        int result = featureCompletion.findMinFeatureCompletionTime(devTime,intTime);
        out.println("min time : "+result);
    }



    private static int maxProfitRec(int[] current, int[] future, int budget, int i, int[][] dp) {
        if(i==current.length) return 0;
       int profit=maxProfitRec(current, future, budget, i+1, dp);
       if( budget-current[i]>=0) {
           profit = Math.max(profit, future[i] - current[i] + maxProfitRec(current, future, budget - current[i], i + 1, dp));
       }
       return profit;
    }
    private static int maxProfitDp(int[] current, int[] future, int budget, int i, int[][] dp) {
        if(i==current.length) return 0;
        if(dp[i][budget]!=-1) return dp[i][budget];
        dp[i][budget]=maxProfitRec(current, future, budget, i+1, dp);
        if( budget-current[i]>=0) {
            dp[i][budget] = Math.max(dp[i][budget], future[i] - current[i] + maxProfitRec(current, future, budget - current[i], i + 1, dp));
        }
        return dp[i][budget];
    }

    private static int maxProfitDpBottomUp(int[] current, int[] future, int budget) {
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

    private static int maxProfitDpBottomUpOpt(int[] current, int[] future, int budget) {
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
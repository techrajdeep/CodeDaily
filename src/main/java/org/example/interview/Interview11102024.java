package org.example.interview;

public class Interview11102024 {

     /* Question1
        Given an array of integers nums and an integer k. A continuous subarray is called Super if there are k odd numbers on it.
Return the number of Super sub-arrays.
Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

         */


      /*  Question2
      Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
                Example 1:

        Input: n = 3
        Output: ["((()))","(()())","(())()","()(())","()()()"]

        n =1 ["()"] 1
        n=2 ["()()","(())"] 2 (11 ,2)
        n=3 ["((()))","(()())","(())()","()(())","()()()"] 5(3,21,12,111)

        n=4 []

        */

        /* Question3
        Given a string expression representing an expression of fraction addition and subtraction,
        return the calculation result in string format.

The final result should be an irreducible fraction. If your final result is an integer,
change it to the format of a fraction that has a denominator 1. So in this case, 2 should be converted to 2/1.

Example 1:

Input: expression = "-1/2+1/2"
Output: "0/1"
         */

    //Question3
    public void findValueFromExpression() {
        String str = "-1/2+1/5";
        char firstOp = '*';
        char secondOp = '*';
        int firstOpIndex = -1;
        int secondOpIndex = -1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                if (firstOp == '*') {
                    firstOp = str.charAt(i);
                    firstOpIndex = i;
                } else if (secondOp == '*') {
                    secondOp = str.charAt(i);
                    secondOpIndex = i;
                }
            }
        }
        String firstExp = str.substring(firstOpIndex + 1, secondOpIndex);
        String secondExp = str.substring(secondOpIndex + 1);

        String[] num1 = firstExp.split("/");
        System.out.println(num1[0] + ":" + num1[1]);
        float one = (float) Integer.parseInt(num1[0]) / Integer.parseInt(num1[1]);

        String[] num2 = secondExp.split("/");
        System.out.println(num2[0] + ":" + num2[1]);
        float two = (float) Integer.parseInt(num2[0]) / Integer.parseInt(num2[1]);

        if (firstOp == '-') {
            one = -one;
        }
        if (secondOp == '-') {
            two = -two;
        }
        float value = one + two;
        int intValue = (int) value;
        if (value == (float) intValue)
            System.out.println("Answer :" + intValue + "/1");
        else
            System.out.println("Answer : " + value);
    }

    //Question1
    private int findNumberOfSubarrays(int[] arr, int k) {

        int n = arr.length;
        int res = 0;
        for (int i = 0; i < n - k; i++) {
            int count = 0;
            for (int j = i; j < n; j++) {
                if (arr[j] % 2 == 1) {
                    count++;
                }
                if (count == k) {
                    res++;
                    for (int p = i; p <= j; p++) {
                        System.out.print(arr[p]);
                    }
                    System.out.println("");
                }
                if (count > k) break;
            }
        }
        return res;
    }
}

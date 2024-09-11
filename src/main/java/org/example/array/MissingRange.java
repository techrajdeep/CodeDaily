//Leetcode-163
//https://medium.com/@rebeccahezhang/leetcode-163-missing-ranges-6ac21b477e96
package org.example.array;

import java.util.ArrayList;
import java.util.List;

public class MissingRange {
    public static String[] findMissingRange(int[] nums,int lower, int upper){
        List<String> list =new ArrayList<>();
        int prev=lower;
        for(int i=0;i<nums.length;i++ ){
            if(prev!=nums[i]){
                if(prev==nums[i]-1){
                    list.add(""+prev);
                }
                else {
                    list.add(prev+"->"+(nums[i]-1));
                }
                prev=nums[i]+1;
            }
        }
        if(nums[nums.length-1]!=upper){
            if(upper==nums[nums.length-1]+1){
                list.add(""+upper);
            }
            else {
                list.add((nums[nums.length-1]+1)+"->"+upper);
            }
        }
        return list.toArray(new String[0]);
    }
}

package org.example.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ReverseArray {

    public static int []  reverseArray(int [] arr){
        int size =arr.length;
        IntStream.range(0,size/2).forEach(index -> {
            int temp=arr[index];
            arr[index]=arr[size-index-1];
            arr[size-index-1]=temp;
        });
        return arr;
    }
    public static Integer[] reverseArrayUsingCollection(Integer arr[]){
        List<Integer> list= Arrays.asList(arr);
        Collections.reverse(list);
        System.out.println(list);
       return list.toArray(new Integer[]{});

    }
}

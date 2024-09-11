package org.example.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertElement {
    public static Integer[] insertElement(Integer[] intArray, int element, int position) {
        List<Integer> list= new ArrayList<>(Arrays.asList(intArray));
        list.add(position-1,element);
        return list.toArray(new Integer[0]);

        //T-O(n) ,S-O(N)
    }
}

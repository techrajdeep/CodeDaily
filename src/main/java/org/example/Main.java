package org.example;

import org.example.oa.FeatureCompletion;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {

//        int[] devTime={3,4,5,9};
//        int[] intTime={3,2,5,5};
        int[] devTime={1,5,7,2};
        int[] intTime={1,1,3,3};
        FeatureCompletion featureCompletion = new FeatureCompletion();
        int result = featureCompletion.findMinFeatureCompletionTime(devTime,intTime);
        out.println("min time : "+result);
    }
}
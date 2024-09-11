package org.example.oa;

import org.example.Main;

import java.util.ArrayList;
import java.util.List;

public class FeatureCompletion {
    /*
    The minimal development time needed to implement all the features.What’s given in the problemThere are n
    features to implementThe estimated hours needed to develop the ith feature from scratch is developmentTime[i].
     The estimated hours needed to integrate the ith feature from the library is integrationTime[i] .
     The integration of features using an existing library is performed only by the team lead,
     while the development of features can be distributed among team membersThere are more than n team members.
     1. int[] devTime={3,4,5,9}; int[] intTime={3,2,5,5}; Answer : 5
     2. int[] devTime={1,5,7,2}; int[] intTime={1,1,3,3}; Answer : 4
     */
    public int findMinFeatureCompletionTime(int[] devTime, int[] intTime) {
        int maxDevTime = 0;
        int maxIntTime = 0;
        List<Main.Feature> features = new ArrayList<>();
        for (int i = 0; i < devTime.length; i++)
            features.add(new Main.Feature(devTime[i],intTime[i]));
        features.sort((f1, f2) -> Integer.compare(f2.devTime, f1.devTime));
        for (Main.Feature feature : features) {
            if(Math.max(maxDevTime,feature.devTime) <= maxIntTime+feature.intTime)
                maxDevTime=Math.max(maxDevTime,feature.devTime);
            else
                maxIntTime=maxIntTime+feature.intTime;
        }
        return Math.max(maxDevTime,maxIntTime);
    }
}

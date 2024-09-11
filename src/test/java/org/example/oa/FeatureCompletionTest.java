package org.example.oa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FeatureCompletionTest {
    static Stream<Arguments> provideArraysAndIntForTesting() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(new int[]{3,4,5,9}, new int[]{3,2,5,5}, 5),
                org.junit.jupiter.params.provider.Arguments.of(new int[]{1,5,7,2}, new int[]{1,1,3,3}, 4)
        );
    }
    @ParameterizedTest
    @MethodSource("provideArraysAndIntForTesting")
    void findMinFeatureCompletionTime(int[] devTime, int[] intTime, int expected) {
        FeatureCompletion featureCompletion = new FeatureCompletion();
        int minFeatureCompletionTime = featureCompletion.findMinFeatureCompletionTime(devTime, intTime);
        Assertions.assertEquals(expected, minFeatureCompletionTime);
    }
}
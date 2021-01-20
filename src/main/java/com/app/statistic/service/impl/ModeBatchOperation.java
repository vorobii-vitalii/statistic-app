package com.app.statistic.service.impl;

import com.app.statistic.service.BatchOperation;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ModeBatchOperation implements BatchOperation<Double, Double> {

    @Override
    public Double perform(Collection<Double> numbers) {

        if (numbers == null || numbers.size() == 0 ) {
            throw new IllegalArgumentException();
        }

        final Map<Double, Integer> occurrenceMap = new HashMap<>();

        for (Double value : numbers) {
            occurrenceMap.put(value, occurrenceMap.getOrDefault(value, 0) + 1);
        }

        return findMostFrequentKey(occurrenceMap);
    }

    private static Double findMostFrequentKey(Map<Double, Integer> occurrenceMap) {
        int currentHighestFrequency = 0;
        Double mostFrequent = null;

        for (Map.Entry<Double, Integer> entry : occurrenceMap.entrySet() ) {
            final double value = entry.getKey();
            final int frequency = entry.getValue();

            if (frequency > currentHighestFrequency) {
                mostFrequent = value;
                currentHighestFrequency = frequency;
            }
        }

        return mostFrequent;
    }

}

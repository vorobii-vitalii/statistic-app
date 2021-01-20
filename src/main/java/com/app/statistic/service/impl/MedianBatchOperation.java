package com.app.statistic.service.impl;

import com.app.statistic.service.BatchOperation;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MedianBatchOperation implements BatchOperation<Double, Double> {

    @Override
    public Double perform(Collection<Double> numbers) {

        if (numbers == null || numbers.size() == 0 ) {
            throw new IllegalArgumentException();
        }

        final List<Double> sortedNumbers = new ArrayList<>(numbers);

        Collections.sort(sortedNumbers);

        return findMedian(sortedNumbers);
    }

    private static Double findMedian(List<Double> sortedValues) {
        final int N = sortedValues.size();

        // If the length of list is odd, than median is at the middle of the list
        if (N % 2 == 1) {
            return sortedValues.get(N / 2);
        }

        // Otherwise, median is the average of central values
        return (sortedValues.get(N / 2 - 1) + sortedValues.get(N / 2)) / 2;
    }

}

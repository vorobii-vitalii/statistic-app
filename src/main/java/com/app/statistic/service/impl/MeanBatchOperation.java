package com.app.statistic.service.impl;

import com.app.statistic.service.BatchOperation;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MeanBatchOperation implements BatchOperation<Double, Double> {

    @Override
    public Double perform(Collection<Double> numbers) {

        if (numbers == null || numbers.size() == 0 ) {
            throw new IllegalArgumentException();
        }

        double sum = 0;
        for (Double number : numbers) {
            sum += number;
        }
        return sum / numbers.size();
    }

}

package com.app.statistic.service.impl;

import com.app.statistic.exceptions.OperationNotSupportedException;
import com.app.statistic.service.BatchOperation;
import com.app.statistic.service.BatchOperationFactory;
import com.app.statistic.service.Operation;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BatchOperationFactoryImpl implements BatchOperationFactory<Double, Double> {
    private final String type;

    public BatchOperationFactoryImpl(String type) {
        this.type = type;
    }

    @Override
    public Operation<Collection<Double>, Double> create() {
        switch (type) {
            case BatchOperation.MEAN:
                return new MeanBatchOperation();

            case BatchOperation.MEDIAN:
                return new MedianBatchOperation();

            case BatchOperation.MODE:
                return new ModeBatchOperation();

            default:
                throw new OperationNotSupportedException(type);
        }
    }

}

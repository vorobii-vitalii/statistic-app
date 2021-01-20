package com.app.statistic.service;

public interface OperationFactory<T, U> {
    Operation<T, U> create();
}

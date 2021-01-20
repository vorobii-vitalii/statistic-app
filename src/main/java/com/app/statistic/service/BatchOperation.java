package com.app.statistic.service;

import java.util.Collection;

public interface BatchOperation<T, U> extends Operation<Collection<T>, U> {
    String MEAN = "mean";
    String MEDIAN = "median";
    String MODE = "mode";
}

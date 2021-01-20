package com.app.statistic.service;

public interface Operation<T, U> {
    U perform(T t);
}

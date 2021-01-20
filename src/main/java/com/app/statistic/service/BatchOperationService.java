package com.app.statistic.service;

import org.springframework.web.multipart.MultipartFile;

public interface BatchOperationService<T> {
    T calculateFromFile(MultipartFile file, String operation);
}

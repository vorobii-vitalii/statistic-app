package com.app.statistic.service.impl;

import com.app.statistic.exceptions.FileProcessingException;
import com.app.statistic.service.BatchOperationFactory;
import com.app.statistic.service.BatchOperationService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class BatchOperationServiceImpl implements BatchOperationService<Double> {
    private static final String DELIMITER = ",";

    @Override
    public Double calculateFromFile(MultipartFile file, String operation) {
        final BatchOperationFactory<Double, Double> factory = new BatchOperationFactoryImpl(operation);
        final Collection<Double> numbers = fetchNumbersFromFile(file);

        return factory.create().perform(numbers);
    }

    private static Collection<Double> fetchNumbersFromFile(MultipartFile multipartFile) {
        final Collection<Double> fetchedNumbers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()))) {

            reader.lines().forEach(line -> {
                for (String numStr : line.split(DELIMITER)) {
                    final double parsedDouble = Double.parseDouble(numStr);
                    fetchedNumbers.add(parsedDouble);
                }
            });

            return fetchedNumbers;
        }
        catch (IOException | NumberFormatException e) {
            throw new FileProcessingException();
        }
    }

}

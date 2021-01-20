package com.app.statistic.controller;

import com.app.statistic.service.BatchOperationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping
@AllArgsConstructor
public class FileUploadController {
    private final BatchOperationService<Double> batchOperationService;

    @PostMapping("/{operation}")
    public ResponseEntity<Double> processRequest(
            @PathVariable("operation") String operation,
            @RequestParam("file") MultipartFile file
    ) {
        final Double computationResult = batchOperationService.calculateFromFile(file, operation);

        return new ResponseEntity<>(computationResult, HttpStatus.OK);
    }

}

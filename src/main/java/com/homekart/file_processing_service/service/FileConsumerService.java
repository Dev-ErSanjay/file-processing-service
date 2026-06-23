package com.homekart.file_processing_service.service;

import java.util.concurrent.ExecutorService;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileConsumerService {

    private final FileProcessingQueue queue;
    private final ExecutorService executorService;
    private final FileJobService fileJobService;

    @PostConstruct
    public void startConsumer() {

        System.out.println("Consumer started... ");
        new Thread(() -> {
            while (true) {
                try {
                    String jobId = queue.getJob();
                    Thread.sleep(5000);
                    executorService.submit(() -> fileJobService.processFile(jobId));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}

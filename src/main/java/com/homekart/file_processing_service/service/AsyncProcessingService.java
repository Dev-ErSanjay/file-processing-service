package com.homekart.file_processing_service.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncProcessingService {

    @Async
    public CompletableFuture<String> sendNotification(String jobId) {

        try {
            System.out.println("Notification stated for " + jobId + " by " + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("Notification completed for " + jobId + " by " + Thread.currentThread().getName());

            return CompletableFuture.completedFuture("Notification sent");
        } catch (Exception e) {
            return CompletableFuture.failedFuture(e);
        }
    }

}

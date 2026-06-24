package com.homekart.file_processing_service.service;

import java.util.concurrent.Semaphore;

import org.springframework.stereotype.Service;

@Service
public class SemaphoreService {

    private final Semaphore semaphore = new Semaphore(2);

    public void access3(String jobId) {

        try {
            semaphore.acquire();
            System.out.println("S3 ACCESS GRANTED -> " + jobId);
            System.out.println("Available permits : " + semaphore.availablePermits());
            Thread.sleep(10000);
            System.out.println("S3 ACCESS COMPLETED -> " + jobId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            System.out.println("Permit Released -> " + jobId);
            System.out.println("Available Permits: " + semaphore.availablePermits());
        }
    }

}

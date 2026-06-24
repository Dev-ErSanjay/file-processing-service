package com.homekart.file_processing_service.service;

import org.springframework.stereotype.Service;

@Service
public class VolatileDemoService {

    private volatile boolean running = true;

    public void startProcessing() {
        Thread worker = new Thread(() -> {
            System.out.println("Worker started ... ");
            while (running) {

            }
            System.out.println("Worker stopped ... ");
        });

        worker.start();
    }

    public void stopProcessing() {
        running = false;
        System.out.println("Stop signal sent");
    }

}

package com.homekart.file_processing_service.service;

import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Service;

@Service
public class ChunkProcessingService {

    public void processChunks(String jobId) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(5);
        System.out.println("Waiting for all chunks...");

        for (int i = 1; i <= 5; i++) {
            int chunkNo = i;

            new Thread(() -> {
                try {
                    System.out.println("Chunk " + chunkNo + " started");
                    Thread.sleep(3000);
                    System.out.println("Chunk " + chunkNo + " completed");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                    System.out.println("Remaining chunks: " + latch.getCount());
                }
            }).start();
        }
        latch.await();

        System.out.println("All chunks completed for Job: " + jobId);
    }

}

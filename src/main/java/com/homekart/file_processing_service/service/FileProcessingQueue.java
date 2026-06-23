package com.homekart.file_processing_service.service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.stereotype.Component;

@Component
public class FileProcessingQueue {

    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public void addJob(String jobId) throws InterruptedException {

        queue.put(jobId);

        System.out.println("Added job to Queue: " + jobId);
        System.out.println("Queue size: " + queue.size());
    }

    public String getJob() throws InterruptedException {

        String jobId = queue.take();
        System.out.println("Consumer picked Job: " + jobId);
        System.out.println("Queue size after consume: " + queue.size());

        return jobId;
    }

    public int size() {
        return queue.size();
    }

}

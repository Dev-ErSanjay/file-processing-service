package com.homekart.file_processing_service.service;

import java.util.concurrent.locks.ReentrantLock;

import org.springframework.stereotype.Service;

@Service
public class ReportService {

    private final ReentrantLock lock = new ReentrantLock();

    public void generateReport(String jobId) {

        lock.lock();

        try {
            System.out.println("REPORT STARTED by "
                    + Thread.currentThread().getName()
                    + " for Job "
                    + jobId);
            Thread.sleep(5000);
            System.out.println("REPORT COMPLETED by "
                    + Thread.currentThread().getName()
                    + " for Job "
                    + jobId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

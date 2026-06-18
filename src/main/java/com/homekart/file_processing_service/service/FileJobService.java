package com.homekart.file_processing_service.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.homekart.file_processing_service.model.FileJob;
import com.homekart.file_processing_service.repository.FileJobRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileJobService {

    private final S3Service s3Service;
    private final FileJobRepository fileJobRepository;

    public String uploadFile(MultipartFile file) throws IOException {

        String jobId = UUID.randomUUID().toString();

        String s3Key = s3Service.uploadFile(file);

        FileJob fileJob = FileJob.builder()
                .jobId(jobId)
                .fileName(file.getOriginalFilename())
                .s3Key(s3Key)
                .status("PENDING")
                .createdTime(LocalDateTime.now())
                .build();

        fileJobRepository.save(fileJob);

        return "FileJob saved to DynamoDB with Job ID: " + jobId;

    }

    public FileJob getFileJob(String jobId) {

        return fileJobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job Not Found"));
    }

}

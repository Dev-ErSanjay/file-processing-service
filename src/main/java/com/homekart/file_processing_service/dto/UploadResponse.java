package com.homekart.file_processing_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UploadResponse {

    private String jobId;
    private String status;
}

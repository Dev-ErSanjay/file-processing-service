package com.homekart.file_processing_service.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamoDbBean
public class FileJob {

    private String jobId;
    private String fileName;
    private String s3Key;
    private String status;
    private LocalDateTime createdTime;
    private LocalDateTime processedTime;

    @DynamoDbPartitionKey
    public String getJobId() {
        return jobId;
    }

}

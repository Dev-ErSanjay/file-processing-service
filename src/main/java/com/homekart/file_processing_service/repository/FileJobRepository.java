package com.homekart.file_processing_service.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.homekart.file_processing_service.model.FileJob;

import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
@RequiredArgsConstructor
public class FileJobRepository {

    private final DynamoDbEnhancedClient dynamoDbEnhancedClient;

    private static final String TABLE_NAME = "file_jobs";

    public DynamoDbTable<FileJob> getTable() {

        return dynamoDbEnhancedClient.table(
                TABLE_NAME, TableSchema.fromBean(FileJob.class));
    }

    public void save(FileJob fileJob) {

        getTable().putItem(fileJob);
    }

    public Optional<FileJob> findById(String jobId) {

        FileJob fileJob = getTable().getItem(Key.builder().partitionValue(jobId).build());

        return Optional.ofNullable(fileJob);
    }

    public void update(FileJob fileJob) {

        getTable().putItem(fileJob);
    }

}

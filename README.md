# Smart File Processing System

## Project Overview

The Smart File Processing System is a Spring Boot application designed to process uploaded files asynchronously using Java Multithreading and Concurrency concepts while integrating with AWS services.

The goal of this project is not only to upload and process files but also to gain hands-on experience with real-world concurrency patterns such as thread pools, producer-consumer architecture, asynchronous processing, synchronization, locks, concurrent collections, and thread coordination mechanisms.

---

## Problem Statement

In many real-world applications, file processing operations such as metadata extraction, virus scanning, thumbnail generation, report creation, and notification delivery can take significant time.

Processing these operations synchronously causes:

* Slow API response times
* Poor scalability
* Resource bottlenecks
* Bad user experience

This project solves these problems by processing files asynchronously using worker threads and concurrency mechanisms.

---

## Architecture

```text
User Uploads File
        |
        v
Store File in AWS S3
        |
        v
Create Job Record in DynamoDB
(Status = PENDING)
        |
        v
Add Job to Processing Queue
        |
        v
Worker Threads Consume Jobs
        |
        +--> Metadata Extraction
        +--> Virus Scan
        +--> Thumbnail Generation
        |
        v
Update Job Status
(COMPLETED)
        |
        v
Send SNS Notification
```

---

## AWS Services Used

### Amazon S3

Used for:

* Storing uploaded files
* Storing generated thumbnails
* Storing generated reports

### DynamoDB

Used for:

* Job tracking
* Processing status management
* File metadata storage

Possible statuses:

* PENDING
* PROCESSING
* COMPLETED
* FAILED

### SNS

Used for:

* Email notifications
* Processing completion alerts

### CloudWatch (Optional)

Used for:

* Monitoring
* Metrics collection
* Application observability

---

## Major Functionalities

### File Upload

Users can upload files through a REST API.

Example:

```http
POST /files/upload
```

---

### Job Creation

For every uploaded file:

* Unique Job ID is generated
* Status is set to PENDING
* Job information is stored in DynamoDB

---

### Queue-Based Processing

Uploaded jobs are added to a processing queue.

Worker threads continuously consume jobs from the queue and process them independently.

---

### Parallel Processing

Each file undergoes multiple processing tasks:

#### Metadata Extraction

Extract:

* File Name
* File Size
* File Extension
* Upload Timestamp

#### Virus Scan

Perform virus scan simulation.

#### Thumbnail Generation

Generate image preview/thumbnail.

All these tasks execute concurrently using CompletableFuture.

---

### Job Status Tracking

The system tracks every processing stage.

Examples:

```text
PENDING
PROCESSING
COMPLETED
FAILED
```

---

### Notification Service

After successful processing:

* SNS notification is triggered
* User receives processing completion notification

---

## Concurrency Concepts Implemented

### Thread

Basic thread creation using Runnable and Thread.

### ExecutorService

Thread pool management for worker execution.

### Thread Pool

Efficient resource utilization through reusable threads.

### Producer-Consumer Pattern

Producer:

* Upload API

Consumer:

* Worker Threads

### BlockingQueue

Thread-safe queue implementation for job processing.

### CompletableFuture

Execute independent processing tasks in parallel.

### @Async

Spring asynchronous execution support.

### AtomicInteger

Thread-safe counters.

### synchronized

Protect shared resources from race conditions.

### ReentrantLock

Advanced locking mechanism.

### ConcurrentHashMap

Thread-safe in-memory storage.

### CountDownLatch

Wait for multiple tasks to complete.

### CyclicBarrier

Synchronize multiple worker threads.

### Semaphore

Limit concurrent access to shared resources such as S3.

### Deadlock Simulation

Understand and prevent deadlocks using lock ordering and tryLock.

### Scheduled Tasks

Periodic cleanup and report generation.

---

## Sample APIs

### Upload File

```http
POST /files/upload
```

### Get All Jobs

```http
GET /jobs
```

### Get Job By ID

```http
GET /jobs/{jobId}
```

### Get Reports

```http
GET /reports
```

### Get Metrics

```http
GET /metrics
```

---

## Learning Objectives

By completing this project, you will gain practical experience in:

### Spring Boot

* REST APIs
* Configuration
* Dependency Injection
* Exception Handling

### AWS

* S3
* DynamoDB
* SNS
* CloudWatch

### Java Concurrency

* Threads
* ExecutorService
* Thread Pools
* Producer Consumer Pattern
* CompletableFuture
* Atomic Operations
* Synchronization
* Locks
* Concurrent Collections
* Thread Coordination
* Deadlock Prevention

### System Design

* Asynchronous Processing
* Queue-Based Architecture
* Scalable Backend Design
* Resource Management

---

## Expected Outcome

A production-style backend application capable of handling multiple file-processing jobs concurrently while demonstrating almost all major Java multithreading and concurrency concepts along with AWS cloud integrations.

---

## Tech Stack

### Backend

* Java 21 (or Java 17)
* Spring Boot

### AWS

* Amazon S3
* DynamoDB
* SNS
* CloudWatch

### Build Tool

* Maven

### Database

* DynamoDB

### Concurrency

* ExecutorService
* CompletableFuture
* BlockingQueue
* AtomicInteger
* ReentrantLock
* ConcurrentHashMap
* CountDownLatch
* CyclicBarrier
* Semaphore

---

## Resume Description

Developed a Smart File Processing System using Spring Boot, AWS S3, DynamoDB, and SNS, implementing asynchronous file processing through thread pools, producer-consumer architecture, CompletableFuture, synchronization mechanisms, and advanced Java concurrency concepts to efficiently process and track large volumes of file-processing jobs.

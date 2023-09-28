package org.startsharp.utils;

import software.amazon.awssdk.auth.credentials.*;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;




public class awsConnection {
/*
    private static AwsCredentialsProvider getSessionCredentials() {
        return StaticCredentialsProvider.create(
                AwsBasicCredentials.create("AKIAXA5GPF4BPUAM5CP3", "2r79FASz+uVBPO6FfvVckr80NWVy4HHcUFSWBUpe")
        );
    }

 */

    private static AwsBasicCredentials getSessionCredentials() {
        return AwsBasicCredentials.create("AKIAXA5GPF4BPUAM5CP3", "2r79FASz+uVBPO6FfvVckr80NWVy4HHcUFSWBUpe");
    }

    public static S3Client getS3Client() {
        return S3Client.builder()
                .region(Region.US_EAST_2)
                .credentialsProvider(StaticCredentialsProvider.create(getSessionCredentials()))
                .build();
    }

    public static DynamoDbClient getDynamoClient() {
        return DynamoDbClient.builder()
                .region(Region.US_EAST_2)
                .credentialsProvider(StaticCredentialsProvider.create(getSessionCredentials()))
                .build();
    }

}



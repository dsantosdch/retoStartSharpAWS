package org.startsharp.utils.s3;

import org.startsharp.utils.awsConnection;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListObjectsRequest;
import software.amazon.awssdk.services.s3.model.ListObjectsResponse;
import software.amazon.awssdk.services.s3.model.S3Object;

import java.util.ArrayList;
import java.util.List;

public class listObject {

    public static List<String> listBucketObjects() {

        String bucketName = "retorest";

        S3Client s3Client = awsConnection.getS3Client();

        List<String> objectKeys = new ArrayList<>();

        ListObjectsResponse listObjectsResponse = s3Client.listObjects(ListObjectsRequest.builder()
                .bucket(bucketName)
                .build());

        for (S3Object s3Object : listObjectsResponse.contents()) {
            objectKeys.add(s3Object.key());
        }

        return objectKeys;
    }
}



package org.startsharp.utils.s3;

import org.startsharp.models.Meeting;
import org.startsharp.utils.awsConnection;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


public class jsonContent {

    private static final String BUCKET_NAME = "retorest";
    private static final String FILE_KEY = "singleMeeting.json";

    public static Meeting getJsonContent() {

        S3Client s3Client = awsConnection.getS3Client();

        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(BUCKET_NAME)
                .key(FILE_KEY)
                .build();

        ResponseBytes<GetObjectResponse> responseBytes = s3Client.getObjectAsBytes(getObjectRequest);
        SdkBytes objectBytes = SdkBytes.fromByteArray(responseBytes.asByteArray());

        String jsonContent = objectBytes.asUtf8String();

        System.out.println(jsonContent);

        ObjectMapper objectMapper = new ObjectMapper();

        Meeting meeting = null;
        try {
            meeting = objectMapper.readValue(jsonContent, Meeting.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return meeting;
    }

}



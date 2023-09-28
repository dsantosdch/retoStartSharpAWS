package org.startsharp.utils.s3;


import org.startsharp.utils.awsConnection;
import software.amazon.awssdk.core.exception.SdkException;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;



public class findObject {

        public static void CheckObject() {

            S3Client s3Client = awsConnection.getS3Client();

            // Nombre del bucket y ruta al objeto
            String bucketName = "retorest";
            String objectKey = "singleMeeting.json";

            try {
                // Intenta obtener información sobre el objeto
                HeadObjectRequest request = HeadObjectRequest.builder()
                        .bucket(bucketName)
                        .key(objectKey)
                        .build();

                HeadObjectResponse response = s3Client.headObject(request);

                // Si llegamos aquí, el objeto existe
                System.out.println("El objeto existe.");
            } catch (SdkException e) {
                // Si se lanza una excepción, el objeto no existe
                System.out.println("El objeto no existe.");
            }
        }
    }




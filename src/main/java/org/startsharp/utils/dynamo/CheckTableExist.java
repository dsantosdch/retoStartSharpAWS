package org.startsharp.utils.dynamo;

import org.startsharp.utils.awsConnection;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.DescribeTableRequest;
import software.amazon.awssdk.services.dynamodb.model.ResourceNotFoundException;

public class CheckTableExist {

    public static boolean doesTableExist(String tableName) {

        DynamoDbClient ddb = awsConnection.getDynamoClient();

        try {
            DescribeTableRequest describeTableRequest = DescribeTableRequest.builder()
                    .tableName(tableName)
                    .build();
            ddb.describeTable(describeTableRequest);
            return true;
        } catch (ResourceNotFoundException e) {
            return false;
        }
    }

}

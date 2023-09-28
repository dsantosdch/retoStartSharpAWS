package org.startsharp.utils.dynamo;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.Map;

import static org.startsharp.utils.dynamo.GetItem.getDynamoDBItem;

public class TableContentDynamo {

    public String nombre_reunion;
    public String numero_reunion;

    public static TableContentDynamo tableContent() {

        String tableName = "retorest";
        String key = "nombre_reunion";
        String keyVal = "reunion_dynamodb";

        Map<String, AttributeValue> item = getDynamoDBItem(tableName, key, keyVal);

        TableContentDynamo content = new TableContentDynamo();

        content.nombre_reunion = item.get("nombre_reunion").s();
        content.numero_reunion = item.get("numero_reunion").n();

        return content;
    }
}

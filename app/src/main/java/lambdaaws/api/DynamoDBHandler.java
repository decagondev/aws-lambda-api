package lambdaaws.api;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.HashMap;
import java.util.Map;

public class DynamoDBHandler implements RequestHandler<Request, Response> {

    private final DynamoDbClient dynamoDbClient = DynamoDbClient.builder().build();

    @Override
    public Response handleRequest(Request request, Context context) {
        switch (request.getOperation()) {
            case CREATE:
                return createItem(request);
            case READ:
                return readItem(request);
            case UPDATE:
                return updateItem(request);
            case DELETE:
                return deleteItem(request);
            default:
                throw new IllegalArgumentException("Invalid operation: " + request.getOperation());
        }
    }

    private Response createItem(Request request) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("id", AttributeValue.builder().s(request.getId()).build());
        item.put("name", AttributeValue.builder().s(request.getName()).build());
        item.put("username", AttributeValue.builder().s(request.getUsername()).build());
        item.put("characters", AttributeValue.builder().ss(request.getCharacters()).build());

        dynamoDbClient.putItem(PutItemRequest.builder()
                .tableName("TestModel")
                .item(item)
                .build());

        return new Response("Item created successfully");
    }

    private Response readItem(Request request) {
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("id", AttributeValue.builder().s(request.getId()).build());

        GetItemResponse response = dynamoDbClient.getItem(GetItemRequest.builder()
                .tableName("TestModel")
                .key(key)
                .build());

        Map<String, AttributeValue> item = response.item();

        if (item != null) {
            return new Response(item.get("id").s(), item.get("name").s(), item.get("username").s(), item.get("characters").ss());
        } else {
            return new Response("Item not found");
        }
    }

    private Response updateItem(Request request) {
        // Implement update logic
        return new Response("Update operation not implemented yet");
    }

    private Response deleteItem(Request request) {
        // Implement delete logic
        return new Response("Delete operation not implemented yet");
    }
}


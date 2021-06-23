package com.entgra.task1.restdeviceapi.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class APIResponse {
    public static JsonNode createErrorResponse(String errorMessage) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode result = mapper.createObjectNode();
        result.put("status", 0);
        result.put("errorMessage", errorMessage);
        return result;
    }
    public static JsonNode createSuccessResponse(Object data) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode result = mapper.createObjectNode();
        result.put("status", 1);
        result.set("data", mapper.valueToTree(data));
        return result;
    }

}

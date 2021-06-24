package com.entgra.task1.restdeviceapi.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import jdk.jfr.Event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        // StdDateFormat is ISO8601 since jackson 2.9
        mapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
        ObjectNode result = mapper.createObjectNode();
        result.put("status", 1);
        result.set("data", mapper.valueToTree(data));
        return result;
    }

}

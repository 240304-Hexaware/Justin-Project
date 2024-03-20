package com.example.justin_fulkerson_project.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JsonUtils {

    public static int parseStartIndex(String json) {
        // Find the start index of the field specification
        int startIndexIndex = json.indexOf("\"startIndex\":") + "\"startIndex\":".length();
        int endIndex = json.indexOf(",", startIndexIndex); // Assuming the start index is followed by a comma

        // Extract the substring containing the start index
        String startIndexString = json.substring(startIndexIndex, endIndex).trim();

        // Parse the substring as an integer
        return Integer.parseInt(startIndexString);
    }

    public static int parseLength(InputStream inputStream) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(inputStream);
        JsonNode lengthNode = rootNode.get("length");
        if (lengthNode != null) {
            return lengthNode.asInt();
        } else {
            throw new IllegalArgumentException("Length not found in JSON spec.");
        }
    }
}

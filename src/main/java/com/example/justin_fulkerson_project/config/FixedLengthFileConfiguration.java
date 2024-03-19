package com.example.justin_fulkerson_project.config;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.data.repository.CrudRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FixedLengthFileConfiguration {

    public static class FixedLengthField {
        private int start; // Start position of the field in the line
        private int length; // Length of the field

        private String fieldName;

        public FixedLengthField(int start, int length) {
            this.start = start;
            this.length = length;
        }

        public FixedLengthField() {}


        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public void setStartPosition(int start) {
            this.start = start;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getStart() {
            return start;
        }

        public int getLength() {
            return length;
        }
// Getters and setters
    }

    private Map<String, FixedLengthField> fields;

    public FixedLengthFileConfiguration(String jsonSpecFilePath) throws IOException {
        this.fields = new HashMap<>();

        String jsonSpec = new String(Files.readAllBytes(Paths.get(jsonSpecFilePath)));

        JSONObject jsonObject = new JSONObject(jsonSpec);
        JSONArray fieldArray = jsonObject.getJSONArray("fields");

        for (int i = 0; i < fieldArray.length(); i++) {
            JSONObject fieldObject = fieldArray.getJSONObject(i);
            String fieldName = fieldObject.getString("name");
            //System.out.println(fieldName);
            int startIndex = fieldObject.getInt("startIndex");
            int length = fieldObject.getInt("length");
            fields.put(fieldName, new FixedLengthField(startIndex, length));
        }

    }

    public Map<String, FixedLengthField> getFields() {
        return fields;
    }

    public void setFields(Map<String, FixedLengthField> fields) {
        this.fields = fields;
    }

}



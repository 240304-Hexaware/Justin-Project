package com.example.justin_fulkerson_project.services;// FileParserService.java
import com.example.justin_fulkerson_project.config.FixedLengthFileConfiguration;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FileParserService {

    public List<Map<String, String>> parseFixedLengthFile(String filePath, Map<String, FixedLengthFileConfiguration.FixedLengthField> fields) throws IOException {
        List<Map<String, String>> parsedData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                parsedData.add(parseLine(line, fields));
            }
        }
        return parsedData;
    }

    private Map<String, String> parseLine(String line, Map<String, FixedLengthFileConfiguration.FixedLengthField> fields) {
        Map<String, String> parsedData = new HashMap<>();
        for (Map.Entry<String, FixedLengthFileConfiguration.FixedLengthField> entry : fields.entrySet()) {
            String fieldName = entry.getKey();
            FixedLengthFileConfiguration.FixedLengthField field = entry.getValue();
            int startIndex = field.getStart();
            int length = field.getLength();

            String fieldValue = line.substring(startIndex, startIndex + length).trim();

            parsedData.put(fieldName, fieldValue);
        }
        return parsedData;
    }

    // Define other methods as needed
}

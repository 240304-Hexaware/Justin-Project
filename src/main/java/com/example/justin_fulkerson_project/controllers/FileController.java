package com.example.justin_fulkerson_project.controllers;

import com.example.justin_fulkerson_project.config.FixedLengthFileConfiguration;
import com.example.justin_fulkerson_project.entities.FileDataEntity;
import com.example.justin_fulkerson_project.respositories.FileDataRepository;
import com.example.justin_fulkerson_project.services.FileParserService;
import com.example.justin_fulkerson_project.services.MetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private FileParserService fileParserService;

    @Autowired
    private FileDataRepository fileDataRepository;

    @Autowired
    private FixedLengthFileConfiguration configuration;

    @Autowired
    private MetadataService metadataService;

    @PostMapping("/metadata")
    public ResponseEntity<String> uploadMetadata(@RequestParam("specFile") MultipartFile specFile) {
        try {
            String jsonSpecFile = new String(specFile.getBytes(), StandardCharsets.UTF_8);
            metadataService.parseAndSaveMetadata(jsonSpecFile);
            return ResponseEntity.ok().body("Metadata uploaded successfully.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading metadata.");
        }
    }

    private void saveParsedData(List<Map<String, String>> parsedData) {
        for (Map<String, String> record : parsedData) {
            FileDataEntity mapDataEntity = new FileDataEntity();
            mapDataEntity.setData(record);
            fileDataRepository.save(mapDataEntity);
        }
    }

    @PostMapping("/parse")
    public List<Map<String, String>> parseFixedLengthFile(@RequestParam("file") MultipartFile file,
                                                          @RequestParam("spec") MultipartFile specFile) throws IOException {
        List<Map<String, String>> parsedData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                parsedData.add(parseLine(line, specFile.getInputStream()));
            }
        }
        saveParsedData(parsedData);
        return parsedData;

    }

    private Map<String, String> parseLine(String line, InputStream inputStream) {
        Map<String, FixedLengthFileConfiguration.FixedLengthField> fields = configuration.getFields();
        if (fields == null) {
            // Handle null fields map appropriately (e.g., throw an exception or log a message)
            throw new IllegalStateException("Fields map is null");
        }

        Map<String, String> parsedData = new HashMap<>();
        for(Map.Entry<String, FixedLengthFileConfiguration.FixedLengthField> entry : fields.entrySet()) {
            String fieldName = entry.getKey();
            FixedLengthFileConfiguration.FixedLengthField field = entry.getValue();
            int startIndex = field.getStart();
            int length = field.getLength();

            if (line.length() >= startIndex + length) {
                String fieldValue = line.substring(startIndex, startIndex + length).trim();
                parsedData.put(fieldName, fieldValue);
            } else {
                // Handle the case where the line does not contain enough characters for the field
                // You can choose to skip this field or handle it differently based on your requirements
                // For example, you can log a warning or set a default value for the field
            }
        }
        return parsedData;
    }

    // Implement other endpoints as needed
}
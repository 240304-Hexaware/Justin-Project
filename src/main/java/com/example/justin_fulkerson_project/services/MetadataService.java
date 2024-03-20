package com.example.justin_fulkerson_project.services;

import com.example.justin_fulkerson_project.entities.FieldMetadata;
import com.example.justin_fulkerson_project.entities.FileMetadataEntity;
import com.example.justin_fulkerson_project.respositories.FileMetadataRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MetadataService {

    @Autowired
    private FileMetadataRepository metadataRepository;

    @Autowired
    private UserService userService;

    public void parseAndSaveMetadata(String jsonSpecFile, String pathName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonSpecFile);
        JsonNode fieldsNode = rootNode.get("fields");


        List<FieldMetadata> fieldMetadataList = new ArrayList<>();

        if (fieldsNode != null && fieldsNode.isArray()) {
            for (JsonNode fieldNode : fieldsNode) {
                String fieldName = fieldNode.get("name").asText();

                JsonNode startNode = fieldNode.get("start");
                int startPosition = (startNode != null && !startNode.isNull()) ? startNode.asInt() : 0;
                System.out.println(startPosition);
                JsonNode lengthNode = fieldNode.get("length");
                int length = (lengthNode != null && !lengthNode.isNull()) ? lengthNode.asInt() : 0;

                FieldMetadata fieldMetadata = new FieldMetadata(fieldName, startPosition, length);
                fieldMetadata.setWhenUploaded(LocalDateTime.now());
                //fieldMetadata.setWhoUploaded();
                fieldMetadata.setPathName(pathName);
                fieldMetadataList.add(fieldMetadata);
            }
        }

        FileMetadataEntity fileMetadataEntity = new FileMetadataEntity(fieldMetadataList);
        metadataRepository.save(fileMetadataEntity);
    }
}


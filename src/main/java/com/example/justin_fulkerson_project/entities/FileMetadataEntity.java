package com.example.justin_fulkerson_project.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "file_metadata")
public class FileMetadataEntity {
        @Id
        private String id;

        private String fieldName;
        private int startPosition;
        private int length;

        // Constructor, getters, and setters

        private ArrayList<FieldMetadata> data = new ArrayList<>();

        public FileMetadataEntity() {
        }

        public FileMetadataEntity(String fieldName, int startPosition, int length) {
            this.fieldName = fieldName;
            this.startPosition = startPosition;
            this.length = length;
        }

    public FileMetadataEntity(List<FieldMetadata> fieldMetadataList) {
            this.data = (ArrayList<FieldMetadata>) fieldMetadataList;
    }

    public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public int getStartPosition() {
            return startPosition;
        }

        public void setStartPosition(int startPosition) {
            this.startPosition = startPosition;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }
}

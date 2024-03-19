package com.example.justin_fulkerson_project.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "files")
public class FileDataEntity {

    @Id
    private String id;

    private String fileName;
    private Object fileContent;

    private Map<String, String> data;

    public Map<String, String> getData() {
        return data;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Object getFileContent() {
        return fileContent;
    }

    public void setFileContent(Object fileContent) {
        this.fileContent = fileContent;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
}

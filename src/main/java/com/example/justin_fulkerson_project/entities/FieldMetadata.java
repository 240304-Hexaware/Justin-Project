package com.example.justin_fulkerson_project.entities;

import java.text.DateFormat;
import java.time.LocalDateTime;

public class FieldMetadata {
    private String name;
    private int startIndex;
    private int length;

    private String pathName;

    private String whoUploaded;

    private LocalDateTime timestamp;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public void setWhoUploaded(String whoUploaded) {
        this.whoUploaded = whoUploaded;
    }

    public void setWhenUploaded(LocalDateTime whenUploaded) {
        this.whenUploaded = whenUploaded;
    }

    public String getName() {
        return name;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getLength() {
        return length;
    }

    public String getPathName() {
        return pathName;
    }

    public String getWhoUploaded() {
        return whoUploaded;
    }

    public LocalDateTime getWhenUploaded() {
        return whenUploaded;
    }

    private LocalDateTime whenUploaded;

    public FieldMetadata(String fieldName, int startPosition, int length) {
        this.name = fieldName;
        this.startIndex = startPosition;
        this.length = length;
        this.whenUploaded = LocalDateTime.now();
    }

    // Constructors, getters, and setters
}

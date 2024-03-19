package com.example.justin_fulkerson_project.entities;

public class FieldMetadata {
    private String name;
    private int startIndex;
    private int length;

    public FieldMetadata(String fieldName, int startPosition, int length) {
        this.name = fieldName;
        this.startIndex = startPosition;
        this.length = length;
    }

    // Constructors, getters, and setters
}

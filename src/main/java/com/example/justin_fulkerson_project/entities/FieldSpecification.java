package com.example.justin_fulkerson_project.entities;

public class FieldSpecification {
    private String fieldName;
    private int startIndex;
    private int length;

    // Constructor, getters, and setters

    public FieldSpecification(String fieldName, int startIndex, int length) {
        this.fieldName = fieldName;
        this.startIndex = startIndex;
        this.length = length;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getName() {
        return fieldName;
    }
}

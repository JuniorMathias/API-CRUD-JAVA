package com.spring.model;



public class EqualFilterModel {

    private String column;
    private String value;
    private Boolean isEqual;

    public EqualFilterModel(String column, String value, Boolean isEqual) {
        this.column = column;
        this.value = value;
        this.isEqual = isEqual;
    }

    public String getColumn() {
        return column;
    }

    public String getValue() {
        return value;
    }

    public Boolean getIsEqual() {
        return isEqual;
    }
}


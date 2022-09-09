package com.dev4tech.group2.littlegeniuses.exception;

import lombok.Getter;

@Getter
public enum ProblemType {

    INVALID_REQUEST_BODY("/invalid-request-body", "Invalid request body"),
    RESOURCE_NOT_FOUND("/resource-not-found", "Resource not found"),
    ENTITY_IN_USE("/entity-in-use", "Entity in use"),
    BUSINESS_ERROR("/business error", "Business rule violation"),
    INVALID_PARAMETER("/Invalid-parameter", "Invalid parameter"),
    SYSTEM_ERROR("/system error", "System error"),
    INVALID_DATA("/invalid data", "Invalid data");

    private String title;
    private String uri;

    ProblemType(String path, String title) {
        this.uri = "https://littlegeniuses.com" + path;
        this.title = title;
    }

}

package com.api.automation.base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseTest {

    protected RequestSpecification requestSpecification;

    protected void setupRequestSpecification() {

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://dummyjson.com")
                .setContentType(ContentType.JSON)
                .build();
    }
}
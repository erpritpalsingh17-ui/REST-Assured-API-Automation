package com.api.automation.api;

import com.api.automation.base.BaseTest;
import com.api.automation.pojo.UserRequest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserApi extends BaseTest {

    public UserApi() {
        setupRequestSpecification();
    }

    // Create User
    public Response createUser(UserRequest userRequest) {

        return RestAssured
                .given(requestSpecification)
                .body(userRequest)
                .post("/users/add");
    }

    // Get User
    public Response getUser(int userId) {

        return RestAssured
                .given(requestSpecification)
                .get("/users/" + userId);
    }

    // Update User - PUT
    public Response updateUser(int userId, UserRequest userRequest) {

        return RestAssured
                .given(requestSpecification)
                .body(userRequest)
                .put("/users/" + userId);
    }

    // Partial Update - PATCH
    public Response patchUser(int userId, UserRequest userRequest) {

        return RestAssured
                .given(requestSpecification)
                .body(userRequest)
                .patch("/users/" + userId);
    }

    // Delete User
    public Response deleteUser(int userId) {

        return RestAssured
                .given(requestSpecification)
                .delete("/users/" + userId);
    }
}
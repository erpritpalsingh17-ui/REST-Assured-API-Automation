package com.api.automation.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.api.automation.api.UserApi;
import com.api.automation.pojo.UserRequest;
import io.restassured.response.Response;

public class UserTest {

    private UserApi userApi;

    @BeforeClass
    public void setup() {
        userApi = new UserApi();
    }

    @Test
    public void createUserTest() {

        UserRequest userRequest = new UserRequest(
                "Pritpal",
                "Singh",
                37
        );

        Response response = userApi.createUser(userRequest);

        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 201);

        Assert.assertEquals(
                response.jsonPath().getString("firstName"),
                "Pritpal"
        );
    }


   @Test
public void getUserTest() {

    given()
    .when()
        .get("https://dummyjson.com/users/1")
    .then()
        .statusCode(200)
        .body("firstName", equalTo("Emily"))
        .log().all();
}

    @Test
    public void updateUserTest() {

        UserRequest userRequest = new UserRequest(
                "Pritpal",
                "Singh",
                38
        );

        Response response = given()
                .contentType("application/json")
                .body(userRequest)
                .when()
                .put("https://dummyjson.com/users/1");

        response.prettyPrint();

        response.then()
                .statusCode(200)
                .body("firstName", equalTo("Pritpal"))
                .log().all();
    }

    @Test
    public void deleteUserTest() {


        Response response = given()
                .when()
                .delete("https://dummyjson.com/users/1");

        response.prettyPrint();

        response.then()
                .statusCode(200)
                .body("isDeleted",equalTo(true))
                .log().all();
    }

    }

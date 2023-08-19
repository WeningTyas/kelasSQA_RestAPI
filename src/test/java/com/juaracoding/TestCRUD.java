package com.juaracoding;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class TestCRUD {

    String baseURL = "https://reqres.in/api/users";

    @Test
    public void testPost() {
        JSONObject request = new JSONObject();
        request.put("name", "John");
        request.put("job", "QA Engineer");
        System.out.println(request.toJSONString());
        given()
            .header("Content-Type", "application/json")
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(request.toJSONString())
            .when()
            .post(baseURL)
            .then()
            .statusCode(201)
            .log().all();
    }

    @Test
    public void testPut() {
        JSONObject request = new JSONObject();
        request.put("name", "John");
        request.put("job", "QA Engineer");
        System.out.println(request.toJSONString());
        given()
            .header("Content-Type", "application/json")
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(request.toJSONString())
            .when()
            .put(baseURL + "/2")
            .then()
            .statusCode(200)
            .log().all();
    }

    @Test
    public void testPatch() {
        JSONObject request = new JSONObject();
        request.put("name", "John");
        request.put("job", "QA Engineer");
        System.out.println(request.toJSONString());
        given()
            .header("Content-Type", "application/json")
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(request.toJSONString())
            .when()
            .patch(baseURL + "/2")
            .then()
            .statusCode(200)
            .log().all();
    }

    @Test
    public void testDelete() {
        when()
            .delete(baseURL + "/2")
            .then()
            .statusCode(204)
            .log().all();
    }

}

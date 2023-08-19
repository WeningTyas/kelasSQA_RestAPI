package com.juaracoding;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestLogin {

    @Test
    public void testApiWithKeyAuth() {
        String baseURL = "https://api.themoviedb.org/3/movie";
        String api_key = "e67d4228c6ba9a094c62a59fd1eed76e";

        given()
            .queryParam("api_key", api_key)
            .when()
            .get(baseURL + "/popular?language=en-US&page=2")
            .then().statusCode(200);
    }
}
/*
* https://www.themoviedb.org/
* email	: weningputri3@gmail.com
* uname	: WeningTyas
* pass 	: sandi1234
*
* Link: https://www.themoviedb.org/settings/api
* */
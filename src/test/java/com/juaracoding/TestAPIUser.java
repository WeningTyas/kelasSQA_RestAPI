package com.juaracoding;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestAPIUser {

    String endpoint = "https://reqres.in/api/users?page=1";

    // Validasi Status Code
    @Test
    public void testStatusCode(){
        Response respon = RestAssured.get(endpoint);
        Assert.assertEquals(respon.getStatusCode(), 200);

        System.out.println(respon.getBody().asString());
        System.out.println(respon.getStatusCode());
        System.out.println(respon.getBody());
    }

    //Validasi menggunakan Given
    @Test
    public void testId(){
        given().get(endpoint) //Response
                .then()       //Validate Response
                .statusCode(200)
                .body("data.id[0]", equalTo(1));
        /*
        * equalTo = Matcher (equalTo)
        *
        * Cara baca kode di atas:
        *    kalau endpoint punya status 200 (sukses)
        *    ambil isi [0] (pertama di index) 'id' di dalam "data"
        *    yang isiya (angka) 1 (satu)
        * Kalau True maka hasilnya "Sukses"
        * */
    }
}


/*Mulai sekarang testing udh gak pakai Main tapi langsung di folder Test*/

/*
* Kalau memang perlu content type, ditambahkan aja di bagian ini
 * [ application/json;charset=utf-8 ]
 * biasanya ini di taruh sebelum body di eksekusi
 *
 * String myToken = "";
 * request.header("Authorization", "Bearer " + myToken)
 * request.header("Content-Type", "application/json");
 *
 * Referensi: Rest Assured hlm 4 akhir
* */

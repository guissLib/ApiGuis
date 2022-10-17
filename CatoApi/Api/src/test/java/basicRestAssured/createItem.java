package basicRestAssured;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class createItem {

    @Test
    public void verifyCreateItemJSONObject(){
        JSONObject body = new JSONObject();
        body.put("Content","GuisITEM");
        Response response=given()

                .auth()
                .preemptive()
                .basic("guis1234@gmail.com", "123")
                .body(body.toString())
                .log().all()
                .when()
                .post("https://todo.ly/api/items.json");



        response.then()
                .log().all()
                .statusCode(200)
                .body("Content",equalTo("GuisITEM"));


    }
}

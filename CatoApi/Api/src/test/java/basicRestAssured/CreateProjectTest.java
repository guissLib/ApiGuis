package basicRestAssured;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
public class CreateProjectTest {

    @Test
    public void verifyCreateProject(){
given()

        .auth()
        .preemptive()
        .basic("guis1234@gmail.com", "123")
        .body("{\n" +
                "\"Content\":\"Guisela\", \n" +
                "\"Icon\":4\n" +
                "}" )
        .log().all()
        .when()
        .post("https://todo.ly/api/projects.json")
        .then()
        .log().all();

    }
    @Test
    public void verifyCreateProjectJSONObject(){
        JSONObject body = new JSONObject();
        body.put("Content", "GuisJSON");
        body.put("Icon",1);

        given()

                .auth()
                .preemptive()
                .basic("guis1234@gmail.com", "123")
                .body(body.toString())

                .log().all()
        .when()
                .post("https://todo.ly/api/projects.json")
        .then()
                .log().all();

    }

    @Test
    public void verifyCreateProjectFile(){
        String jsonFile= new File("").getAbsolutePath()+"/src/test/resources/createProject.json";
        given()

                .auth()
                .preemptive()
                .basic("guis1234@gmail.com", "123")
                .body(new File(jsonFile))

                .log().all()
                .when()
                .post("https://todo.ly/api/projects.json")
                .then()
                .log().all();

    }
}

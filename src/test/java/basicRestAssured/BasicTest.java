package basicRestAssured;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class BasicTest {

    @Test
    public void verify_get_project(){
        given().
                auth().
                preemptive().
                basic("liz@email.com","123456").
                    log().
                    all().
                when().
                        get("https://todo.ly/api/projects.json").
                then().
                    log().
                    all();
    }
    //enfocado en la verificacion
    @Test
    public void createProject(){

        given().
                auth().
                preemptive().
                basic("liz@email.com","123456").
                body("{ " +
                        "  \"Content\":\"RESTAssured\",\n" +
                        "  \"Icon\":\"4\" \n" +
                        "}").
                    log().
                    all().
                when().
                post("https://todo.ly/api/projects.json").

                then().
                statusCode(200).
                body("Content", equalTo("RESTAssured")).
                body("Icon", equalTo(4)).
                log().
                all();

    }
//crear sin necesidad de la notacion / en el body
    @Test
    public void create_project_using_json_object(){
        JSONObject body = new JSONObject();
        body.put("Content","RESTAssured");
        body.put("Icon","4");

        given().
                auth().
                preemptive().
                basic("liz@email.com","123456").
                contentType(ContentType.JSON).
                body(body.toString()).
                log().
                all().

                when().
                post("http://todo.ly/api/projects.json").

                then().
                statusCode(200).
                body("Content", equalTo("RESTAssured")).
                body("Icon", equalTo(4)).
                log().
                all();

    }

    @Test
    public void verify_create_project_using_external_file(){
        given().
                auth().
                preemptive().
                basic("liz@email.com","123456").
                contentType(ContentType.JSON).
                body(new File("E:src\\test\\resources\\createProject.json")).
                log().
                all().
                when().
                post("http://todo.ly/api/projects.json").
                then().
                statusCode(200).
                body("Content", equalTo("EXTERNAL FILE")).
                body("Icon", equalTo(4)).
                log().
                all();


    }


}

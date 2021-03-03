package ejercicio1;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class CRUDItemsTest {
    private Response response;

    @Test
    public void verify_crud_item(){

        JSONObject body = new JSONObject();
        body.put("Content","Item Liz");

        // Creacion

        response =  given().
                auth().
                preemptive().
                basic("liz@email.com","123456").
                contentType(ContentType.JSON).
                body(body.toString()).
                log().
                all().
                when().
                post("https://todo.ly/api/items.json");

        response.then().
                statusCode(200).
                body("Content", equalTo("Item Liz")).
                body("Deleted", equalTo(false)).
                log().
                all();

        // extraer el valor de una propiedad : Id
        int idItem=response.then().extract().path("Id");

        // Actualizacion
        body.put("Checked",true);
        response =  given().
                auth().
                preemptive().
                basic("liz@email.com","123456").
                contentType(ContentType.JSON).
                body(body.toString()).
                log().
                all().
                when().
                put("http://todo.ly/api/items/"+idItem+".json");

        response.then().
                statusCode(200).
                body("Content", equalTo("Item Liz")).
                body("Checked", equalTo(true)).
                body("Deleted", equalTo(false)).
                log().
                all();

        // Get
        response =  given().
                auth().
                preemptive().
                basic("liz@email.com","123456").
                contentType(ContentType.JSON).
                log().
                all().
                when().
                get("http://todo.ly/api/items/"+idItem+".json");

        response.then().
                statusCode(200).
                body("Content", equalTo("Item Liz")).
                body("Deleted", equalTo(false)).
                log().
                all();

        // Borrado
        response =  given().
                auth().
                preemptive().
                basic("liz@email.com","123456").
                contentType(ContentType.JSON).
                log().
                all().
                when().
                delete("http://todo.ly/api/items/"+idItem+".json");

        response.then().
                statusCode(200).
                body("Content", equalTo("Item Liz")).
                body("Deleted", equalTo(true)).
                log().
                all();
    }
}

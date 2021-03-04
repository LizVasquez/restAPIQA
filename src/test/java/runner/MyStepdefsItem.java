package runner;

import compare.CompareJsonSol;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class MyStepdefsItem {

    Response response;
    Map<String, String> data = new HashMap<>();

    @Given("tengo acceso a Todo.ly")
    public void tengoAccesoATodoLy() {
        System.out.println("Acceso al todo.ly");
    }

    @When("envio una peticon POST al url {} con json")
    public void envioUnaPeticonPOSTAlUrlHttpsTodoLyApiItemsJsonConJson(String url, String body) {
        response = given().
                auth().
                preemptive().
                basic("liz@email.com", "123456").
                contentType(ContentType.JSON).
                body(body).
                log().
                all().
                when().
                post(replaceAllData(url));

        response.then().log().all();

    }

    @Then("espero el codigo de respuesta {int}")
    public void esperoElCodigoDeRespuesta(int expectedResult) {
        response.then().
                statusCode(expectedResult);

    }

    @And("espero que el nuevo item sea {string}")
    public void esperoQueElNuevoItem(String expectedNameItem) {
        response.then().
                body("Content", equalTo(expectedNameItem));

    }

    @And("espero que el response body sea")
    public void esperoQueElResponseBodySea(String expectedBody) {
        Assert.assertTrue("Error, los Json no son iguales",CompareJsonSol.areEqualJson(replaceAllData(expectedBody),response.getBody().asString()));
    }

    @And("tengo el {} y lo guardo en {}")
    public void tengoElIdYLoGuardoEnID_ITEM(String property, String nameVar) {
        data.put(nameVar, response.then().extract().path(property) + "");
    }

    @When("envio una peticion PUT al url {} con json")
    public void envioUnaPeticionPUTAlUrlHttpsTodoLyApiItemsID_ITEMJsonConJson(String url, String body) {
        response = given().
                auth().
                preemptive().
                basic("liz@email.com", "123456").
                contentType(ContentType.JSON).
                body(body).
                log().
                all().
                when().
                put(replaceAllData(url));

        response.then().log().all();
    }

    @When("envio una peticion GET al url {} con json")
    public void envioUnaPeticionGETAlUrlHttpsTodoLyApiItemsID_ITEMJsonConJson(String url, String body) {
        response = given().
                auth().
                preemptive().
                basic("liz@email.com", "123456").
                contentType(ContentType.JSON).
                log().
                all().
                when().
                get(replaceAllData(url));

        response.then().log().all();
    }

    @When("envio una peticion DELETE al url {} con json")
    public void envioUnaPeticionDELETEAlUrlHttpsTodoLyApiItemsID_ITEMJsonConJson(String url, String body) {
        response = given().
                auth().
                preemptive().
                basic("liz@email.com", "123456").
                contentType(ContentType.JSON).
                log().
                all().
                when().
                delete(replaceAllData(url));

        response.then().log().all();
    }

    private String replaceAllData(String value) {
        for (String key : data.keySet()
        ) {
            value = value.replace(key, data.get(key));

        }
        return value;

    }

}

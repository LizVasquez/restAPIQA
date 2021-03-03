package runnerItem;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class MyStepdefsItem {
    Response response;
    @Given("tengo acceso a Todo.ly")
    public void tengoAccesoATodoLy() {
        System.out.println("Acceso al todo.ly");
    }

    @When("envio una peticon POST al url {} con json")
    public void envioUnaPeticonPOSTAlUrlHttpsTodoLyApiItemsJsonConJson(String url, String body) {
        response =  given().
                auth().
                preemptive().
                basic("liz@email.com","123456").
                contentType(ContentType.JSON).
                body(body).
                log().
                all().
                when().
                post(url);

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
}

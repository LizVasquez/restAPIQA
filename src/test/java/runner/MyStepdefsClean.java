package runner;

import configuration.Config;
import compare.CompareJsonSol;
import factoryRequest.FactoryRequest;
import factoryRequest.RequestInformation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class MyStepdefsClean {
    Response response;
    RequestInformation request = new RequestInformation();
    Map<String, String> data= new HashMap<>();

    @Given("I have access to Todo.ly")
    public void iHaveAccessToTodoLy() {
        request.setAuthType(Config.AUTH_BASIC);
        request.setAuthValue(Config.AUTH_BASIC_VALUE);
    }

    @When("I send a request {} to url {} with json")
    public void iSendARequestPOSTToUrlHttpTodoLyApiProjectsJsonWithJson(String requestMethod, String url, String body) {
        //request.setAuthType(Config.AUTH_BASIC);
        //request.setAuthValue(Config.AUTH_BASIC_VALUE);
        request.setUrl(replaceAllData(url));
        request.setBody(replaceAllData(body));
        response = FactoryRequest.make(requestMethod).send(request);
    }

    @Then("I expected response code {int}")
    public void iExpectedResponseCode(int expectedResponseCode) {
        response.then().
                statusCode(expectedResponseCode);
    }

    @And("I expected the response body")
    public void iExpectedTheResponseBody(String expectedResponseBody) {
        Assert.assertTrue("ERROR! los json no son iguales" , CompareJsonSol.areEqualJson(replaceAllData(expectedResponseBody),response.getBody().asString()));

    }

    @And("I get the property {} save on {}")
    public void iGetThePropertyIdSaveOnID_PROJECT(String property, String varName) {
        data.put(varName,response.then().extract().path(property)+"");
    }

    private String replaceAllData(String value){

        for (String key: data.keySet()) {
            value=value.replace(key,data.get(key));
        }

        return value;
    }

    @And("use the token next request")
    public void useTheTokenNextRequest() {
        request.setAuthType(Config.TOKEN);
        request.setAuthValue(data.get("TOKEN"));
    }
}

package in.reqres.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import in.reqres.reqresinfo.ReqresSteps;
import in.reqres.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ReqresStepsDef {

    static String name = "NewlyCreatedUser" + TestUtils.getRandomValue();
    static String job =  "NewTester" + TestUtils.getRandomValue();
    static String email =  "eve.holt@reqres.in" + TestUtils.getRandomValue();
    static String password =  "cityslicka" + TestUtils.getRandomValue();
    static int id;

    static ValidatableResponse response;

    @Steps
    ReqresSteps reqresSteps;

    @When("^I submit the GET request at list endpoint$")
    public void iSubmitTheGETRequestAtListEndpoint() {
        response = reqresSteps.getAllUsersList();
    }

    @Then("^I should get response (\\d+) success status code$")
    public void iShouldGetResponseSuccessStatusCode(int arg0) {
        response.statusCode(200);
    }

    @When("^I submit the get request for single user at Single user endpoint by sending \"([^\"]*)\"$")
    public void iSubmitTheGetRequestForSingleUserAtSingleUserEndpointBySending(int id ) {
        response= reqresSteps.getSingleUserById(4);
    }

    @Given("^I want to execute createSingleUser endpoint on reqres website$")
    public void iWantToExecuteCreateSingleUserEndpointOnReqresWebsite() {

    }

    @When("^I submit the POST request  for create single user with name and job$")
    public void iSubmitThePOSTRequestForCreateSingleUserWithNameAndJob() {
        response = reqresSteps.createUser(name,job);
    }

    @Then("^I should get (\\d+) success  status code along with response body$")
    public void iShouldGetSuccessStatusCodeAlongWithResponseBody(int arg0) {
        response.log().all().statusCode(201);
    }

    @Given("^I want to execute update User  endpoint$")
    public void iWantToExecuteUpdateUserEndpoint() {

    }
    @When("^I submit the put request for  to update  user$")
    public void iSubmitThePutRequestForToUpdateUser() {
        job  = job +"Updated";
        response = reqresSteps.updateUser(name,job);
        assertThat(response.extract().body().jsonPath().get("job"), equalTo(job));

    }

    @Then("^I should get (\\d+) success status  code along with updated response body$")
    public void iShouldGetSuccessStatusCodeAlongWithUpdatedResponseBody(int arg0) {
        response.log().all().statusCode(200);
    }


    @Given("^I want to execute delete User  endpoint$")
    public void iWantToExecuteDeleteUserEndpoint() {
    }

    @When("^I submit the delete request for  to delete  user$")
    public void iSubmitTheDeleteRequestForToDeleteUser() {
        response = reqresSteps.deleteUser(id);
        response.statusCode(204);
    }

    @Given("^I want to execute login User  endpoint$")
    public void iWantToExecuteLoginUserEndpoint() {
    }

    @When("^I submit the POST request for login$")
    public void iSubmitThePOSTRequestForLogin() {
        response = reqresSteps.UserLoginSuccessfull(email,password);

    }

    @Then("^I should get (\\d+) success status$")
    public void iShouldGetSuccessStatus(int arg0) {
    }
}

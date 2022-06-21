package in.reqres.reqresinfo;

import in.reqres.constants.EndPoints;
import in.reqres.model.UsersPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class ReqresSteps {

    @Step("Getting the List of all Users")
    public ValidatableResponse getAllUsersList() {
        return SerenityRest.given().log().all()
                .queryParam("page", 2)
                .when()
                .get(EndPoints.LIST_ALL_USERS)
                .then();
    }

    @Step("This Test Will Verify If StatusCode Is 200")
    public ValidatableResponse verifyIfTheStatusCodeIs200() {
        return SerenityRest.rest()
                .given()
                .when()
                .get("/list")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Step("Getting The Single User By Id")
    public ValidatableResponse getSingleUserById(int id) {
        return SerenityRest.given().log().all()
                .pathParam("id", 2)
                .when()
                .get(EndPoints.GET_SINGLE_USER_BY_ID)
                .then();
    }

    @Step("Creating a User with name:{0},job :{1}")
    public ValidatableResponse createUser(String name, String job) {
        UsersPojo usersPojo = new UsersPojo();
        usersPojo.setName(name);
        usersPojo.setJob(job);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(usersPojo)
                .when()
                .post(EndPoints.CREATE_SINGLE_USER)
                .then();


    }

    @Step("Updating a User with name:{0},job :{1}")
    public ValidatableResponse updateUser(String name, String job) {
        UsersPojo usersPojo = new UsersPojo();
        usersPojo.setName(name);
        usersPojo.setJob(job);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(usersPojo)
                .when()
                .post(EndPoints.UPDATE_SINGLE_USER)
                .then();
    }
    @Step("Deleting User information with UserId: {0}")
    public ValidatableResponse deleteUser(int id) {
        return SerenityRest.given().log().all()
                .pathParam("id", id)
                .when()
                .delete(EndPoints.DELETE_USER_BY_ID)
                .then();
    }
    @Step("User Should Login successfully With Email And Password")
    public ValidatableResponse UserLoginSuccessfull(String email, String password) {

        UsersPojo usersPojo = new UsersPojo();
        usersPojo.setEmail(email);
        usersPojo.setPassword(password);
        return SerenityRest.given().log().all()
                //.contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(usersPojo)
                .when()
                .post(EndPoints.USER_LOGIN)
                .then();


    }
}
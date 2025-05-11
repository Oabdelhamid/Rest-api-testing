package API.Actions;

import API.DATA.Userdata;
import API.pojo.User;
import io.restassured.response.Response;

import static API.steps.UserSteps.GenerateUser;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserActions {

    public static Response Register(User user) {
        return given().log().all().baseUri(Userdata.baseuri)
                   .header("Content-Type", "application/json")
                   .body(user)
                   .when().post(Userdata.registerEndpoint)
                   .then().log().all()
                   .extract().response();
    }

    public static Response login(User user) {
       return given().log().all().baseUri(Userdata.baseuri)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(user)
                .when().post(Userdata.loginEndpoint)
                .then().log().all()
                .extract().response();

    }


}

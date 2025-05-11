package API.Testcase;

import API.Actions.UserActions;
import API.DATA.Errors;
import API.DATA.Userdata;
import API.pojo.User;
import API.steps.UserSteps;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserTest {

    @Test (description = "Check that user is able to register")
    public void CheckThatUserAbeleToRegister  () {
        User user = UserSteps.GenerateUser();
       Response response = UserActions.Register(user);
        assertThat(response.statusCode(),equalTo(201));

    }
    @Test (description = "Check that user is not able to register with existing email")
    public void CheckThatExistUserNotAbeleToRegister(){
        User user = UserSteps.ExistUserError();
        Response response = UserActions.Register(user);
        assertThat(response.body().path("message"),equalTo(Errors.ExistsEmailError));
    }

    @Test (description = "Login with valid mail and password")
    public void validLogin(){
        User user = UserSteps.GenerateUser();
         UserActions.Register(user);
        User login = new User(user.getEmail(), user.getPassword());
        Response response1 =  UserActions.login(login);
        assertThat(response1.statusCode(),equalTo(200));

    }

    @Test (description = "login with wrong password")
    public void invalidLogin(){
        User user = UserSteps.GenerateUser();
        UserActions.Register(user);
        User login = new User(user.getEmail(), "wrongpassword");
        Response response1 =  UserActions.login(login);
        assertThat(response1.body().path("message"),equalTo(Errors.passwordError));

    }







}

package API.steps;

import API.Actions.UserActions;
import com.github.javafaker.Faker;
import API.pojo.User;
import io.restassured.response.Response;

public class UserSteps {

    public static User GenerateUser() {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String password = "StrongPassword123!";
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        return new User(email, password, firstName, lastName);

    }


public static User ExistUserError(){
        User user = GenerateUser();
        UserActions.Register(user);
        return user;

}



}

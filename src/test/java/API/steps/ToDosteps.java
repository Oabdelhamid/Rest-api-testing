package API.steps;

import API.Actions.ToDoActions;
import API.Actions.UserActions;
import API.DATA.Responses;
import API.pojo.User;
import API.pojo.todo;
import com.github.javafaker.Faker;
import io.restassured.response.Response;

import static API.steps.UserSteps.GenerateUser;

public class ToDosteps {

    public static String getToken(){
        User user = GenerateUser();
        Response response = UserActions.Register(user);
        return response.body().path(Responses.AccessToken);

    }

    public static todo GenerateTodo() {
        Faker faker = new Faker();
        String item = faker.book().title();
        Boolean isCompleted = false;
        return new todo(item, isCompleted);
    }

    public static String getToDoId () {
        todo todo = GenerateTodo();
        String Token = getToken();
        Response response = ToDoActions.AddTodo(todo, Token);
        return response.body().path(Responses.id);

    }


}

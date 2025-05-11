package API.Testcase;

import API.Actions.ToDoActions;
import API.pojo.todo;
import API.steps.ToDosteps;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class toDoTest {


    @Test (description = "Create todo")
    public void testCreateTodo() {
        todo todo = ToDosteps.GenerateTodo();
        String Token = ToDosteps.getToken() ;
        Response response = ToDoActions.AddTodo(todo, Token);
       assertThat(response.statusCode(), equalTo(201));

    }

    @Test (description = "Get all added todos")
    public void getAllTodos() {
        String Token = ToDosteps.getToken();
        todo todo = ToDosteps.GenerateTodo();
        ToDoActions.AddTodo(todo, Token);
        Response response = ToDoActions.GetAllTodo(Token);
        assertThat(response.statusCode(), equalTo(200));
    }

    @Test (description = "Delete todo")
    public void testDeleteTodo() {
        String Token = ToDosteps.getToken();
        todo todo = ToDosteps.GenerateTodo();
        ToDoActions.AddTodo(todo, Token);
        String todo_id = ToDosteps.getToDoId();
        System.out.println("this is todo id" + todo_id);
        Response deleteResponse = ToDoActions.deleteTodo(Token, todo_id);
        assertThat(deleteResponse.statusCode(), equalTo(200));
    }


}

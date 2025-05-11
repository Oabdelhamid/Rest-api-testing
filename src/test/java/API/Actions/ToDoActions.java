package API.Actions;

import API.DATA.Userdata;
import API.pojo.todo;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ToDoActions {

    public static Response AddTodo(todo todo, String Token){

        return given().log().all()
                .baseUri(Userdata.baseuri)
                .header("Content-Type", "application/json")
                .auth().oauth2(Token)
                .body(todo)
                .when().post(Userdata.GetAllTodoEndpoint)
                .then().log().all()
                .extract().response();
    }

    public static Response GetAllTodo(String Token){

        return given().log().all()
                .baseUri(Userdata.baseuri)
                .header("Content-Type", "application/json")
                .auth().oauth2(Token)
                .when().get(Userdata.GetAllTodoEndpoint)
                .then().log().all()
                .extract().response();
    }
    public static Response deleteTodo(String Token, String id){

        return given().log().all()
                .baseUri(Userdata.baseuri)
                .header("Content-Type", "application/json")
                .auth().oauth2(Token)
                .when().delete(Userdata.GetAllTodoEndpoint + "/" + id)
                .then().log().all()
                .extract().response();

    }





}

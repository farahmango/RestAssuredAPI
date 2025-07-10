package endpoints;
//contains the CRUD operations
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import module.User;
import routes.Route;

import static io.restassured.RestAssured.*;

public class UserEndPoint {

        public static Response createUser(User payload){
               Response response= given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON).
                body(payload).
                when().
                post(Route.post_user_url);
        return response;
        }

        public static Response updateUser(User payload , String user){
                Response response= given()
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON).
                        pathParam("userName",user).
                        body(payload).
                        when().
                        put(Route.put_user_url);
                return response;
        }

        public static Response readUser(String user){
                Response response= given().
                        accept(ContentType.JSON).
                        pathParam("userName",user).
                        when().
                        get(Route.get_user_url);
                return response;
        }
        public static Response deleteUser( String user){
                Response response= given().
                        accept(ContentType.JSON).
                        pathParam("userName",user).
                        when().
                        delete(Route.delete_user_url);
                return response;
        }
}

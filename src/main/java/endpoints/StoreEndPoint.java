package endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import module.Store;
import module.User;
import routes.Route;

import static io.restassured.RestAssured.given;

public class StoreEndPoint {

    public static Response createOrder(Store payload){
        Response response= given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON).
                body(payload).
                when().
                post(Route.post_store_url);
        return response;
    }


    public static Response getOrder(int id){
        Response response= given().
                accept(ContentType.JSON).
                pathParam("orderId",id).
                when().
                get(Route.get_store_url);
        return response;
    }
    public static Response deleteOrder( int id){
        Response response= given().
                accept(ContentType.JSON).
                pathParam("orderId",id).
                when().
                delete(Route.delete_store_url);
        return response;
    }




}

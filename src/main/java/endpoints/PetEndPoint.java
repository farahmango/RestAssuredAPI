package endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import module.Pet;
import routes.Route;

import static io.restassured.RestAssured.given;

public class PetEndPoint {


    public static Response addPet(Pet payload){
        Response response= given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON).
                body(payload).
                when().
                post(Route.post_pet_url);
        return response;
    }

    public static Response getPet(int petId){
        Response response= given()
                .accept(ContentType.JSON).
                contentType(ContentType.JSON).
                pathParam("petId",petId).
                when().
                get(Route.get_pet_url);
        return response;
    }
    public static Response deletePet(int petId){
        Response response= given()
                .accept(ContentType.JSON).
                contentType(ContentType.JSON).
                pathParam("petId",petId).
                when().
                delete(Route.delete_pet_url);
        return response;
    }

    public static Response updatePet(String payload , int petId){
        Response response= given()
                .accept(ContentType.JSON).
                contentType("application/x-www-form-urlencoded").
                pathParam("petId",petId).
                body(payload).
                when().
                post(Route.update_pet_url);
        return response;
    }
}

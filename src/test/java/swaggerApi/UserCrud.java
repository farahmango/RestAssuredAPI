package swaggerApi;

import com.github.javafaker.Faker;
import endpoints.UserEndPoint;
import io.restassured.response.Response;
import module.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserCrud {
    User userPayload;
    @BeforeClass
    public void setData(){
        Faker faker = new Faker();
        userPayload = new User();
        userPayload.setId(faker.number().numberBetween(1,2));
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().emailAddress());
        userPayload.setPassword(faker.internet().password());
        userPayload.setPhone(faker.phoneNumber().phoneNumber());
        userPayload.setUserStatus(faker.code().hashCode());
    }

    @Test(priority = 1)
    public void createUser(){
        Response response = UserEndPoint.createUser(this.userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test(priority = 2)
    public void updateUser(){
        System.out.println(this.userPayload.getUsername());
        userPayload.setFirstName("farah");
        userPayload.setLastName("mango");
        Response response = UserEndPoint.updateUser(userPayload,this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test(priority = 3)
    public void getUser(){
        System.out.println(this.userPayload.getUsername());
//        Response response = UserEndPoint.readUser(this.userPayload.getUsername());
//        response.then().log().all();
//        Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test(priority = 4)
    public void deleteUser(){
        System.out.println(this.userPayload.getUsername());
        Response response = UserEndPoint.deleteUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
}

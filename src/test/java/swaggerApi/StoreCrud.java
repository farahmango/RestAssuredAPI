package swaggerApi;

import com.github.javafaker.Faker;
import endpoints.StoreEndPoint;
import io.restassured.response.Response;
import module.Store;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class StoreCrud {

    Store storePayload;
    @BeforeClass
    public void setData(){
        Faker faker = new Faker();
        storePayload = new Store();
        storePayload.setId(faker.number().numberBetween(1,2));
        storePayload.setPetId(faker.number().numberBetween(1,10));
        storePayload.setQuantity(faker.number().numberBetween(0,10));
        storePayload.setStatus(faker.name().name());
//        storePayload.setShipDate("null");
        storePayload.setComplete(true);
    }

    @Test(priority = 1)
    public void createOrder(){
        Response response = StoreEndPoint.createOrder(this.storePayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 3)
    public void getOrder(){
        System.out.println(this.storePayload.getId());
        Response response = StoreEndPoint.getOrder(this.storePayload.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test(priority = 4)
    public void deleteOrder(){
        System.out.println(this.storePayload.getId());
        Response response = StoreEndPoint.deleteOrder(this.storePayload.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
    
}

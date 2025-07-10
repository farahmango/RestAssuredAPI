package swaggerApi;

import endpoints.StoreEndPoint;
import io.restassured.response.Response;
import module.Store;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StoreDDT {
    Store store =new Store();
    @BeforeClass
    public void beforeClass(){

    }

    @Test(dataProvider = "store-data",dataProviderClass = dataprovider.Dataprovider.class)
    public void createStoreData(int id, int petId, int quantity, String shipDate, String status,boolean complete) throws InterruptedException {
        store.setId(id);
        store.setPetId(petId);
        store.setQuantity(quantity);
        store.setShipDate(shipDate);
        store.setStatus(status);
        store.setComplete(complete);
        Response response =  StoreEndPoint.createOrder(store);
        System.out.println(response.then().log().body());
        Thread.sleep(5000);

    }
    @Test(dataProvider = "storeId",dataProviderClass = dataprovider.Dataprovider.class)
    public void getStoreData(double id) throws InterruptedException {
        Thread.sleep(5000);
        Response response =  StoreEndPoint.getOrder((int) id);
        System.out.println(response.then().log().body());
    }
}

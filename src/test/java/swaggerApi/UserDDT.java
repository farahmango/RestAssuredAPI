package swaggerApi;

import dataprovider.Dataprovider;
import endpoints.UserEndPoint;
import io.restassured.response.Response;
import module.User;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UserDDT {

    User userPayload = new User();
    @Test(priority = 1,dataProvider = "user-data",dataProviderClass = dataprovider.Dataprovider.class)
    public void createUsers(int id,String userName,String first_name,String last_name,String email,String password,String phone,int userStatus) throws InterruptedException {
        userPayload.setId(id);
        userPayload.setUsername(userName);
        userPayload.setFirstName(first_name);
        userPayload.setLastName(last_name);
        userPayload.setEmail(email);
        userPayload.setPassword(password);
        userPayload.setPhone(phone);
        userPayload.setUserStatus(userStatus);
        Response response = UserEndPoint.createUser(this.userPayload);
        Assert.assertEquals(response.getStatusCode(),200);
        Thread.sleep(5000);

    }
    @Test(priority = 2, dataProvider="username",dataProviderClass =  dataprovider.Dataprovider.class)
    public void getUser(String username) throws InterruptedException {
        Thread.sleep(5000);
        Response response = UserEndPoint.readUser(username);
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 3, dataProvider="username",dataProviderClass =  dataprovider.Dataprovider.class)
    public void deleteUser(String userName) throws InterruptedException {
        Thread.sleep(5000);
        Response response = UserEndPoint.deleteUser(userName);
        Assert.assertEquals(response.getStatusCode(),200);
    }
}

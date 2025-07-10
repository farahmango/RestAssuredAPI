package swaggerApi;

import com.github.javafaker.Faker;
import endpoints.PetEndPoint;
import io.restassured.response.Response;
import module.Pet;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PetCrud {

    Pet petPayload;
    @BeforeClass
    public void setData(){
        Faker faker = new Faker();
        petPayload = new Pet();
        petPayload.setId(106);
        petPayload.setName(faker.name().name());
        petPayload.setStatus(faker.name().name());
        Map<String, Object> categoryMap = new HashMap<>();
        Map<String, Object> tagsMap = new HashMap<>();
        ArrayList<Object> tags = new ArrayList<>();

        categoryMap.put("id", 1);
        categoryMap.put("name","flafy");
        tagsMap.put("id",1);
        tagsMap.put("name","dogs");
        tags.add(tagsMap);
        petPayload.setCategory(categoryMap);
        petPayload.setTags(tags);

    }

    @Test(priority = 1)
    public void createPet(){
        Response response = PetEndPoint.addPet(this.petPayload);
        System.out.println(this.petPayload.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 2)
    public void updatePet(){
        String formParams = "name=Farah&status=Mango";
        Response response = PetEndPoint.updatePet(formParams, this.petPayload.getId());
        System.out.println(this.petPayload.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 3)
    public void getPet(){
        System.out.println(this.petPayload.getId());
        Response response = PetEndPoint.getPet(this.petPayload.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test(priority = 4)
    public void deletePet(){
        System.out.println(this.petPayload.getId());
        Response response = PetEndPoint.deletePet(this.petPayload.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
}

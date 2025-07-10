package swaggerApi;

import endpoints.PetEndPoint;
import io.restassured.response.Response;
import module.Pet;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PetDDT {
    Pet payload = new Pet();

    @Test(priority = 1,dataProvider = "pet-data",dataProviderClass = dataprovider.Dataprovider.class)
    public void createPets(int id, int categoryId, String categoryName,String name,String photoUrls,int tagId,String tagName,String status) {
        payload.setId(id);
        payload.setName(name);
        payload.setStatus(status);
        Map<String, Object> categoryMap = new HashMap<>();
        Map<String, Object> tagsMap = new HashMap<>();
        ArrayList<Object> tags = new ArrayList<>();
        ArrayList<String> photoUrlsList = new ArrayList<>();
        categoryMap.put("id", categoryId);
        categoryMap.put("name",categoryName);
        tagsMap.put("id",tagId);
        tagsMap.put("name",tagName);
        photoUrlsList.add(photoUrls);
        payload.setPhotoUrl(photoUrlsList);


        System.out.println(photoUrlsList.get(0));
        tags.add(tagsMap);
        payload.setTags(tags);
        payload.setCategory(categoryMap);


        Response response = PetEndPoint.addPet(this.payload);
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(),200);

    }
}

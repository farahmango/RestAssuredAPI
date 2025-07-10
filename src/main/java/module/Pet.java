package module;

import java.util.ArrayList;
import java.util.Map;

public class Pet {

        int id ;
        Map<String,Object> category;
        String name  ;
        String status ;
        ArrayList<Object> tags;
        ArrayList<String> photoUrl;

    public int getId() {
        return id;
    }

    public ArrayList<String> getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(ArrayList<String> photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Object> getCategory() {
        return category;
    }

    public void setCategory(Map<String, Object> category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Object> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Object> tags) {
        this.tags = tags;
    }
}

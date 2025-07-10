package routes;

public class Route {

    public static String base_url = "https://petstore.swagger.io/v2";
    //routes for user module
    public static String get_user_url = "https://petstore.swagger.io/v2/user/{userName}";
    public static String post_user_url = "https://petstore.swagger.io/v2/user";
    public static String delete_user_url = "https://petstore.swagger.io/v2/user/{userName}";
    public static String put_user_url = "https://petstore.swagger.io/v2/user/{userName}";

    //routes for store module
    public static String get_store_url = "https://petstore.swagger.io/v2/store/order/{orderId}";
    public static String post_store_url = "https://petstore.swagger.io/v2/store/order";
    public static String delete_store_url = "https://petstore.swagger.io/v2/store/order/{orderId}";


    //routes for store module
    public static String get_pet_url = "https://petstore.swagger.io/v2/pet/{petId}";
    public static String post_pet_url = "https://petstore.swagger.io/v2/pet";
    public static String delete_pet_url = "https://petstore.swagger.io/v2/pet/{petId}";
    public static String update_pet_url = "https://petstore.swagger.io/v2/pet/{petId}";


}

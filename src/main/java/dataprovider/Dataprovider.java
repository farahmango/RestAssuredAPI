package dataprovider;
import org.testng.annotations.DataProvider;
import utils.ExcelUtils;

public class Dataprovider {

    @DataProvider(name = "user-data")
    public Object[][] sendUser(){
        return ExcelUtils.readData("\\src\\main\\resources\\mockData.xlsx");
    }

    @DataProvider(name = "username")
    public Object[] readUser(){
        return ExcelUtils.readColumn("\\src\\main\\resources\\mockData.xlsx",1);
    }
    @DataProvider(name = "storeId")
    public Object[] readStoreId(){
        return ExcelUtils.readColumn("\\src\\main\\resources\\storeData.xlsx",0);
    }
    @DataProvider(name = "pet-data")
    public Object[][] sendPet(){
        return ExcelUtils.readData("\\src\\main\\resources\\petData.xlsx");
    }

    @DataProvider(name = "store-data")
    public Object[][] sendStore(){
        return ExcelUtils.readData("\\src\\main\\resources\\storeData.xlsx");
    }
}

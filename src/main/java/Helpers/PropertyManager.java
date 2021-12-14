package Helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    public static PropertyManager Instance;
    public static Object Obj = new Object();
    public String FilePathProperty = System.getProperty("user.dir") + "\\src\\main\\resources\\Configuration .properties";

    public String Url;
    public String Browser;
    public String FilePathTestData;
    public String FilePathCV;


    public static PropertyManager getInstance() {
        if (Instance == null) {
            synchronized (Obj) {
                Instance = new PropertyManager();
                Instance.DataLoading();
            }
        }
        return Instance;
    }

    //Get all configuration data and assign to related fields.
    private void DataLoading() {

        Properties Prop = new Properties();


        try {
            Prop.load(new FileInputStream(FilePathProperty));
            Url = Prop.getProperty("Url");
            Browser = Prop.getProperty("Browser");
            FilePathTestData = Prop.getProperty("FilePathTestData");
            FilePathCV = Prop.getProperty("FilePathCV");
            //prop.load(this.getClass().getClassLoader().getResourceAsStream("configuration.properties"));
        } catch (IOException e) {
            System.out.println("File Not Found");
        }

    }

    public String getURL() {
        return Url;
    }

    public String getBrowser() {
        return Browser;
    }

    public String getFilePathTestData() {
        return FilePathTestData;
    }

    public String getFilePathCV() {
        return FilePathCV;
    }


}

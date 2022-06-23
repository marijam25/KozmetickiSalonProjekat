package db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DBPropertiesLoader {

    public class Constants {

        public static final String URL = "url";
        public static final String USER = "user";
        public static final String PASS = "pass";
    }
    
    Properties properties;

    public DBPropertiesLoader() throws FileNotFoundException, IOException {
        properties = new Properties();
        properties.load(new FileInputStream("db.properties"));
    }
    
    public String vratiURL() {
       return properties.getProperty(Constants.URL);
   }
    
     public String vratiUsername() {
       return properties.getProperty(Constants.USER);
   }
     
      public String vratiPassword() {
       return properties.getProperty(Constants.PASS);
   }
    
}

package db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBPropertiesLoader {

    public class Constants {

        public static final String URL = "url";
        public static final String DRIVER = "driver";
        public static final String USER = "user";
        public static final String PASS = "pass";
    }

    private static DBPropertiesLoader instance;

    public static DBPropertiesLoader getInstance() {
        try {
            if (instance == null) {
                instance = new DBPropertiesLoader();
            }

        } catch (IOException ex) {
            Logger.getLogger(DBPropertiesLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instance;
    }

    Properties property;

    private DBPropertiesLoader() throws FileNotFoundException, IOException {
        property = new Properties();
        FileInputStream fis = new FileInputStream("db.properties");
        property.load(fis);
    }

    public String getValue(String key) {
        return property.getProperty(key);
    }
}

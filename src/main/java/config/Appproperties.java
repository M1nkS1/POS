package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Appproperties {

    // This class loads the database configurarion form
    // the db.proberties file

    public static final String DB_URL;
    public static final String DB_USER;
    public static final String DB_PASSWORD;

    public static final int DB_POOL_MAX_SIZE;
    public static final int DB_POOL_MIN_IDLE;

    /*
    This block executes when the class is first initialized by the JVM:
        - first access of static variable
        - call of a static method
        -creation of an object (new)
     */

    static {
        Properties props = new Properties();

        // try-with-resources block
        try(InputStream is = Appproperties.class.getResourceAsStream("/db.properties")){

            if (is == null){
                throw new RuntimeException("db.properties could not be found");
            }

            props.load(is);  // lädt automatisch alles in der datei in das popertyobjekt rein

            DB_URL = props.getProperty("db.url");
            DB_USER = props.getProperty("db.user");
            DB_PASSWORD = props.getProperty("db.password");

            DB_POOL_MAX_SIZE = Integer.parseInt(props.getProperty("db.pool.maxSize"));
            DB_POOL_MIN_IDLE = Integer.parseInt(props.getProperty("db.pool.minIdle"));



        }catch (IOException e){
            throw new RuntimeException("Error lodading db.properties", e); // schließt automatisch
        }
    }

    public static void main(String[] args) {
        System.out.println(DB_URL);
        System.out.println(DB_USER);
        System.out.println(DB_PASSWORD);

    }

}

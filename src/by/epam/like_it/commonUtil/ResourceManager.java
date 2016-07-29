package by.epam.like_it.commonUtil;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;


public enum ResourceManager {

    DATABASE("resource.db.database");

    private final ResourceBundle resourceBundle;

    ResourceManager(String string){
        Logger logger = LogManager.getLogger(ClassName.getClassName());
        ResourceBundle tempBundle = null;
        try {
            tempBundle = ResourceBundle.getBundle(string);
        } catch (MissingResourceException e){
            logger.warn("There no file resource.database");
        }
        resourceBundle = tempBundle;

    }

    public String getString(String key){
        return resourceBundle.getString(key);
    }

    public Set<String> keySet() {
        return resourceBundle.keySet();
    }
}

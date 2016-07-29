package by.epam.like_it.dao.mysql.util;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;


public enum ResourceManager {

    STRUCTURE(Constants.DB_STRUCTURE),
    PARTS(Constants.QUERY_PARTS),
    DB(Constants.DB_MAIN),
    JOIN(Constants.JOIN),
    LINKS(Constants.LINKS);

    /**
     * Contains paths to resources
     */
    private static class Constants {
        private static final String DB_STRUCTURE = "resource.db.databaseStructure";
        private static final String QUERY_PARTS = "resource.db.queryParts";
        private static final String DB_MAIN = "resource.db.database";
        private static final String JOIN = "resource.db.written.joinKey";
        private static final String LINKS = "resource.db.written.relationMethods";
    }

    private ResourceBundle resourceBundle;

    ResourceManager(String string){
        resourceBundle = ResourceBundle.getBundle(string);
    }

    public String getString(String key){
        return resourceBundle.getString(key);
    }

    public Set<String> keySet() {
        return resourceBundle.keySet();
    }

    public String[] getStringArray(String key) {
        return resourceBundle.getStringArray(key);
    }

    public Object getObject(String key) {
        return resourceBundle.getObject(key);
    }

    public Locale getLocale() {
        return resourceBundle.getLocale();
    }

    public Enumeration<String> getKeys() {
        return resourceBundle.getKeys();
    }

    public boolean containsKey(String key) {
        return resourceBundle.containsKey(key);
    }
}

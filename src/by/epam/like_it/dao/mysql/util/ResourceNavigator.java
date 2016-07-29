package by.epam.like_it.dao.mysql.util;


import by.epam.like_it.commonUtil.ClassName;
import by.epam.like_it.model.Entity;
import org.apache.logging.log4j.LogManager;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.MissingResourceException;
import java.util.stream.Stream;

import static by.epam.like_it.dao.mysql.util.ResourceManager.*;

/**
 * Class with static methods : facade for dealing with properties
 */
public class ResourceNavigator {

    private static org.apache.logging.log4j.Logger logger = LogManager.getLogger(ClassName.getClassName());

    public static final String PR_CLASS = "clazz.";
    public static final String PR_TABLE = "table.";
    public static final String OPT_COL_NUBERS = ".num";
    public static final int OPT_START_COL_INDEX = 1;

//    public static final String RELATED_MARKER = "$";
    public static final String RELATED_DELIMITER = ".";
    public static final String RELATED_DELIMITER_RGX = "\\.";

    public static final String CRITERIA_DELIMITER = "$";
    public static final String CRITERIA_DELIMITER_RGX = "\\$";
    public static final String THIS_CLASS_MARKER = "_";

    public static final String JOIN_KEY_PATTERN = "%s.%s";
    public static final String PREFIX = Entity.class.getPackage().getName();

    public static String getReferencedTable(Class modelClass, boolean full){
        String key = PR_CLASS + modelClass.getSimpleName();
        String result ="";
        try {
             result = STRUCTURE.getString(key);
        } catch (MissingResourceException e){
            logger.error("Try to find unexisting resource on key " + key);
            return result;
        }
        return full ? DB.getString("database.name") + "." + result : result;
    }

     public static String getReferencedTable(Class<? extends Entity> clazz){
         String result ="";
         String key = PR_CLASS + clazz.getSimpleName().toLowerCase();
         try {
             result = STRUCTURE.getString(key);
         } catch (MissingResourceException e){
             logger.error("Try to find unexisting ReferencedTable by key " + key + " on class " + clazz);
             return result;
         }
         return result;
    }

    public static String getRefencedClass(String name){
        String result ="";
        String key = PR_TABLE + name;
        try {
            result = STRUCTURE.getString(key);
        } catch (MissingResourceException e){
            logger.error("Try to find unexisting ReferencedTable by key " + key + " on class name " + name);
            return result;
        }
        return result;
    }

    public static boolean isReferenceComplex(String name){
        return name.contains(RELATED_DELIMITER);
    }

    public static String getFullTableName(String name){
        return DB.getString("database.name") + "." + name;
    }


    public static ArrayList<String> getAllFields(String tableName){
        int attrCount = getAttrCount(tableName);
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = OPT_START_COL_INDEX; i <= attrCount; i++) {
            String value = STRUCTURE.getString(tableName + "." + i);
            arrayList.add(value);
        }
        return arrayList;
    }

    public static Stream<String> getAllFields(String tableName, boolean qualified){
        int attrCount = getAttrCount(tableName);
        String prefix = tableName + ".";

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = OPT_START_COL_INDEX; i <= attrCount; i++) {
            String value = STRUCTURE.getString(prefix + i);
            arrayList.add(value);
        }
        return qualified ? arrayList.stream().map(s -> prefix + s) : arrayList.stream() ;
    }

    public static int getAttrCount(String tableName){
        String columnCount = STRUCTURE.getString(tableName  + OPT_COL_NUBERS);
        return Integer.parseInt(columnCount);
    }

    public static String getKeyForJoin(String tableFirst, String tableSecond){
        String[] strings = {tableFirst, tableSecond};
        Arrays.sort(strings);
        return String.format(JOIN_KEY_PATTERN, strings);
     }

    public static String getOrderedKeyForJoin(String tableFirst, String tableSecond){
        return String.format(JOIN_KEY_PATTERN, tableFirst, tableSecond);
    }

    public static String getKeyForClassLink(Class clazzMain, Class clazzRef, String relTable){
        String result = "";
        String relPattern = relTable.isEmpty() ? relTable : "." + relTable;
        String key = clazzMain.getSimpleName() + "." + clazzRef.getSimpleName()
                + relPattern;
        try {
            result = LINKS.getString(key);
        } catch (MissingResourceException e){
            logger.error("Try to find unexisting ReferencedTable by key " + key);
            return result;
        }
        return result;
    }

    /**
     * parameters based on db and model records
     * <p>Example: table.categories_tags = categories.tags -> enter categories and categories_tags.</p>
     * @param mainTable : table to which method looking for another table to join
     * @param relTable : class presumably with links to two tables
     * @return empty string if refTable isn't related table, in other case - table to join throw join with
     */

     public static String getAnotherTableByRefTable(String mainTable, String relTable){
        String refClasses = getRefencedClass(relTable);
        return getAnotherTableByTable(mainTable, refClasses);
    }

     /**
     * parameters based on db records
     * get VALUE of getRefencedClass return value
     * <p>Example: table.categories_tags = categories.tags -> enter categories and categories.tags.</p>
     * @param mainTable : table to which method looking for another table to join
     * @param refTable : table presumably with links to two tables
     * @return empty string if refTable isn't related table, in other case - table to join throw join with
     *
     */
    public static String getAnotherTableByTable(String mainTable, String refTable) {
        String anotherTable = "";
        String[] pair = refTable.split(ResourceNavigator.RELATED_DELIMITER_RGX);
        if (pair.length < 2){
            return anotherTable;
        }
        anotherTable = !pair[0].equals(mainTable) ? pair[0] : pair[1];
        return anotherTable;
    }



//    public static void main(String[] args) {
//        // tags posts_tags;
//        System.out.println(getAnotherTableByTable("tags", "posts_tags"));
//    }

    /* Reflection methods */

    public static boolean isClassMaintainInterface (Object classToCheck, Class infTocCheck) {
        Class[] inf = classToCheck.getClass().getInterfaces();
        boolean isMaintain = false;
        for (Class cl : inf) {
            if (cl.equals(infTocCheck)) {
                isMaintain = true;
            }
        }
        return isMaintain;
    }

    public static String getFullClassName(String className){
        return PREFIX + "." + className;
    }
}

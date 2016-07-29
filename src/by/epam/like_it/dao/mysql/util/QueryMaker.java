package by.epam.like_it.dao.mysql.util;


import by.epam.like_it.dao.mysql.criteriaImpl.CriteriaMySql;
import by.epam.like_it.model.Entity;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Stream;


public class QueryMaker {

    private static final String SELECT = "SELECT ";
    private static final String DELETE = "DELETE FROM ";
    private static final String UPDATE = "UPDATE ";
    private static final String INSERT = "INSERT INTO ";

    private static final String FROM = "FROM ";
    private static final String VALUES = "\nVALUES ";
    private static final String SET = "\nSET ";
    private static final String DEFAULT = "DEFAULT";
    private static final String APPEND_BY_ID = "\nWHERE id = ?";
    private static final String APPEND_SET_BANNED = "\nSET banned = true";


    public static String getSelectAll(Class clazz) {
        String tableName = ResourceNavigator.getReferencedTable(clazz, false);
        String tableFullName = ResourceNavigator.getReferencedTable(clazz, true);

        ArrayList<String> fieldsString = ResourceNavigator.getAllFields(tableName);
        String enumPart = collectList(fieldsString, ", ", 0);

        StringBuilder query = new StringBuilder(SELECT);
        query.append(enumPart)
             .append("\n")
             .append(FROM)
             .append(tableFullName);
        return query.toString();
    }

    public static String getSelectAll(Class clazz, CriteriaMySql criteria) {
        String simpleSelect = "SELECT %s\nFROM %s\n%s";
        String complexSelect = "SELECT %s\nFROM %s%s\n%s";
        //  String complexPattern = "SELECT %s\nFROM %s\n ";
        String mainTable = ResourceNavigator.getReferencedTable(clazz, false);
        String tableFullName = ResourceNavigator.getReferencedTable(clazz, true);

        Stream<String> firstFields = ResourceNavigator.getAllFields(mainTable, true);
        if (criteria.isSimle()) {
            String enumPart = firstFields.reduce((s, s2) -> s + ", " + s2).get();
            String criteriaPart = criteria.getString();
            return String.format(simpleSelect, enumPart, tableFullName, criteriaPart);
        } else {
            List<String> refTables = criteria.getRefTables();
            Stream<String> stream = null;
            StringBuilder joinPart = new StringBuilder("");

            for (String refTable : refTables){
                processJoin(joinPart, mainTable, refTable);
                String anotherTable = ResourceNavigator.getAnotherTableByRefTable(mainTable, refTable);
                if (!anotherTable.isEmpty()){
                    processJoin(joinPart, refTable, anotherTable);
                    refTable = anotherTable;
                }
                Stream<String> secondFields = ResourceNavigator.getAllFields(refTable, true);
                stream = Stream.concat(firstFields, secondFields);
                firstFields = stream;
            }

            String fields = stream.reduce((s, s2) -> s + ", " + s2).get();
            return String.format(complexSelect, fields, tableFullName, joinPart, criteria.getString());
        }
    }

    private static void processJoin(StringBuilder joinPart, String mainTable, String refTable){
        String joinPattern = "\nJOIN %s \nON %s";
        String key =  ResourceNavigator.getKeyForJoin(mainTable, refTable);
        String joinValue = ResourceManager.JOIN.getString(key);
        joinPart.append(String.format(joinPattern, ResourceNavigator.getFullTableName(refTable), joinValue));
    }

    public static String getSelectById(Class dao) {
        String queryAll = getSelectAll(dao);
        return queryAll + APPEND_BY_ID;
    }

    @NotNull
    public static String getDeleteById(Class clazz) {
        StringBuilder result = new StringBuilder(DELETE);
        result.append(ResourceNavigator.getReferencedTable(clazz, true))
              .append(APPEND_BY_ID);
        return result.toString();
    }

    @NotNull
    public static String getDeleteByBan(Class clazz) {

        StringBuilder result = new StringBuilder(UPDATE);
        result.append(ResourceNavigator.getReferencedTable(clazz, true))
              .append(APPEND_SET_BANNED)
              .append(APPEND_BY_ID);
        return result.toString();
    }

    @NotNull
    public static String getUpdate(Class clazz) {

        String tableName = ResourceNavigator.getReferencedTable(clazz, false);
        String tableFullName = ResourceNavigator.getReferencedTable(clazz, true);

        ArrayList<String> fields = ResourceNavigator.getAllFields(tableName);
        String setPartOfQuery = modifyAndCollectPattern(fields, ", ", "%s = ?", 1);

        StringBuilder query = new StringBuilder(UPDATE);
        query.append(tableFullName)
             .append(SET)
             .append(setPartOfQuery)
             .append(APPEND_BY_ID);
        return query.toString();
    }



    @NotNull
    public static <T extends Entity> String getCreate(Class clazz) {

        String tableName = ResourceNavigator.getReferencedTable(clazz, false);
        String tableFullName = ResourceNavigator.getReferencedTable(clazz, true);

        ArrayList<String> fields = ResourceNavigator.getAllFields(tableName);
        String fieldsString = collectList(fields, ", ", 0);
        String setPart = surroundWithParenthesis(modifyAndCollectByReplacement(fields, ",", "?", 0));

        StringBuilder query = new StringBuilder(INSERT);
        query.append(tableFullName)
             .append(" ")
             .append(surroundWithParenthesis(fieldsString))
             .append(VALUES)
             .append(setPart.replaceFirst("\\?", DEFAULT));
        return query.toString();
    }

    @NotNull
    public static <T extends Entity> String getSelect(Class clazz, CriteriaMySql<T> criteria) {
        return getSelectAll(clazz) + criteria.getString();
    }


    public static boolean isClassMaintainInterface (Object classToCheck, Class infTocCheck){
        return ResourceNavigator.isClassMaintainInterface(classToCheck, infTocCheck);
    }

    /*decorative methods*/

    public static String collectList(List<String> list, String separator, int skip) {
        final Stream<String> stream = list.parallelStream();
        return stream.skip(skip).reduce((s1, s2) -> s1 + separator + s2).get();
    }

    public static String modifyAndCollectPattern(List<String> list, String separator,
                                                 String pattern, int skip) {
        final Stream<String> stream = list.parallelStream();
        return stream.skip(skip).map(s -> String.format(pattern, s))
                     .reduce((s1, s2) -> s1 + separator + s2).get();
    }

    public static String modifyAndCollectByReplacement(List<String> list, String separator,
                                                       String modificator, int skip) {
        final Stream<String> stream = list.parallelStream();
        return stream.skip(skip).map(s -> modificator)
                     .reduce((s1, s2) -> s1 + separator + s2).get();
    }

    public static String surroundWithParenthesis(String s) {
        return "(" + s + ")";
    }

    public static String surroundWithParenthesis(StringBuilder s) {
        return s.insert(0, "(").append(")").toString();
    }

}

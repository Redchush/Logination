package by.epam.like_it.dao.mysql.util;


import by.epam.like_it.commonUtil.ClassName;
import by.epam.like_it.dao.connection_pool.ConnectionPool;
import by.epam.like_it.dao.connection_pool.exception.ConnectionPoolException;
import by.epam.like_it.dao.exception.DaoException;
import by.epam.like_it.model.Entity;
import by.epam.like_it.model.Rating;
import by.epam.like_it.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ResourceWriter {

    private Connection connection;
    private ConnectionPool pool;
    private DatabaseMetaData metaData;
    private List<String> tableNames;
    private HashMap<String, NavigableMap<String, String>> result = new HashMap<>();

    public ResourceWriter(){ }

    public ResourceWriter init(Connection connection) throws ConnectionPoolException, SQLException {
        if (connection == null){
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
        }
        metaData = connection.getMetaData();
        String[] types = {"TABLE"};
        ResultSet tables = metaData.getTables(null, null, null, types);
        tableNames = collectTableNames(tables);
        return this;
    }

    public ResourceWriter process() throws DaoException, ConnectionPoolException, SQLException {
        collectAll();
        return this;
    }

    public ResourceWriter close(){
        pool.dispose();
        return this;
    }



    private static Logger logger = LogManager.getLogger(ClassName.getClassName());

    public void collectAll() throws ConnectionPoolException, SQLException, DaoException {
        String path = "src\\resource\\written\\joinKey.properties";
        NavigableMap<String, String> mapJoin = new TreeMap<>();
        ArrayList<String> keys = new ArrayList<>();
        Map<String, String> map = null;
        map = prepareResources(mapJoin, keys);
        writeJoinInFile(map, path);
        final String prefix = "src\\resource\\written\\table\\";
        writeCriteria(result, prefix);

    }

    private static List<String> collectTableNames(ResultSet set) throws SQLException {
        List<String> names = new ArrayList<>();
        final ResultSetMetaData metaData1 = set.getMetaData();
        while (set.next()){
            names.add(set.getString(3));
        }
        return names;
    }


   public Map<String, String> prepareResources(NavigableMap<String,String> mapJoin, List<String> keys)
            throws ConnectionPoolException, SQLException {
        for (int i = 0; i < tableNames.size(); i++) {
            String column = tableNames.get(i);
            try(final ResultSet exportedKeys = metaData.getExportedKeys(null, null, column)){
                mapJoinKeys(exportedKeys, mapJoin, keys, metaData);
            }
            keys.addAll(process(column, column)); //add inner table relationship
        }
        return mapJoin;
    }


    public void mapJoinKeys(ResultSet set, NavigableMap<String, String> mapJoin,
                                   List<String> list, DatabaseMetaData metaData) throws SQLException {

        while (set.next()){
            String table = set.getString(3);
            String field = set.getString(4);
            String refTable = set.getString(7);
            String refField = set.getString(8);
            String value = table + "." + field + " = " + refTable + "." + refField;
            String key1 =  ResourceNavigator.getKeyForJoin(table, refTable);
            mapJoin.put(key1, value);
            list.addAll(process(table, refTable));
        }
    }

    public ArrayList<String> process(String table,
                                            String related) throws SQLException {
        ArrayList<String> keys = new ArrayList<>();
        String forman = "%s#%S.%S";
        String format2 = !table.equals(related) ? "%S$%S" : "_$%2$S";
        try(final ResultSet columns = metaData.getColumns(null, null, table, null)){
            while (columns.next()){
                String fieldName = columns.getString(4);
                String fieldType = columns.getString(6);

                NavigableMap<String, String> inner = new TreeMap<>();
                inner.put(String.format(format2, table, fieldName), fieldType);
                Object indicator = result.putIfAbsent(related, inner);
                if (indicator != null){
                    result.get(related).putAll(inner);
                }
            }
        }
        return keys;
    }

    private void attachDependant(Entity main, String dependntClazz)
            throws InvocationTargetException, IllegalAccessException {
        Method need;
        Stream<Method> result  = Arrays.stream(main.getClass().getMethods())
                                       .filter(s -> (s.getParameterTypes()[0].getSimpleName()
                                                                             .equals(dependntClazz)));
    }

    private Method methodNameConstructor(String name) throws NoSuchMethodException {
//        String methodPattern = "create%sList";
        System.out.println(name);
        Method result  = Arrays.stream(EntityCollector.class.getMethods())
                               .filter(s -> s.getName().endsWith(name))
                               .findFirst().get();
        return result;
    }


    public void writeJoinInFile(Map<String, String> map, String path) throws DaoException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            String s = map.entrySet().stream()
                          .map(e -> e.getKey() + " = " + e.getValue())
                          .reduce((s1, s2) -> s1 + '\n' + s2).get();

            writer.write(s);
            writer.flush();
        } catch (IOException e) {
            throw new DaoException("Can't write properties");
        }
    }

    private void writeCriteria(HashMap<String, NavigableMap<String, String>> result,
                                      String prefix) throws DaoException {

        NavigableMap<String, NavigableMap<String, String>> map = new TreeMap<>();
        map.putAll(result);

        try (BufferedWriter tablesAsArray = new BufferedWriter(new FileWriter(prefix + "tables.properties"));
             BufferedWriter textWriter = new BufferedWriter(new FileWriter(prefix + "tables.txt"))) {

            for(Map.Entry<String, NavigableMap<String, String>> entry : map.entrySet()) {
                String key = entry.getKey();
                NavigableMap<String, String> value = entry.getValue();
                tablesAsArray.write(key+" : ");
                textWriter.write(key + " : \n");

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(prefix + key + ".properties"))) {
                    writer.write(value.entrySet().stream().map(t -> t.getKey() + "=" + t.getValue())
                                      .reduce(((s1, s2) -> s1 + "\n" + s2)).get());
                    String textToArray = value.keySet().stream().reduce(((s1, s2) -> s1 + ", " + s2)).get();
                    tablesAsArray.write(textToArray);
                    textWriter.write(textToArray);
                    writer.flush();
                } catch (IOException e) {
                    throw new DaoException("Can't write the properties",e);
                }
                tablesAsArray.write("\n\n");
                textWriter.write("\n\n");
            }
        } catch (IOException e){
            throw new DaoException("Can't write the properties", e);
        }
    }

    public Map<String, String> createMethodsMap()
            throws ConnectionPoolException, SQLException, ClassNotFoundException {

        Map<String, String> result = new TreeMap<>();
        for (int i = 0; i < tableNames.size(); i++) {
            String tableName = tableNames.get(i);
            try(final ResultSet exportedKeys = metaData.getExportedKeys(null, null, tableName)){
                while (exportedKeys.next()){
                    String table = exportedKeys.getString(3);
 //                   String field = exportedKeys.getString(4);
                    String refTable = exportedKeys.getString(7);
  //                  String refField = exportedKeys.getString(8);
//                    System.out.println("!!!"+table + "." + refTable + " : " + value );
                    findMatch(table, refTable, result);
                    findMatch(refTable, table, result);
                  }
            }
        }
        return result;
    }

    public Method findMatch(String table, String refTable, Map<String, String> map) throws ClassNotFoundException {
        String PREFIX = Entity.class.getPackage().getName();
        String relationTable="";
        String refClassName = ResourceNavigator.getRefencedClass(refTable);
        String baseClassName = ResourceNavigator.getRefencedClass(table);
        Method need = null;

        boolean isComplexRef = ResourceNavigator.isReferenceComplex(refClassName);
        boolean isComplexBas = ResourceNavigator.isReferenceComplex(baseClassName);

        System.out.println(refClassName + " " + baseClassName + " isBas " + isComplexBas
                          +" "+ refTable + " "  + table );

        if (isComplexBas){
            relationTable += "." + baseClassName.replace(".", "_");
            baseClassName =  ResourceNavigator.getRefencedClass(
                    ResourceNavigator.getAnotherTableByTable(refTable, baseClassName));
            System.out.println("SEEE: " + baseClassName);
        }

        if (isComplexRef){
            relationTable += "." + refClassName.replace(".", "_");
            refClassName =  ResourceNavigator.getRefencedClass(
                    ResourceNavigator.getAnotherTableByTable(table, refClassName));
            System.out.println("SEEE2:" + refClassName);
        }

        if (!baseClassName.isEmpty() && !refClassName.isEmpty()){
            Stream<Method> streamMethods = null;
            if (!baseClassName.contains(".") && !refClassName.contains(".")) {
                Class<?> baseClass = Class.forName(PREFIX + "." + baseClassName);
                Class<?> refClass = Class.forName(PREFIX + "." + refClassName);

                streamMethods = Arrays.stream(refClass.getMethods())
                                      .filter(s ->
                                             ((s.getName().startsWith("set")|| s.getName().startsWith("add"))
                                               && (s.getParameterTypes()[0] == baseClass)));
                List<Method> collect = streamMethods.collect(Collectors.toList());
//                if (table.equals("users")){
//                    System.out.println("*"+collect);
//                }

                switch (collect.size()) {
                    case 0:
                        break;
                    case 1:
                        if (collect.get(0) == null){
                            break;
                        }
                        String key = refClass.getSimpleName() + "." + baseClass.getSimpleName()
                                + relationTable;

                        String value = collect.get(0).getName();
                        map.put(key, value);
//                        System.out.println(key + " : " + value );
                        break;
//                    case 2:
//                        System.out.println("WARN " + collect);
//                        break;
                }
             }
        }
        return need;
    }

    public void writeMethods(Map<String, String> map, String path) throws DaoException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
             StringBuilder builder = new StringBuilder();
             map.entrySet().forEach(s-> builder.append(s.getKey()).append(" = ")
                                               .append(s.getValue()).append("\n"));
             writer.write(builder.toString());
        } catch (IOException e) {
            throw new DaoException("Can't write the proper ties",e);
        }
    }

    public static void main(String[] args)
            throws DaoException, ConnectionPoolException, SQLException, ClassNotFoundException, NoSuchMethodException {
        final String prefix = "src\\resource\\written\\relationMethods.properties";
        ResourceWriter resourceWriter = null;
       try{
           resourceWriter = new ResourceWriter();
           resourceWriter.init(null);
           resourceWriter.process();
           Map<String, String> methodsMap = resourceWriter.createMethodsMap();
           resourceWriter.writeMethods(methodsMap, prefix);

           System.out.println(Rating.class.getMethod("setAuthor", User.class));
       } finally {
           resourceWriter.close();
       }
    }


}

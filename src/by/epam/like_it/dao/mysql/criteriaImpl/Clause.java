package by.epam.like_it.dao.mysql.criteriaImpl;

/*
* CriteriaFactory
*/

import by.epam.like_it.dao.ConcreteCriteria;
import by.epam.like_it.dao.CriteriaClause;
import by.epam.like_it.dao.mysql.util.ResourceNavigator;
import by.epam.like_it.model.Entity;

public class Clause {

    public enum OrderConstants{
        ASC, DESC;
    }

    public static <T extends Entity> CriteriaPart<T> eq(ConcreteCriteria<T> criteria, String value){
        String[] strings = processCriteria(criteria);
        return new Eq<T>(strings[1], strings[0], value);
    }

    public static <T extends Entity> CriteriaPart<T> like(ConcreteCriteria<T> criteria, String value){
        String[] strings = processCriteria(criteria);
        return new Like<T>(strings[1], strings[0], value);
    }

    public static <T extends Entity> CriteriaPart<T> limit(ConcreteCriteria<T> criteria,  int value){
//        String[] strings = processCriteria(criteriaImpl);
        return new Limit<T>(value);
    }

    public static <T extends Entity> CriteriaPart<T> order(ConcreteCriteria<T> criteria, OrderConstants order){
        String[] strings = processCriteria(criteria);
        return new Order<T>(strings[1], strings[0], order.toString());
    }

    public static <T extends Entity> CriteriaPart<T> or(CriteriaClause<T> ...сriterias){
        return new Or<T>(сriterias);
    }


    private static String[] processCriteria(ConcreteCriteria criteria){
        Enum enums = (Enum) criteria;
        String[] result = enums.name().toLowerCase().split(ResourceNavigator.CRITERIA_DELIMITER_RGX);
        return result;
    }

//    public static void main(String[] args) throws DaoException, ConnectionPoolException {
//        ConnectionPool connectionPool = ConnectionPool.getInstance();
//        try{
//
//            Connection connection = connectionPool.takeConnection();
//            AnswerDaoMySql doa = new AnswerDaoMySql(connection);
//            Criteria<Answer> criteriaList = doa.getCriteria();
//            criteriaList.add(eq(AnswerCriteria._$BANNED, "true"));
//            List<Answer> allByCriteria = doa.findAllByCriteria(criteriaList);
//            System.out.println(allByCriteria.toString());
//        } finally {
//            connectionPool.dispose();
//        }
//    }


//    private static CriteriaPart eq(String field, Class clazz, String value){
//        return new Eq(field, ResourceNavigator.getReferencedTable(clazz, false), value);
//    }
//
//    private static CriteriaPart like(String field, Class clazz, String value){
//        return new Like(field, ResourceNavigator.getReferencedTable(clazz, false), value);
//    }
//
//    private static CriteriaPart limit(String field, Class clazz, int value){
//        return new Limit(field, ResourceNavigator.getReferencedTable(clazz, false), value);
//    }
//    private static CriteriaPart order(String field, Class clazz, OrderConstants order){
//
//        return new Order(field, ResourceNavigator.getReferencedTable(clazz, false), order.toString());
//    }
}

package by.epam.like_it.dao.mysql.criteriaImpl;


import by.epam.like_it.dao.CriteriaClause;

interface CriteriaPart<T> extends CriteriaClause<T>, Comparable<CriteriaPart<T>> {

    int getPosition();

    void increasePosition(int delta);

    String getString(boolean and);

    String getRefTable();

    void setRefTable(String table);

    String getString();

    Object[] getArgs();
}
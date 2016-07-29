package by.epam.like_it.dao;


import by.epam.like_it.model.Entity;

public interface Criteria<T extends Entity> {

    void add(CriteriaClause<T> criteria);
}

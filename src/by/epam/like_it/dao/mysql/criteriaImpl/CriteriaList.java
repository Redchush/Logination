package by.epam.like_it.dao.mysql.criteriaImpl;


import by.epam.like_it.dao.Criteria;
import by.epam.like_it.model.Entity;

public interface CriteriaList<T extends Entity> extends Criteria<T> {

   void add(CriteriaPart<T> criteriaPart);

}

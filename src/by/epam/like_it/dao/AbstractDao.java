package by.epam.like_it.dao;



import by.epam.like_it.dao.mysql.criteriaImpl.CriteriaList;
import by.epam.like_it.dao.exception.DaoException;
import by.epam.like_it.model.Entity;

import java.sql.Connection;
import java.util.List;


public interface AbstractDao<T extends Entity> {

    List<T> findAll() throws DaoException;

    T findEntityById(int id) throws DaoException;

    boolean delete(int id) throws DaoException;

    boolean delete(T entity) throws DaoException;

    boolean create(T entity) throws DaoException;

    T update(T entity) throws DaoException;

    void close(Connection connection) throws DaoException;

    List<T> findAllByCriteria(Criteria<T> criteria) throws DaoException;

    Criteria<T> getCriteria();
}

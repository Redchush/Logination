package by.epam.like_it.dao;


import by.epam.like_it.dao.AbstractDao;
import by.epam.like_it.dao.exception.DaoException;
import by.epam.like_it.model.Answer;
import by.epam.like_it.model.Category;

import java.util.List;

public interface CategoryDao extends AbstractDao<Category> {
    @Override
    List<Category> findAll() throws DaoException;

    @Override
    Category findEntityById(int id) throws DaoException;

    @Override
    boolean delete(int id) throws DaoException;

    @Override
    boolean delete(Category entity) throws DaoException;

    @Override
    boolean create(Category entity) throws DaoException;

    @Override
    Category update(Category entity) throws DaoException;

    @Override
    List<Category> findAllByCriteria(Criteria<Category> criteria) throws DaoException;
}

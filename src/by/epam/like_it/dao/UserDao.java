package by.epam.like_it.dao;


import by.epam.like_it.dao.AbstractDao;
import by.epam.like_it.dao.exception.DaoException;
import by.epam.like_it.model.Tag;
import by.epam.like_it.model.User;

import java.util.List;

public interface UserDao extends AbstractDao<User> {
    @Override
    List<User> findAll() throws DaoException;

    @Override
    User findEntityById(int id) throws DaoException;

    @Override
    boolean delete(int id) throws DaoException;

    @Override
    boolean delete(User entity) throws DaoException;

    @Override
    boolean create(User entity) throws DaoException;

    @Override
    User update(User entity) throws DaoException;

    @Override
    List<User> findAllByCriteria(Criteria<User> criteria) throws DaoException;
}

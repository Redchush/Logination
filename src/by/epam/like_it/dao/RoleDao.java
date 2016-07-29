package by.epam.like_it.dao;


import by.epam.like_it.dao.AbstractDao;
import by.epam.like_it.dao.exception.DaoException;
import by.epam.like_it.model.Rating;
import by.epam.like_it.model.Role;

import java.util.List;

public interface RoleDao extends AbstractDao<Role> {
    @Override
    List<Role> findAll() throws DaoException;

    @Override
    Role findEntityById(int id) throws DaoException;

    @Override
    boolean delete(int id)throws DaoException;

    @Override
    boolean delete(Role entity)throws DaoException;

    @Override
    boolean create(Role entity)throws DaoException;

    @Override
    Role update(Role entity)throws DaoException;

    @Override
    List<Role> findAllByCriteria(Criteria<Role> criteria) throws DaoException;
}

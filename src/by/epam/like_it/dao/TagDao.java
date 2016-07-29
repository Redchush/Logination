package by.epam.like_it.dao;


import by.epam.like_it.dao.AbstractDao;
import by.epam.like_it.dao.exception.DaoException;
import by.epam.like_it.model.Role;
import by.epam.like_it.model.Tag;

import java.util.List;

public interface TagDao extends AbstractDao<Tag> {
    @Override
    List<Tag> findAll() throws DaoException;

    @Override
    Tag findEntityById(int id) throws DaoException;

    @Override
    boolean delete(int id)throws DaoException;

    @Override
    boolean delete(Tag entity)throws DaoException;

    @Override
    boolean create(Tag entity)throws DaoException;

    @Override
    Tag update(Tag entity)throws DaoException;

    @Override
    List<Tag> findAllByCriteria(Criteria<Tag> criteria) throws DaoException;
}

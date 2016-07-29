package by.epam.like_it.dao;


import by.epam.like_it.dao.AbstractDao;
import by.epam.like_it.dao.exception.DaoException;
import by.epam.like_it.model.Post;
import by.epam.like_it.model.Rating;

import java.util.List;

public interface RatingDao extends AbstractDao<Rating> {

    @Override
    List<Rating> findAll() throws DaoException;

    @Override
    Rating findEntityById(int id) throws DaoException;

    @Override
    boolean delete(int id) throws DaoException;

    @Override
    boolean delete(Rating entity) throws DaoException;

    @Override
    boolean create(Rating entity) throws DaoException;

    @Override
    Rating update(Rating entity) throws DaoException;

    @Override
    List<Rating> findAllByCriteria(Criteria<Rating> criteria) throws DaoException;
}

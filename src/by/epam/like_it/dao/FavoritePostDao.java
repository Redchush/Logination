package by.epam.like_it.dao;


import by.epam.like_it.dao.AbstractDao;
import by.epam.like_it.dao.exception.DaoException;
import by.epam.like_it.model.Comment;
import by.epam.like_it.model.FavoritePost;

import java.util.List;

public interface FavoritePostDao extends AbstractDao<FavoritePost> {
    @Override
    List<FavoritePost> findAll() throws DaoException;

    @Override
    FavoritePost findEntityById(int id) throws DaoException;

    @Override
    boolean delete(int id) throws DaoException;

    @Override
    boolean delete(FavoritePost entity) throws DaoException;

    @Override
    boolean create(FavoritePost entity) throws DaoException;

    @Override
    FavoritePost update(FavoritePost entity) throws DaoException;

    @Override
    List<FavoritePost> findAllByCriteria(Criteria<FavoritePost> criteria) throws DaoException;
}

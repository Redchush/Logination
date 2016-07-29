package by.epam.like_it.dao;


import by.epam.like_it.dao.AbstractDao;
import by.epam.like_it.dao.exception.DaoException;
import by.epam.like_it.model.FavoritePost;
import by.epam.like_it.model.Post;

import java.util.List;

public interface PostDao extends AbstractDao<Post> {
    @Override
    List<Post> findAll() throws DaoException;

    @Override
    Post findEntityById(int id) throws DaoException;

    @Override
    boolean delete(int id) throws DaoException;

    @Override
    boolean delete(Post entity) throws DaoException;

    @Override
    boolean create(Post entity) throws DaoException;

    @Override
    Post update(Post entity) throws DaoException;

    @Override
    List<Post> findAllByCriteria(Criteria<Post> criteria) throws DaoException;
}

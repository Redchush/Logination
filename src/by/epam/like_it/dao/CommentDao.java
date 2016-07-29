package by.epam.like_it.dao;


import by.epam.like_it.dao.AbstractDao;
import by.epam.like_it.dao.exception.DaoException;
import by.epam.like_it.model.Category;
import by.epam.like_it.model.Comment;

import java.util.List;

/**
 * Extrating comment instance from percistanse
 */
public interface CommentDao extends AbstractDao<Comment> {

    @Override
    List<Comment> findAll() throws DaoException;

    @Override
    Comment findEntityById(int id) throws DaoException;

    @Override
    boolean delete(int id) throws DaoException;

    @Override
    boolean delete(Comment entity) throws DaoException;

    @Override
    boolean create(Comment entity) throws DaoException;

    @Override
    Comment update(Comment entity) throws DaoException;

    @Override
    List<Comment> findAllByCriteria(Criteria<Comment> criteria) throws DaoException;
}

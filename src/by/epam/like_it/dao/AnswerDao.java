package by.epam.like_it.dao;


import by.epam.like_it.dao.AbstractDao;
import by.epam.like_it.dao.exception.DaoException;
import by.epam.like_it.model.Answer;

import java.util.List;

public interface AnswerDao extends AbstractDao<Answer> {
    @Override
    List<Answer> findAll() throws DaoException;

    @Override
    Answer findEntityById(int id) throws DaoException;

    @Override
    boolean delete(int id) throws DaoException;

    @Override
    boolean delete(Answer entity) throws DaoException;

    @Override
    boolean create(Answer entity) throws DaoException;

    @Override
    Answer update(Answer entity) throws DaoException;

    @Override
    List<Answer> findAllByCriteria(Criteria<Answer> criteria) throws DaoException;
}

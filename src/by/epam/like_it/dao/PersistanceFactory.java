package by.epam.like_it.dao;


import by.epam.like_it.dao.exception.DaoException;

import java.sql.Connection;

public interface PersistanceFactory {

    AbstractDao getDaoByClass(Class clazz, Connection connection) throws DaoException;
}

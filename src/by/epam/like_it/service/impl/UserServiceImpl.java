package by.epam.like_it.service.impl;


import by.epam.like_it.commonUtil.ClassName;
import by.epam.like_it.dao.*;
import by.epam.like_it.dao.connection_pool.ConnectionPool;
import by.epam.like_it.dao.connection_pool.exception.ConnectionPoolException;
import by.epam.like_it.dao.criteria.UserCriteria;
import by.epam.like_it.dao.exception.DaoException;
import by.epam.like_it.dao.mysql.criteriaImpl.Clause;
import by.epam.like_it.model.User;
import by.epam.like_it.service.UserService;
import by.epam.like_it.service.exception.ServiceAuthException;
import by.epam.like_it.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserServiceImpl implements UserService {

	private static Logger logger = LogManager.getLogger(ClassName.getClassName());

	@Override
	public User authorise(String email, String password) throws ServiceException, ServiceAuthException {
		if(!Validation.validate(email, password)){
			throw new ServiceAuthException("Wrong parameters!");
		}
		PersistanceFactory factory = ChoosePersistanceFactory.getInstance().getPersitanseMySqlFactory();
		List<User> users = null;
		UserDao dao = null;
		Connection connection = null;
		try {
			ConnectionPool pool = ConnectionPool.getInstance();
			connection = pool.takeConnection();
			dao = (UserDao) factory.getDaoByClass(User.class, connection);
			Criteria<User> userCriteria = dao.getCriteria();
			userCriteria.add(Clause.eq(UserCriteria._$EMAIL, email));
			userCriteria.add(Clause.eq(UserCriteria._$PASSWORD, password));
			users = dao.findAllByCriteria(userCriteria);

			if( (users == null) && (users.isEmpty())){
				logger.info("Wrong email or password! : email " + email + ", password " + password);
				throw new ServiceAuthException("Wrong email or password!");
			}

		} catch (DaoException e) {
			throw new ServiceException("Error in source", e);
		} catch (ConnectionPoolException e) {
			throw new ServiceException("Error in connection", e);
		} finally {
			if (dao != null) {
				try {
					dao.close(connection);
				} catch (DaoException e) {
					throw new ServiceException("Serious error in connection", e);
				}
			}
		}
		logger.info("User find! : email " + email + ", password " + password);
		return users.get(0);
	}



	@Override
	public User register(String login, String password, String email) throws ServiceException, ServiceAuthException {
		if(!Validation.validate(email, password, login)){
			throw new ServiceAuthException("Wrong parameters!");
		}

		PersistanceFactory factory = ChoosePersistanceFactory.getInstance().getPersitanseMySqlFactory();
		List<User> users = null;
		UserDao dao = null;
		Connection connection = null;
		try {
			ConnectionPool pool = ConnectionPool.getInstance();
			connection = pool.takeConnection();
			dao = (UserDao) factory.getDaoByClass(User.class, connection);
			Criteria<User> userCriteria = dao.getCriteria();

			userCriteria.add(Clause.or(Clause.eq(UserCriteria._$EMAIL, email), Clause.eq(UserCriteria._$PASSWORD,
					password), Clause.eq(UserCriteria._$EMAIL, login)));
			users = dao.findAllByCriteria(userCriteria);

			if( (users == null) && (users.isEmpty())){
				logger.info("Have user this email, or password, or login ! : email " + email + ", password " +
						password + ",login " + login);
				throw new ServiceAuthException("Have user this email, or password, or login!");
			}

		} catch (DaoException e) {
			throw new ServiceException("Error in source", e);
		} catch (ConnectionPoolException e) {
			throw new ServiceException("Error in connection", e);
		} finally {
			if (dao != null) {
				try {
					dao.close(connection);
				} catch (DaoException e) {
					throw new ServiceException("Serious error in connection", e);
				}
			}
		}
		logger.info("User find! : email " + email + ", password " + password);
		return users.get(0);
	}



	static class Validation{
		final static String emailReg = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\" +
				".[A-Za-z]{2,})$";
		final static Pattern patternEmail = Pattern.compile(emailReg);
		final static int passwordMinLength = 6;

		private static boolean validateLogin(String login) {
			if (login==null || login.isEmpty()){
				return false;
			}
			return true;
		}

		static boolean valideateEmail(String email){
			if(email == null || email.isEmpty()){
				return false;
			}
			Matcher matcher = patternEmail.matcher(email);

			if (!matcher.matches()){
				return false;
			}
			return true;
		}

		static boolean valideatePassword(String password){
			if(password == null || password.isEmpty() || password.length() < passwordMinLength){
				return false;
			}
			return true;
		}

		static boolean validate(String email, String password){
			if ( valideatePassword(password) || valideateEmail(email)){
				return false;
			}
			return true;
		}



		static boolean validate(String email, String password, String login){
			if ( valideatePassword(password) || valideateEmail(email) || validateLogin(login)){
				return false;
			}
			return true;
		}


	}

}

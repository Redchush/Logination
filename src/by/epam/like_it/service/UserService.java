package by.epam.like_it.service;


import by.epam.like_it.model.User;
import by.epam.like_it.service.exception.ServiceAuthException;
import by.epam.like_it.service.exception.ServiceException;

public interface UserService {

    User authorise(String login, String password) throws ServiceException, ServiceAuthException;

    User register(String login, String password, String email) throws ServiceException, ServiceAuthException;
}


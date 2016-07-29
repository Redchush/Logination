package by.epam.like_it.dao.exception;


public class NoUniqueUserLoginException extends DaoException{
    public NoUniqueUserLoginException() {
    }

    public NoUniqueUserLoginException(String message) {
        super(message);
    }

    public NoUniqueUserLoginException(String message, Throwable cause) {
        super(message, cause);
    }
}

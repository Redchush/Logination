package by.epam.like_it.command.impl;

import by.epam.like_it.command.Command;
import by.epam.like_it.command.util.QueryUtil;
import by.epam.like_it.model.User;
import by.epam.like_it.service.ServiceFactory;
import by.epam.like_it.service.UserService;
import by.epam.like_it.service.exception.ServiceAuthException;
import by.epam.like_it.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Registration implements Command {
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "email";


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        String email = request.getParameter(EMAIL);

        UserService userService = ServiceFactory.getInstance().getUserService();
        String query = QueryUtil.createHttpQueryString(request);
        request.getSession(true).setAttribute("prev_query", query);

        try {
            User user = userService.register(login, password, email);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/WEB-INF/success/user.jsp").forward(request, response);

        } catch (ServiceAuthException e) {
            request.setAttribute("wrong", "true");
            request.getRequestDispatcher("signIn.jsp").forward(request, response);

        }  catch (ServiceException e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}

package by.epam.like_it.command.impl;

import by.epam.like_it.command.Command;
import by.epam.like_it.command.util.QueryUtil;
import by.epam.like_it.model.User;
import by.epam.like_it.service.ServiceFactory;
import by.epam.like_it.service.UserService;
import by.epam.like_it.service.exception.ServiceAuthException;
import by.epam.like_it.service.exception.ServiceException;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Logination implements Command {
	private static final String EMAIL = "login";
	private static final String PASSWORD = "password";
	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String login = request.getParameter(EMAIL);
		String password = request.getParameter(PASSWORD);

		UserService userService = ServiceFactory.getInstance().getUserService();

		String query = QueryUtil.createHttpQueryString(request);
		request.getSession(true).setAttribute("prev_query", query);

		
		try {
			User user = userService.authorise(login, password);
			request.setAttribute("user", user);
			request.getRequestDispatcher("/WEB-INF/success/user.jsp").forward(request, response);
		} catch (ServiceAuthException e) {
			request.setAttribute("wrong", "true");
			request.getRequestDispatcher("logIn.jsp").forward(request, response);
		}  catch (ServiceException e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
}

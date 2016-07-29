package by.epam.like_it.command.impl;


import by.epam.like_it.command.Command;
import by.epam.like_it.commonUtil.ClassName;
import org.apache.logging.log4j.LogManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ChangeLanguage implements Command {

	private static org.apache.logging.log4j.Logger logger = LogManager.getLogger(ClassName.getClassName());

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		logger.trace("Proceed to execute ChangeLanguage command");
		HttpSession session = request.getSession(true);
		String language = request.getParameter("language");
		session.setAttribute("locale", language);
		String prev_query = (String) request.getSession(false).getAttribute("prev_query");
		String returnPage = request.getParameter("return");

        if (prev_query != null) {
			response.sendRedirect(prev_query);
		} else {
			if (returnPage != null) {
				request.getRequestDispatcher(returnPage).forward(request, response);
			}
		}
		logger.trace("Change language " + language +".Redirect back to pade " + returnPage);
	}

}

package by.epam.like_it.controller;


import by.epam.like_it.command.Command;
import by.epam.like_it.commonUtil.ClassName;
import org.apache.logging.log4j.LogManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private static final String COMMAND = "command";
	private static org.apache.logging.log4j.Logger logger = LogManager.getLogger(ClassName.getClassName());


	public Controller() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commandName = request.getParameter(COMMAND);
		Command command  = CommandHelper.getInstance().getCommand(commandName);
		command.execute(request, response);
		logger.trace("Doing post by command " + commandName);
	}
}

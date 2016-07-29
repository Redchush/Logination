package by.epam.like_it.service;


import by.epam.like_it.service.impl.UserServiceImpl;

public class ServiceFactory {

	private static ServiceFactory instance;

	private ServiceFactory(){}

	public static ServiceFactory getInstance(){

		if (instance == null)
			synchronized (ServiceFactory.class){
				if (instance == null)
					instance = new ServiceFactory();
			}
		return instance;
	}

	public UserService getUserService(){
		return new UserServiceImpl();
	}

}

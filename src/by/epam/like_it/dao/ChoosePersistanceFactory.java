package by.epam.like_it.dao;


import by.epam.like_it.dao.mysql.MySqlDaoFactory;

public class ChoosePersistanceFactory {

    private static ChoosePersistanceFactory instance;

    private ChoosePersistanceFactory(){}

    public static ChoosePersistanceFactory getInstance(){

        if (instance == null)
            synchronized (ChoosePersistanceFactory.class){
                if (instance == null)
                    instance = new ChoosePersistanceFactory();
            }
        return instance;
    }

    public PersistanceFactory getPersitanseMySqlFactory(){
        return MySqlDaoFactory.getInstance();
    }
}

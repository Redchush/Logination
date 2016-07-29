package by.epam.like_it.dao.mysql.daoImpl;

import by.epam.like_it.dao.CategoryDao;
import by.epam.like_it.dao.Criteria;
import by.epam.like_it.dao.exception.DaoException;
import by.epam.like_it.dao.mysql.Bannable;
import by.epam.like_it.dao.mysql.criteriaImpl.CriteriaMySql;
import by.epam.like_it.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CategoryDaoMySql extends AbstractDaoMySql<Category>
        implements CategoryDao, Bannable {

    public CategoryDaoMySql() {
    }

    public CategoryDaoMySql(Connection connection) {
        super(connection);
    }

    @Override
    public List<Category> findAll() throws DaoException {
        return super.findAll();
    }

    @Override
    public Category findEntityById(int id) throws DaoException {
        return super.findEntityById(id);
    }

    @Override
    public boolean delete(int id) throws DaoException{
        return super.delete(id);
    }

    @Override
    public boolean delete(Category entity) throws DaoException {
        return super.delete(entity);
    }

    @Override
    public boolean create(Category entity) throws DaoException {
        return super.create(entity);
    }

    @Override
    public Category update(Category entity) throws DaoException {
        return super.update(entity);
    }

    /*
    *   use constructor  public Category(int id, String title, String description,
    *                Timestamp createdDate, Category parent, boolean published)
    */
    @Override
    protected List<Category> createEntityList(ResultSet set) throws SQLException {
        List<Category> entities = new ArrayList<>();
        while (set.next()) {
            int id = set.getInt(1);
            String title = set.getString("title");
            Timestamp createdDate = set.getTimestamp("created_date");
            String description = set.getString("description");

            int parentId = set.getInt("parent_category");
            Category parent = new Category(parentId);
            boolean isPublished = set.getBoolean("published");

            Category entity = new Category(id, title, description, createdDate, parent, isPublished);
            entities.add(entity);
        }
        return entities;
    }

    @Override
    protected void fillStatementWithFullAttributesSet(PreparedStatement statement, Category entity, int from) throws
                                                                                                     SQLException {
        String title = entity.getTitle();
        statement.setString(1, title);

        Timestamp created_date = entity.getCreatedDate();
        statement.setTimestamp(2, created_date);

        String description = entity.getDescription();
        statement.setString(3, description);

        int categoryId = entity.getParent().getId();
        statement.setInt(4, categoryId);

        boolean published = entity.isPublished();
        statement.setBoolean(5, published);
    }

    @Override
    protected Class<Category> getGenericType() {
        return Category.class;
    }

    @Override
    public Criteria<Category> getCriteria() {
        return new CriteriaMySql<Category>(Category.class);
    }

}
//
//        categories.num = 6;
//        categories.1 = id
//        categories.2 = title
//        categories.3 = created_date
//        categories.4 = description
//        categories.5 = parent_category
//        categories.6 = published

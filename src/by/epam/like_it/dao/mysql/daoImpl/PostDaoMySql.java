package by.epam.like_it.dao.mysql.daoImpl;



import by.epam.like_it.dao.Criteria;
import by.epam.like_it.dao.PostDao;
import by.epam.like_it.dao.exception.DaoException;
import by.epam.like_it.dao.mysql.Bannable;
import by.epam.like_it.dao.mysql.criteriaImpl.CriteriaMySql;
import by.epam.like_it.model.Category;
import by.epam.like_it.model.Post;
import by.epam.like_it.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PostDaoMySql extends AbstractDaoMySql<Post>
        implements PostDao, Bannable {

    public PostDaoMySql() {
    }

    public PostDaoMySql(Connection connection) {
        super(connection);
    }

    @Override
    public List<Post> findAll() throws DaoException {
      return super.findAll();
    }

    @Override
    public Post findEntityById(int id) throws DaoException {
        return super.findEntityById(id);
    }

    @Override
    public boolean delete(int id) throws DaoException {
        return super.delete(id);
    }

    @Override
    public boolean delete(Post entity) throws DaoException {
        return super.delete(entity);
    }

    @Override
    public boolean create(Post entity) throws DaoException {
        return super.create(entity);
    }

    @Override
    public Post update(Post entity) throws DaoException {
        return super.update(entity);
    }
    /*
    * public Post(int id, User author, Category parent, String title,
    *            String content, Timestamp createdDate, Timestamp updatedDate, boolean banned)
    */
    @Override
    protected List<Post> createEntityList(ResultSet set) throws SQLException {
        List<Post> entities = new ArrayList<>();
        while (set.next()) {
                int id = set.getInt(1);
                int parentUserId = set.getInt("user_id");
                User parentUser = new User(parentUserId);

                int parentCategoryId = set.getInt("category_id");
                Category parentCategory = new Category(parentCategoryId);

                String title = set.getString("title");
                String content = set.getString("content");
                Timestamp createdDate = set.getTimestamp("created_date");
                Timestamp updatedDate = set.getTimestamp("updated_date");
                boolean isBanned = set.getBoolean("banned");

                Post entity = new Post(id, parentUser, parentCategory, title, content, createdDate, updatedDate, isBanned);
                entities.add(entity);
        }
        return entities;
    }

    @Override
    protected void fillStatementWithFullAttributesSet(PreparedStatement statement, Post entity, int from)
            throws SQLException {
        int user_id = entity.getAuthor().getId();
        statement.setInt(1, user_id);

        int category_id = entity.getParent().getId();
        statement.setInt(2, category_id);

        String title = entity.getTitle();
        statement.setString(3, title);

        String content = entity.getContent();
        statement.setString(4, content);

        Timestamp created_date = entity.getCreatedDate();
        statement.setTimestamp(5, created_date);

        Timestamp updated_date = entity.getUpdatedDate();
        statement.setTimestamp(6, updated_date);

        boolean isBanned = entity.isBanned();
        statement.setBoolean(7, isBanned);

    }

    @Override
    protected Class<Post> getGenericType() {
        return Post.class;
    }


    @Override
    public Criteria<Post> getCriteria() {
        return new CriteriaMySql<Post>(Post.class);
    }


}

//
//        posts.num = 8
//        posts.1 = id
//        posts.2 = user_id
//        posts.3 = category_id
//        posts.4 = title
//        posts.5 = content
//        posts.6 = created_date
//        posts.7 = updated_date
//        posts.8 = banned


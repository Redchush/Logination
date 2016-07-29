package by.epam.like_it.dao.mysql.daoImpl;

import by.epam.like_it.dao.AnswerDao;
import by.epam.like_it.dao.Criteria;
import by.epam.like_it.dao.exception.DaoException;
import by.epam.like_it.dao.mysql.Bannable;
import by.epam.like_it.dao.mysql.criteriaImpl.CriteriaMySql;
import by.epam.like_it.model.Answer;
import by.epam.like_it.model.Post;
import by.epam.like_it.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AnswerDaoMySql extends AbstractDaoMySql<Answer> implements AnswerDao, Bannable {

    public AnswerDaoMySql() {}

    public AnswerDaoMySql(Connection connection) {
        super(connection);
    }

    @Override
    public List<Answer> findAll() throws DaoException {
        return  super.findAll();
    }

    @Override
    public Answer findEntityById(int id) throws DaoException {
        return super.findEntityById(id);
    }

    @Override
    public boolean delete(int id) throws DaoException {
        return super.delete(id);
    }

    @Override
    public boolean delete(Answer entity)  throws DaoException {
        return super.delete(entity);
    }

    @Override
    public boolean create(Answer entity) throws DaoException {
        return super.create(entity);
    }

    @Override
    public Answer update(Answer entity) throws DaoException {
         return super.update(entity);
    }

     /*
     * use constructor public Answer(int id, User author, Post parent, String content, Timestamp createdDate,
     *                   Timestamp updatedDate, boolean banned)
     *  method is called by superclass method, which contain try - catch and rethrow the exceptions in
     *  DaoException style
     */
     @Override
     protected List<Answer> createEntityList(ResultSet set) throws SQLException {
         List<Answer> entities = new ArrayList<>();
         while (set.next()) {
             int id = set.getInt(1);
             int parentUserId = set.getInt("user_id");
             User parentUser = new User(parentUserId);
             int postId = set.getInt("post_id");
             Post parentPost = new Post(postId);

             String content = set.getString("content");
             Timestamp createdDate = set.getTimestamp("created_date");
             Timestamp updatedDate = set.getTimestamp("updated_date");
             boolean isBanned = set.getBoolean("banned");

             Answer entity = new Answer(id, parentUser, parentPost, content, createdDate, updatedDate, isBanned);
             entities.add(entity);
         }
         return entities;
     }

    @Override
    protected void fillStatementWithFullAttributesSet(PreparedStatement statement, Answer entity, int from)
                                                     throws SQLException {
        int user_id = entity.getAuthor().getId();
        statement.setInt(1, user_id);
        int post_id = entity.getParent().getId();
        statement.setInt(2, post_id);

        String content = entity.getContent();
        statement.setString(3, content);

        Timestamp created_date = entity.getCreatedDate();
        statement.setTimestamp(4, created_date);
        Timestamp updated_date = entity.getUpdatedDate();
        statement.setTimestamp(5, updated_date);

        boolean isBanned = entity.isBanned();
        statement.setBoolean(6, isBanned);

    }

    @Override
    protected Class<Answer> getGenericType() {
        return Answer.class;
    }

    @Override
    public Criteria<Answer> getCriteria() {
        return new CriteriaMySql<Answer>(Answer.class);
    }

//    public void addCritera(Criteria<Answer> answer){}

//    public static void main(String[] args) {
//        new AnswerDaoMySql().addCritera(Criterion.ANSWERS$BANNED);
//    }
}

//answers.num = 7
//        answers.1 = id
//        answers.2 = user_id
//        answers.3 = post_id
//        answers.4 = content
//        answers.5 = created_date
//        answers.6 = updated_date
//        answers.7 = banned


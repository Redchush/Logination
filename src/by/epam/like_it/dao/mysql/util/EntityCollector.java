package by.epam.like_it.dao.mysql.util;




import by.epam.like_it.commonUtil.ClassName;
import by.epam.like_it.dao.mysql.criteriaImpl.CriteriaMySql;
import by.epam.like_it.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;


public class EntityCollector<T> {

    private static Logger logger = LogManager.getLogger(ClassName.getClassName());

    public List<T> ivoke(ResultSet set, CriteriaMySql criteria)
            throws ReflectiveOperationException, SQLException {

        List<String> refTables = criteria.getRefTables();
        String baseTable = criteria.getBaseTable();
        String baseClass = ResourceNavigator.getRefencedClass(baseTable);
        refTables.add(0, baseTable);
        Map<T, T> map = new HashMap<T, T>();

        while (set.next()){
            int counter = 0;
            int shift= 0;
            T main = null;
            for (String name: refTables){
                String relationTable = "";
                String clazz = ResourceNavigator.getRefencedClass(name);
                String possibleRef = ResourceNavigator.getAnotherTableByTable(baseTable, clazz);

                if (!possibleRef.isEmpty()){
                    clazz = ResourceNavigator.getRefencedClass(possibleRef);
                    relationTable=name;
                }
                Method need = methodNameConstructor(clazz);
                Object invoke = need.invoke(this, set, shift);

                if (counter == 0){
                   T temp = map.putIfAbsent((T) invoke,(T) invoke);
                   main = (temp == null) ? (T) invoke : temp;
                } else {
                    Class refClazz = invoke.getClass();
                    attachDependant((T) main, invoke, relationTable, refClazz);
                }
                int addToShift = ResourceNavigator.getAttrCount(name);
                shift+= addToShift;
                counter++;
            }
        }
        return new ArrayList<T>(map.keySet());
    }

    private <D extends Entity> void  attachDependant(Object mainObj, Object invoke, String relTable,
                                                     Class<D> refCazz)
            throws ReflectiveOperationException {

        String link = ResourceNavigator.getKeyForClassLink(mainObj.getClass(), invoke.getClass(), relTable);
        D attachment = (D) invoke;
        T main = (T) mainObj;
        if (!link.isEmpty()){
            Method method = main.getClass().getMethod(link, invoke.getClass());
            method.invoke(main, attachment);
        }
    }

    private Method methodNameConstructor(String name) throws NoSuchMethodException {

        Method result = this.getClass().getMethod(String.format("create%s", name)
                                                    , ResultSet.class, int.class);
        return result;
    }
//        Method result  = Arrays.stream(EntityCollector.class.getMethods())
//                               .filter(s -> s.getName().endsWith(name))
//                               .findFirst().get();


    public List<Answer> createAnswerList(ResultSet set) throws SQLException {
        List<Answer> entities = new ArrayList<>();
        while (set.next()) {
            Answer entity = createAnswer(set, 0);
            entities.add(entity);
        }
        return entities;
    }


    public List<Category> createCategoryList(ResultSet set) throws SQLException {
        List<Category> entities = new ArrayList<>();
        while (set.next()) {
            Category entity = createCategory(set, 0);
            entities.add(entity);
        }
        return entities;
    }

    public List<Comment> createCommentList(ResultSet set) throws SQLException {
        List<Comment> entities = new ArrayList<>();
        while (set.next()) {
            Comment entity = createComment(set, 0);
            entities.add(entity);
        }
        return entities;
    }


    public List<FavoritePost> createFavoritePostList(ResultSet set, int shift) throws SQLException {
        List<FavoritePost> entities = new ArrayList<>();
        while (set.next()) {
            FavoritePost entity = createFavoritePost(set, 0);
            entities.add(entity);
        }
        return entities;
    }


    public List<Post> createPostList(ResultSet set, int shift) throws SQLException {
        List<Post> entities = new ArrayList<>();
        while (set.next()) {
            Post entity = createPost(set, 0);
            entities.add(entity);
        }
        return entities;
    }


    public List<Rating> createRatingList(ResultSet set) throws SQLException {
        List<Rating> entities = new ArrayList<>();
        while (set.next()) {
            Rating entity = createRating(set, 0);
            entities.add(entity);
        }
        return entities;
    }


    public List<Role> createRoleList(ResultSet set) throws SQLException {
        List<Role> entities = new ArrayList<>();
        while (set.next()) {
            Role entity = createRole(set, 0);
            entities.add(entity);
        }
        return entities;
    }


    public List<Tag> createTagList(ResultSet set) throws SQLException {
        List<Tag> entities = new ArrayList<>();
        while (set.next()) {
            Tag entity = createTag(set, 0);
            entities.add(entity);
        }
        return entities;
    }

    public List<User> createUserList(ResultSet set, int shift) throws SQLException {
        List<User> entities = new ArrayList<>();
        while (set.next()) {
            User entity = createUser(set, 0);
            entities.add(entity);
        }
        return entities;
    }

    public Answer createAnswer(ResultSet set, int shift) throws SQLException {

        int id = set.getInt(1 + shift);
        int parentUserId = set.getInt("user_id");
        User parentUser = new User(parentUserId);
        int postId = set.getInt("post_id");
        Post parentPost = new Post(postId);

        String content = set.getString("content");
        Timestamp createdDate = set.getTimestamp("created_date");
        Timestamp updatedDate = set.getTimestamp("updated_date");
        boolean isBanned = set.getBoolean("banned");

        Answer entity = new Answer(id, parentUser, parentPost, content, createdDate, updatedDate, isBanned);
        return entity;
    }


    public Category createCategory(ResultSet set, int shift) throws SQLException {

        int id = set.getInt(1);
        String title = set.getString("title");
        Timestamp createdDate = set.getTimestamp("created_date");
        String description = set.getString("description");

        int parentId = set.getInt("parent_category");
        Category parent = new Category(parentId);
        boolean isPublished = set.getBoolean("published");

        Category entity = new Category(id, title, description, createdDate, parent, isPublished);
        return entity;

    }

    public Comment createComment(ResultSet set, int shift) throws SQLException {
        int id = set.getInt(1);
        int parentUserId = set.getInt("user_id");
        User parentUser = new User(parentUserId);

        int parentPostId = set.getInt("post_id");
        Answer parentAnswer = new Answer(parentPostId);

        String content = set.getString("content");
        Timestamp createdDate = set.getTimestamp("created_date");
        Timestamp updatedDate = set.getTimestamp("updated_date");
        boolean isBanned = set.getBoolean("banned");

        Comment entity = new Comment(id, parentUser, parentAnswer, content, createdDate, updatedDate, isBanned);
        return entity;
    }


    public FavoritePost createFavoritePost(ResultSet set, int shift) throws SQLException {
        int id = set.getInt("id");
        int userId = set.getInt("user_id");
        int postId = set.getInt("post_id");
        String comment = set.getString("comment");
        FavoritePost entity = new FavoritePost(id, new User(userId), new Post(postId), comment);
        return entity;
    }


    public Post createPost(ResultSet set, int shift) throws SQLException {

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
        return entity;
    }


    public Rating createRating(ResultSet set, int shift) throws SQLException {

        int id = set.getInt(1);
        int parentAnswerId = set.getInt("answer_id");
        Answer parentAnswer = new Answer(parentAnswerId);

        int raiting = set.getInt("raiting");
        int parentUserId = set.getInt("user_id");
        User parentUser = new User(parentUserId);

        Timestamp createdDate = set.getTimestamp("created_date");
        Timestamp updated_date = set.getTimestamp("updated_date");
        boolean isBanned = set.getBoolean("banned");
        Rating entity = new Rating(id, parentAnswer, parentUser, raiting, createdDate, updated_date, isBanned);
        return entity;
    }


    public Role createRole(ResultSet set, int shift) throws SQLException {
        int id = set.getInt(1 + shift);
        String name = set.getString("name");
        Role entity = new Role(id, name);
        return entity;
    }


    public Tag createTag(ResultSet set, int shift) throws SQLException {
        int id = set.getInt(1 + shift);
        String name = set.getString("name");
        Tag entity = new Tag(id, name);
        return entity;
    }


    public User createUser (ResultSet set, int shift) throws SQLException {

        int id = set.getInt(1 + shift);
        String login = set.getString("login");
        String password = set.getString("password");
        String email = set.getString("email");
        Role role = new Role(set.getInt("role_id"));
        String lastName = set.getString("last_name");
        String firstName = set.getString("first_name");
        Timestamp createdDate = set.getTimestamp("created_date");
        Timestamp updatedDate = set.getTimestamp("updated_date");
        boolean isBanned = set.getBoolean("banned");
        User entity = new User(id, role, login, password, email, lastName,
                firstName, createdDate, updatedDate, isBanned);

        return entity;
    }

}

package by.epam.like_it.dao.criteria;


import by.epam.like_it.dao.ConcreteCriteria;
import by.epam.like_it.dao.Criteria;
import by.epam.like_it.model.Post;

public enum PostCriteria implements ConcreteCriteria<Post> {

    __$BANNED, _$CATEGORY_ID, _$CONTENT, _$CREATED_DATE, _$ID, _$TITLE, _$UPDATED_DATE, _$USER_ID,

    ANSWERS$BANNED, ANSWERS$CONTENT, ANSWERS$CREATED_DATE, ANSWERS$ID, ANSWERS$POST_ID,
    ANSWERS$UPDATED_DATE, ANSWERS$USER_ID, CATEGORIES$CREATED_DATE, CATEGORIES$DESCRIPTION,
    CATEGORIES$ID, CATEGORIES$PARENT_CATEGORY, CATEGORIES$PUBLISHED, CATEGORIES$TITLE,
    FAVORITE_USERS_POSTS$COMMENT, FAVORITE_USERS_POSTS$ID, FAVORITE_USERS_POSTS$POST_ID,
    FAVORITE_USERS_POSTS$USER_ID, POSTS_TAGS$POST_ID, POSTS_TAGS$TAG_ID,
    READED_POSTS$POST_ID, READED_POSTS$USER_ID, USERS$BANNED, USERS$CREATED_DATE, USERS$EMAIL,
    USERS$FIRST_NAME, USERS$ID, USERS$LAST_NAME, USERS$LOGIN, USERS$PASSWORD, USERS$ROLE_ID,
    USERS$UPDATED_DATE,

    LIMIT;


}

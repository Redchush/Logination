package by.epam.like_it.dao.criteria;

import by.epam.like_it.dao.ConcreteCriteria;
import by.epam.like_it.dao.Criteria;
import by.epam.like_it.model.FavoritePost;


public enum FavoritePostCriteria implements ConcreteCriteria<FavoritePost> {

    POSTS$BANNED, POSTS$CATEGORY_ID, POSTS$CONTENT, POSTS$CREATED_DATE,
    POSTS$ID, POSTS$TITLE, POSTS$UPDATED_DATE, POSTS$USER_ID, USERS$BANNED,
    USERS$CREATED_DATE, USERS$EMAIL, USERS$FIRST_NAME, USERS$ID, USERS$LAST_NAME,
    USERS$LOGIN, USERS$PASSWORD, USERS$ROLE_ID, USERS$UPDATED_DATE, LIMIT,
    _$COMMENT, _$ID, _$POST_ID, _$USER_ID

}

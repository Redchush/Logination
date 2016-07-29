package by.epam.like_it.dao.criteria;


import by.epam.like_it.dao.ConcreteCriteria;
import by.epam.like_it.dao.Criteria;
import by.epam.like_it.model.Comment;

public enum CommentCriteria implements ConcreteCriteria<Comment> {


    ANSWERS$BANNED, ANSWERS$CONTENT, ANSWERS$CREATED_DATE, ANSWERS$ID,
    ANSWERS$POST_ID, ANSWERS$UPDATED_DATE, ANSWERS$USER_ID, USERS$BANNED,
    USERS$CREATED_DATE, USERS$EMAIL, USERS$FIRST_NAME, USERS$ID, USERS$LAST_NAME,
    USERS$LOGIN, USERS$PASSWORD, USERS$ROLE_ID, USERS$UPDATED_DATE, LIMIT,

    _$ANSWERS_ID, _$BANNED, _$CONTENT, _$CREATED_DATE, _$ID, _$UPDATED_DATE, _$USER_ID


}


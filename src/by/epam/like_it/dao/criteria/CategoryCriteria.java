package by.epam.like_it.dao.criteria;


import by.epam.like_it.dao.ConcreteCriteria;
import by.epam.like_it.model.Category;

public enum CategoryCriteria implements ConcreteCriteria<Category> {

    CATEGORIES_TAGS$CATEGORY_ID, CATEGORIES_TAGS$TAG_ID, POSTS$BANNED, POSTS$CATEGORY_ID,
    POSTS$CONTENT, POSTS$CREATED_DATE, POSTS$ID, POSTS$TITLE, POSTS$UPDATED_DATE,
    POSTS$USER_ID, _$CREATED_DATE, _$DESCRIPTION, LIMIT,

    _$ID, _$PARENT_CATEGORY, _$PUBLISHED, _$TITLE
}

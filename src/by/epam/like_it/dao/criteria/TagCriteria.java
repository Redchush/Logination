package by.epam.like_it.dao.criteria;
import by.epam.like_it.dao.ConcreteCriteria;
import by.epam.like_it.dao.Criteria;
import by.epam.like_it.model.Tag;

public enum TagCriteria implements ConcreteCriteria<Tag> {

    CATEGORIES_TAGS$CATEGORY_ID, CATEGORIES_TAGS$TAG_ID, FAVORITE_USER_TAGS$TAGS_ID,
    FAVORITE_USER_TAGS$USER_ID, POSTS_TAGS$POST_ID, POSTS_TAGS$TAG_ID,
    _$ID, _$NAME,
    LIMIT,

}

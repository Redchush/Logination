package by.epam.like_it.dao.mysql.criteriaImpl;


import by.epam.like_it.dao.CriteriaClause;
import by.epam.like_it.model.Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Or<T extends Entity> extends SkeletonCriteriaPart<T>  {

    private int position = ClauseConstants.DEFAULT_POSITION_LEVEL_1;
    private List<String> values;


    public Or(CriteriaClause<T> ...parts) {
        values = new ArrayList<>();
        for (CriteriaClause<T> part : parts ){
            SkeletonCriteriaPart<T> conrcete = (SkeletonCriteriaPart<T>) part;
            values.add(conrcete.getString());
        }
    }

    @Override
    public int getPosition() {
        return 0;
    }

    @Override
    public void increasePosition(int delta) {

    }

    @Override
    public Object[] getArgs() {
        return values.toArray();
    }
}

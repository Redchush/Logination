package by.epam.like_it.dao.mysql.criteriaImpl;


import by.epam.like_it.dao.Criteria;
import by.epam.like_it.model.Entity;

public class Eq<T extends Entity> extends SkeletonCriteriaPart<T> {

    private int position = ClauseConstants.DEFAULT_POSITION_LEVEL_1;
    private String value;


    public Eq(String field, String table, String value) {
        super(field, table);
        this.value = value;
    }

    @Override
    public Object[] getArgs() {
        super.args[0] = super.refTable;
        super.args[1] = super.field;
        super.args[2] = value;
        return args;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public void increasePosition(int delta) {
        position +=delta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        Eq<?> eq = (Eq<?>) o;

        if (position != eq.position) {
            return false;
        }
        return value != null ? value.equals(eq.value) : eq.value == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + position;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}

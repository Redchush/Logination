package by.epam.like_it.dao.mysql.criteriaImpl;


import by.epam.like_it.model.Entity;

public class Limit<T extends Entity> extends SkeletonCriteriaPart<T>{

    private int position = ClauseConstants.DEFAULT_POSITION_LEVEL_4;

    private int value;

    public Limit(int value) {
        this.value = value;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public void increasePosition(int delta) {
        this.position+=delta;
    }


    @Override
    public int compareTo(CriteriaPart o) {
        if (o.getClass() == this.getClass()){
           return 0;
        }
        return super.compareTo(o);
    }

    public Object[] getArgs() {
        args = new Object[1];
        args[0] = value;
        return args;
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

        Limit<?> limit = (Limit<?>) o;

        if (position != limit.position) {
            return false;
        }
        return value == limit.value;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + position;
        result = 31 * result + value;
        return result;
    }
}

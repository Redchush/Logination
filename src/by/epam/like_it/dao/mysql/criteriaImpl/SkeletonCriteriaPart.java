package by.epam.like_it.dao.mysql.criteriaImpl;




import by.epam.like_it.dao.mysql.util.ResourceManager;
import by.epam.like_it.model.Entity;

import java.util.Arrays;

public abstract class SkeletonCriteriaPart<T extends Entity> implements CriteriaPart<T> {

    protected String field;
    protected String refTable;
    protected Object[] args;

    public SkeletonCriteriaPart() {}

    public SkeletonCriteriaPart(String field){
        this.field = field;
    }

    public SkeletonCriteriaPart(String field, String table) {
        this.field = field;
        this.refTable = table;
        args = new Object[3];
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getRefTable() {
        return refTable;
    }

    @Override
    public void setRefTable(String refTable) {
        this.refTable = refTable;
    }

    @Override
    public String getString() {
        String format = ResourceManager.PARTS.getString(this.getClass().getSimpleName());
        return String.format(format, this.getArgs());
    }

    @Override
    public String getString(boolean and) {
        String format = ResourceManager.PARTS.getString(this.getClass().getSimpleName());
        return " AND " + String.format(format, this.getArgs());
    }

    @Override
    public int compareTo(CriteriaPart<T> o) {
        SkeletonCriteriaPart<T> other = (SkeletonCriteriaPart<T>) o;
        if (this.equals(other)) {
            return 0;
        }
        if (o == null) {
            return -1;
        }

        int result = this.getPosition() - other.getPosition();
        if (result == 0){
            result = o.getClass().getSimpleName().compareTo( o.getClass().getSimpleName());
            if (result == 0) {
                result = this.field.compareTo(other.field);
            }
        }
        return result;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SkeletonCriteriaPart<?> that = (SkeletonCriteriaPart<?>) o;

        if (field != null ? !field.equals(that.field) : that.field != null) {
            return false;
        }
        if (refTable != null ? !refTable.equals(that.refTable) : that.refTable != null) {
            return false;
        }
        return Arrays.equals(args, that.args);
    }

    @Override
    public int hashCode() {
        int result = field != null ? field.hashCode() : 0;
        result = 31 * result + (refTable != null ? refTable.hashCode() : 0);
        result = 31 * result + this.getPosition();
        result = 31 * result + this.getClass().hashCode();
        return result;
    }
}

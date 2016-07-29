package by.epam.like_it.dao.mysql.criteriaImpl;



import by.epam.like_it.model.Entity;

import java.util.Arrays;

public class Order<T extends Entity> extends SkeletonCriteriaPart<T>  {

   private int position = ClauseConstants.DEFAULT_POSITION_LEVEL_3;

   private Object[] args;
   private String orderType;

   public Order(String field, String table, String orderType) {
        super(field, table);
        this.orderType = orderType;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public void increasePosition(int delta) {
        position +=delta;
    }

    public Object[] getArgs() {
        args = new Object[3];
        args[0] = super.refTable;
        args[1] = field;
        args[2] = orderType;
        return args;
    }

    @Override
    public int compareTo(CriteriaPart o) {
        if (o.getClass() == this.getClass()){
            return 0;
        }
        return super.compareTo(o);
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

        Order<?> order = (Order<?>) o;

        if (position != order.position) {
            return false;
        }

        if (!Arrays.equals(args, order.args)) {
            return false;
        }
        return orderType != null ? orderType.equals(order.orderType) : order.orderType == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + position;
        result = 31 * result + Arrays.hashCode(args);
        result = 31 * result + (orderType != null ? orderType.hashCode() : 0);
        return result;
    }
}

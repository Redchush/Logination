package by.epam.like_it.dao.mysql.criteriaImpl;



import by.epam.like_it.dao.CriteriaClause;
import by.epam.like_it.dao.mysql.util.ResourceNavigator;
import by.epam.like_it.model.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;


public class CriteriaMySql<T extends Entity> implements CriteriaList<T> {

    private NavigableSet<CriteriaPart<T>> parts;
    private ArrayList<String > refTables;
    private String baseTable;
    private boolean isSimle;

    private CriteriaMySql() {
        parts = new TreeSet<>();
        refTables = new ArrayList<>();
        isSimle = true;
    }

    public CriteriaMySql(Class baseTable) {
        this();
        this.baseTable = ResourceNavigator.getReferencedTable(baseTable, false);
    }

    public String getBaseTable() {
        return baseTable;
    }

    public boolean isSimle() {
        return isSimle;
    }

    public List<String> getRefTables(){
        return refTables;
    }

    public void setRefTables(ArrayList<String> refTables) {
        this.refTables = refTables;
    }

    @Override
    public void add(CriteriaClause<T> criteria) {
         add((CriteriaPart<T>) criteria);
    }

    @Override
    public void add(CriteriaPart<T> part){

        parts.add(part);
        String refTable = part.getRefTable();
        if (refTable == null) {   //in limit statement
            return;
        }

        int classPosition = 0;
        if (refTable.equals(ResourceNavigator.THIS_CLASS_MARKER)){
            part.setRefTable(baseTable);
        } else {
            isSimle = false;
            classPosition = ClauseConstants.DELTA_CLASS * (refTables.size() + 1);
            part.increasePosition(classPosition);
            refTables.add(refTable);
        }
    }



     public String getString() {
        NavigableSet<CriteriaPart<T>> copy = new TreeSet<>(parts);
        StringBuilder result = new StringBuilder("");
        int counter = 0;
        int tableCounter = 0;
        CriteriaPart<T> current;
        while ((current = copy.pollFirst()) != null) {
            int postion = current.getPosition();

            tableCounter = postion/1000*1000;
            int temp = (postion - tableCounter) / ClauseConstants.DEFAULT_POSITION_LEVEL_1;

            if (temp == 1) {
                if (counter == 0) {
                    result.append("WHERE " + current.getString());
                } else {
                    result.append(" AND " + current.getString());
                }
            } else {
                result.append(current.getString());
            }
            counter++;
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return "CriteriaMySql{" +
                ", refTables=" + refTables +
                ", baseTable='" + baseTable + '\'' +
                ", isSimle=" + isSimle +
                ", parts=" + parts +
                '}';
    }


}

//    private StringBuilder processSimple(NavigableSet<CriteriaPart<T>> subPart) {
//        StringBuilder result = new StringBuilder("");
//
//        CriteriaPart<T> part = subPart.pollFirst();
//        if (part == null) {
//            return result;
//        }
//        if (part.getPosition() %  DEFAULT_POSITION_LEVEL_1 == 0){
//            result.append("WHERE " + part.getString());
//        }
//        CriteriaPart<T> current;
//
//        while ( (current = subPart.pollFirst()) != null){
//            int temp = current.getPosition() % DEFAULT_POSITION_LEVEL_1;
//            if (temp == 0 || temp%DELTA_CLASS == 0){
//                result.append(" AND " + current.getString());
//            } else result.append(current.getString());
//        }
//        return result;
//    }


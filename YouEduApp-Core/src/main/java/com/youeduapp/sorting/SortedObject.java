package com.youeduapp.sorting;

import java.util.Date;

/**
 *
 * @author o.villalobos.alfaro
 */
public abstract class SortedObject implements Comparable<SortedObject> {

    public enum SORTING {
        SORT_BY_NAME, SORT_BY_DATE
    }

    public enum TYPE {
        TYPE_CATEGORY, TYPE_VIDEO
    }

    private SORTING sorting = SORTING.SORT_BY_NAME;

    protected TYPE type;

    public int compareTo(SortedObject o) {
        return (sorting == SORTING.SORT_BY_DATE)
                ? getDateCreated().compareTo(o.getDateCreated())
                : getName().compareTo(o.getName());
    }

    public abstract Date getDateCreated();

    /**
     * @return the Name
     */
    public abstract String getName();

    /**
     * @return the sorting
     */
    public SORTING getSorting() {
        return sorting;
    }

    /**
     * @param sorting the sorting to set
     */
    public void setSorting(SORTING sorting) {
        this.sorting = sorting;
    }

    /**
     * @return the type
     */
    public TYPE getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(TYPE type) {
        this.type = type;
    }

}

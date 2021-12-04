package org.maktab.entity.base;

public interface BaseEntity<ID extends Number> {
    ID getId();

    void setId(ID id);
}

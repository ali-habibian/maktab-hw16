package org.maktab.entity;

public interface BaseEntity<ID extends Number> {
    ID getId();

    void setId(ID id);
}

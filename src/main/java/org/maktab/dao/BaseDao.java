package org.maktab.dao;

import org.maktab.entity.BaseEntity;

import java.util.List;

// CRUD => Create, Read, Update, Delete
public interface BaseDao<T extends BaseEntity<ID>, ID extends Number> {
    void save(T entity);
    void update(ID id, T newEntity);
    void delete(ID id);
    T loadById(ID id);
    List<T> loadAll();
}

package org.maktab.service;

import org.maktab.dao.AbstractJpaDao;
import org.maktab.entity.BaseEntity;
import org.maktab.exception.DataNotFoundException;

import java.util.List;

public class AbstractCrudService<T extends BaseEntity<ID>, ID extends Number> {
    private AbstractJpaDao<T, ID> baseDao;

    public void setBaseDao(AbstractJpaDao<T, ID> baseDao) {
        this.baseDao = baseDao;
    }

    public AbstractJpaDao<T, ID> getBaseDao() {
        return baseDao;
    }

    public void saveOrUpdate(T entity) {
        baseDao.getEntityManager().getTransaction().begin();
        if (entity.getId() == null) {
            baseDao.save(entity);
        } else {
            baseDao.update(entity.getId(), entity);
        }
        baseDao.getEntityManager().getTransaction().commit();
    }

    public void deleteById(ID id) throws DataNotFoundException {
        baseDao.getEntityManager().getTransaction().begin();
        baseDao.delete(id);
        baseDao.getEntityManager().getTransaction().commit();
    }

    public T loadById(ID id) {
        return baseDao.loadById(id);
    }

    public List<T> loadAll() {
        return baseDao.loadAll();
    }
}

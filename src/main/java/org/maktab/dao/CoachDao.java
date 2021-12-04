package org.maktab.dao;

import org.maktab.entity.Coach;

public class CoachDao extends AbstractJpaDao<Coach, Integer> {
    @Override
    public Class<Coach> getEntityClass() {
        return Coach.class;
    }
}

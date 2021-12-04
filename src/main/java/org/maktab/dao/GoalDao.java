package org.maktab.dao;

import org.maktab.entity.Goal;

public class GoalDao extends AbstractJpaDao<Goal, Integer> {
    @Override
    public Class<Goal> getEntityClass() {
        return Goal.class;
    }
}

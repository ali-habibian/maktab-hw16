package org.maktab.service;

import org.maktab.dao.GoalDao;
import org.maktab.entity.Goal;

public class GoalService extends AbstractCrudService<Goal, Integer> {
    public GoalService() {
        setBaseDao(new GoalDao());
    }

    @Override
    public GoalDao getBaseDao() {
        return (GoalDao) super.getBaseDao();
    }
}

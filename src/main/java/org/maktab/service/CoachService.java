package org.maktab.service;

import org.maktab.dao.CoachDao;
import org.maktab.entity.Coach;

import java.util.List;

public class CoachService extends AbstractCrudService<Coach, Integer> {
    public CoachService() {
        setBaseDao(new CoachDao());
    }

    public Coach getExpensiveCoach(){
        return getBaseDao().getExpensiveCoach();
    }

    @Override
    public CoachDao getBaseDao() {
        return (CoachDao) super.getBaseDao();
    }
}

package org.maktab.service;

import org.maktab.dao.AbstractJpaDao;
import org.maktab.dao.CoachDao;
import org.maktab.entity.Coach;

public class CoachService extends AbstractCrudService<Coach, Integer> {
    public CoachService() {
        setBaseDao(new CoachDao());
    }

    @Override
    public CoachDao getBaseDao() {
        return (CoachDao) super.getBaseDao();
    }
}

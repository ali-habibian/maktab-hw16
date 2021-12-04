package org.maktab.service;

import org.maktab.dao.ClubDao;
import org.maktab.entity.Club;

public class ClubService extends AbstractCrudService<Club, Integer> {
    public ClubService() {
        setBaseDao(new ClubDao());
    }

    @Override
    public ClubDao getBaseDao() {
        return (ClubDao) super.getBaseDao();
    }
}

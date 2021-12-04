package org.maktab.service;

import org.maktab.dao.AbstractJpaDao;
import org.maktab.dao.StadiumDao;
import org.maktab.entity.Stadium;

public class StadiumService extends AbstractCrudService<Stadium, Integer> {
    public StadiumService() {
        setBaseDao(new StadiumDao());
    }

    @Override
    public StadiumDao getBaseDao() {
        return (StadiumDao) super.getBaseDao();
    }
}

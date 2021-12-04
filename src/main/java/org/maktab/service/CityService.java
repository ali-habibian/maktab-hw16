package org.maktab.service;

import org.maktab.dao.AbstractJpaDao;
import org.maktab.dao.CityDao;
import org.maktab.entity.City;

public class CityService extends AbstractCrudService<City, Integer> {
    public CityService() {
        setBaseDao(new CityDao());
    }

    @Override
    public CityDao getBaseDao() {
        return (CityDao) super.getBaseDao();
    }
}

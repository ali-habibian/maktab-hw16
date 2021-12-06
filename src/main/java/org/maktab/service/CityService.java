package org.maktab.service;

import org.maktab.dao.CityDao;
import org.maktab.entity.City;

import java.util.List;

public class CityService extends AbstractCrudService<City, Integer> {
    public CityService() {
        setBaseDao(new CityDao());
    }

    @Override
    public CityDao getBaseDao() {
        return (CityDao) super.getBaseDao();
    }

}

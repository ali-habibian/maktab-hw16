package org.maktab.dao;

import org.maktab.entity.City;

public class CityDao extends AbstractJpaDao<City, Integer> {

    @Override
    public Class<City> getEntityClass() {
        return City.class;
    }
}

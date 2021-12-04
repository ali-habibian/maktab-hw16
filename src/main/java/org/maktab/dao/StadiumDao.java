package org.maktab.dao;

import org.maktab.entity.Stadium;

public class StadiumDao extends AbstractJpaDao<Stadium, Integer> {
    @Override
    public Class<Stadium> getEntityClass() {
        return Stadium.class;
    }
}

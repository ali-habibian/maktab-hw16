package org.maktab.dao;

import org.maktab.entity.Club;

public class ClubDao extends AbstractJpaDao<Club, Integer> {
    @Override
    public Class<Club> getEntityClass() {
        return Club.class;
    }
}

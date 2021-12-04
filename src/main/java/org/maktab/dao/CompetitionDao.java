package org.maktab.dao;

import org.maktab.entity.Competition;

public class CompetitionDao extends AbstractJpaDao<Competition, Integer>{
    @Override
    public Class<Competition> getEntityClass() {
        return Competition.class;
    }
}

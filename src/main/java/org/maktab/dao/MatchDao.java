package org.maktab.dao;

import org.maktab.entity.Match;

public class MatchDao extends AbstractJpaDao<Match, Integer>{
    @Override
    public Class<Match> getEntityClass() {
        return Match.class;
    }
}

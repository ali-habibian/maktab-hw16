package org.maktab.service;

import org.maktab.dao.AbstractJpaDao;
import org.maktab.dao.MatchDao;
import org.maktab.entity.Match;

public class MatchService extends AbstractCrudService<Match, Integer> {
    public MatchService() {
        setBaseDao(new MatchDao());
    }

    @Override
    public MatchDao getBaseDao() {
        return (MatchDao) super.getBaseDao();
    }
}

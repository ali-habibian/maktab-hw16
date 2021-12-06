package org.maktab.service;

import org.maktab.dao.CompetitionDao;
import org.maktab.entity.Competition;

import java.util.Map;

public class CompetitionService extends AbstractCrudService<Competition, Integer> {
    public CompetitionService() {
        setBaseDao(new CompetitionDao());
    }

    @Override
    public CompetitionDao getBaseDao() {
        return (CompetitionDao) super.getBaseDao();
    }

    public Map<String, Long> loadAllClubsPointForSeason(int season) {
        return getBaseDao().loadAllClubsPointForSeason(season);
    }
}

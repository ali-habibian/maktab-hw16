package org.maktab.dao;

import org.maktab.entity.Club;
import org.maktab.entity.Competition;
import org.maktab.utilities.MapUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.*;

public class CompetitionDao extends AbstractJpaDao<Competition, Integer> {
    @Override
    public Class<Competition> getEntityClass() {
        return Competition.class;
    }

    public Map<String, Long> loadAllClubsPointForSeason(int season) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Competition> competition = cq.from(Competition.class);
        Join<Competition, Club> club = competition.join("homeClub");
        cq.multiselect(club.get("name"), cb.sum(competition.get("homeTeamPoint")))
                .where(cb.equal(competition.get("season"), season))
                .groupBy(club.get("id"))
                .orderBy(cb.asc(club.get("id")));

        List<Object[]> resultListHome = getEntityManager().createQuery(cq).getResultList();

        CriteriaBuilder cb2 = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Object[]> cq2 = cb2.createQuery(Object[].class);
        Root<Competition> competition2 = cq2.from(Competition.class);
        Join<Competition, Club> club2 = competition2.join("awayClub");
        cq2.multiselect(club2.get("name"), cb2.sum(competition2.get("awayTeamPoint")))
                .where(cb2.equal(competition2.get("season"), season))
                .groupBy(club2.get("id"))
                .orderBy(cb2.asc(club2.get("id")));

        List<Object[]> resultListAway = getEntityManager().createQuery(cq2).getResultList();

        for (int i = 0; i < resultListHome.size(); i++) {
            long k = (Long) resultListHome.get(i)[1] + (Long) resultListAway.get(i)[1];
            resultListHome.get(i)[1] = k;
        }

        Map<String, Long> resultsMap = new HashMap<>();
        for (Object[] objects : resultListHome) {
            resultsMap.put((String) objects[0], (Long) objects[1]);
        }

        return MapUtil.sortByValue(resultsMap);
    }
}

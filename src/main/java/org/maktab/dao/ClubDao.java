package org.maktab.dao;

import org.maktab.entity.City;
import org.maktab.entity.Club;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.util.List;

public class ClubDao extends AbstractJpaDao<Club, Integer> {
    @Override
    public Class<Club> getEntityClass() {
        return Club.class;
    }

    public List<Object[]> loadAllGroupByCity() {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Club> clubRoot = cq.from(Club.class);
        Join<Club, City> clubCityJoin = clubRoot.join("city");
        cq.multiselect(clubCityJoin.get("name"), cb.count(clubCityJoin.get("id")))
                .groupBy(clubCityJoin.get("id"));

        TypedQuery<Object[]> query = getEntityManager().createQuery(cq);
        return query.getResultList();
    }
}

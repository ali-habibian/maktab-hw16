package org.maktab.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.maktab.entity.Coach;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

public class CoachDao extends AbstractJpaDao<Coach, Integer> {
    @Override
    public Class<Coach> getEntityClass() {
        return Coach.class;
    }

    public Coach getExpensiveCoach() {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Coach> q = cb.createQuery(Coach.class);
        Root<Coach> c = q.from(Coach.class);
        q.select(c).orderBy(cb.desc(c.get("salary")));

        TypedQuery<Coach> query = getEntityManager().createQuery(q);
        return query.getResultList().get(0);
    }
}

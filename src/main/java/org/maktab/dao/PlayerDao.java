package org.maktab.dao;

import org.maktab.entity.Player;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class PlayerDao extends AbstractJpaDao<Player, Integer> {
    @Override
    public Class<Player> getEntityClass() {
        return Player.class;
    }

    public Player getExpensivePlayer() {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Player> q = cb.createQuery(Player.class);
        Root<Player> c = q.from(Player.class);
        q.select(c).orderBy(cb.desc(c.get("salary")));

        TypedQuery<Player> query = getEntityManager().createQuery(q);
        return query.getResultList().get(0);
    }
}

package org.maktab.dao;

import org.maktab.entity.Player;

public class PlayerDao extends AbstractJpaDao<Player, Integer> {
    @Override
    public Class<Player> getEntityClass() {
        return Player.class;
    }
}

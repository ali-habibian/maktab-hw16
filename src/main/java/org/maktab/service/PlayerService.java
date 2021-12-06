package org.maktab.service;

import org.maktab.dao.PlayerDao;
import org.maktab.entity.Player;

public class PlayerService extends AbstractCrudService<Player, Integer> {
    public PlayerService() {
        setBaseDao(new PlayerDao());
    }

    @Override
    public PlayerDao getBaseDao() {
        return (PlayerDao) super.getBaseDao();
    }

    public Player getExpensivePlayer() {
        return getBaseDao().getExpensivePlayer();
    }
}

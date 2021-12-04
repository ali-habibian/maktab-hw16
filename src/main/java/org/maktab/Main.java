package org.maktab;

import org.maktab.dao.CityDao;
import org.maktab.entity.City;
import org.maktab.entity.PlayerRole;
import org.maktab.entity.Stadium;
import org.maktab.service.CityService;

import java.text.DecimalFormat;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.playLeagueGames(1401);

        // Add Cities
//        manager.addNewCity("Liverpool");
//        manager.addNewCity("Manchester");
//        manager.addNewCity("London");

        // Add Stadiums
//        manager.addNewStadium("Anfield", 54074, 1);
//        manager.addNewStadium("Etihad Stadium", 55017, 2);
//        manager.addNewStadium("Stamford Bridge", 40853, 3);
//        manager.addNewStadium("Old Trafford", 74879, 2);

        // Add Clubs
//        manager.addNewClub("Liverpool FC", 1, 1);
//        manager.addNewClub("Manchester City", 2, 2);
//        manager.addNewClub("Chelsea FC", 3, 3);
//        manager.addNewClub("Manchester United", 2, 4);

        // Add Coaches
//        manager.addNewCoach("Jürgen Klopp", 15000000.0, 1);
//        manager.addNewCoach("Pep Guardiola", 20000000.0, 2);
//        manager.addNewCoach("Thomas Tuchel", 8000000.0, 3);
//        manager.addNewCoach("Ralf Rangnick", 7800000.0, 4);

        // Add Player for Manchester United
        // GK
//        double rndSalary = manager.generateRndSalary(0.2, 1.2);
//        manager.addNewPlayer("#" + 1 + "ManUnited Player", PlayerRole.GK, rndSalary, 4);
//        // CD = 4
//        for (int i = 2; i < 6; i++) {
//            rndSalary = manager.generateRndSalary(0.2, 1.2);
//            manager.addNewPlayer("#" + i + "ManUnited Player", PlayerRole.CD, rndSalary, 4);
//        }
//        // CM = 4
//        for (int i = 6; i < 10; i++) {
//            rndSalary = manager.generateRndSalary(0.2, 1.2);
//            manager.addNewPlayer("#" + i + "ManUnited Player", PlayerRole.CM, rndSalary, 4);
//        }
//        // ST = 2
//        for (int i = 10; i < 12; i++) {
//            rndSalary = manager.generateRndSalary(0.2, 1.2);
//            manager.addNewPlayer("#" + i + "ManUnited Player", PlayerRole.ST, rndSalary, 4);
//        }

        // Make Competitions
    }

}

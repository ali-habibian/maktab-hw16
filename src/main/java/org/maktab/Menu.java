package org.maktab;

import org.maktab.entity.Coach;
import org.maktab.entity.Player;
import org.maktab.service.ClubService;
import org.maktab.service.CoachService;
import org.maktab.service.CompetitionService;
import org.maktab.service.PlayerService;
import org.maktab.utilities.Input;
import org.maktab.utilities.Printer;

import java.util.List;
import java.util.Map;

public class Menu {
    Manager manager = new Manager();

    public void start() {
        int command = 0;
        while (command != 6) {
            Printer.printMessage("Select one option:");
            Printer.printMessage("1. Play new league");
            Printer.printMessage("2. Show more expensive coach");
            Printer.printMessage("3. Show more expensive player");
            Printer.printMessage("4. Show cities with clubs count");
            Printer.printMessage("5. Show league table");
            Printer.printMessage("6. Exit");

            command = Input.getIntInputValue("");

            switch (command) {
                case 1 -> playNewLeague();
                case 2 -> showMoreExpensiveCoach();
                case 3 -> showMoreExpensivePlayer();
                case 4 -> showCitiesWithClubsCount();
                case 5 -> showLeagueTable();
                default -> throw new IllegalStateException("Unexpected value: " + command);
            }
        }
    }

    private void playNewLeague() {
        int season = Input.getIntInputValue("Enter season:");
        manager.playLeagueGames(season);
        Printer.printMessage("Season " + season + " is done.");
    }

    private void showMoreExpensiveCoach() {
        CoachService coachService = new CoachService();
        Coach expensiveCoach = coachService.getExpensiveCoach();
        Printer.printResultMessage(expensiveCoach.toString());
    }

    private void showMoreExpensivePlayer() {
        PlayerService playerService = new PlayerService();
        Player expensivePlayer = playerService.getExpensivePlayer();
        Printer.printResultMessage(expensivePlayer.toString());
    }

    private void showCitiesWithClubsCount() {
        ClubService clubService = new ClubService();
        List<Object[]> resultList = clubService.loadAllGroupByCity();
        resultList.forEach(object -> Printer.printResultMessage("City: " + object[0] + "\t Teams Count: " + object[1]));
    }

    private void showLeagueTable() {
        int season = Input.getIntInputValue("Enter season:");
        CompetitionService competitionService = new CompetitionService();
        Map<String, Long> resultMap = competitionService.loadAllClubsPointForSeason(season);
        resultMap.forEach((r, b) -> System.out.println(r + " ".repeat(17 - r.length() + 5) + b));
    }
}

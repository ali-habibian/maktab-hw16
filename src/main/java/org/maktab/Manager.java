package org.maktab;

import org.maktab.entity.*;
import org.maktab.service.*;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Manager {
    private final CityService cityService = new CityService();
    private final StadiumService stadiumService = new StadiumService();
    private final ClubService clubService = new ClubService();
    private final CoachService coachService = new CoachService();
    private final PlayerService playerService = new PlayerService();
    private final CompetitionService competitionService = new CompetitionService();
    private final GoalService goalService = new GoalService();

    public void addNewCity(String cityName) {
        City city = new City();
        city.setName(cityName);

        cityService.saveOrUpdate(city);
    }

    public void addNewStadium(String stadiumName, Integer capacity, Integer cityId) {
        Stadium stadium = new Stadium();
        stadium.setName(stadiumName);
        stadium.setCapacity(capacity);

        City city = cityService.loadById(cityId);
        stadium.setCity(city);

        stadiumService.saveOrUpdate(stadium);
    }

    public void addNewClub(String clubName, Integer cityId, Integer stadiumId) {
        Club club = new Club();
        club.setName(clubName);

        City city = cityService.loadById(cityId);
        club.setCity(city);

        Stadium stadium = stadiumService.loadById(stadiumId);
        club.setStadium(stadium);

        clubService.saveOrUpdate(club);
    }

    public void addNewCoach(String coachName, Double salary, Integer clubId) {
        Coach coach = new Coach();
        coach.setName(coachName);
        coach.setSalary(salary);

        Club club = clubService.loadById(clubId);
        coach.setClub(club);

        coachService.saveOrUpdate(coach);
    }

    public void addNewPlayer(String playerName, PlayerRole role, Double salary, Integer clubId) {
        Player player = new Player();
        player.setName(playerName);
        player.setRole(role);
        player.setSalary(salary);

        Club club = clubService.loadById(clubId);
        player.setClub(club);

        playerService.saveOrUpdate(player);
    }

    public double generateRndSalary(double start, double end) {
        Random random = new Random();
        double rndDouble = random.nextDouble(start, end);
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(rndDouble)) * 100000000.0;
    }

    private void makeCompetition(Integer homeClubId, Integer awayClubId, Integer season) {
        Competition competition = new Competition();
        competition.setSeason(season);

        Club homeClub = clubService.loadById(homeClubId);
        Club awayClub = clubService.loadById(awayClubId);
        competition.setHomeClub(homeClub);
        competition.setAwayClub(awayClub);

        competitionService.saveOrUpdate(competition);

        // Players that can score goal
        List<Player> homeClubPlayers = homeClub.getPlayers().stream()
                .filter(player -> player.getRole() != PlayerRole.GK && player.getRole() != PlayerRole.CD)
                .toList();

        List<Player> awayClubPlayers = awayClub.getPlayers().stream()
                .filter(player -> player.getRole() != PlayerRole.GK && player.getRole() != PlayerRole.CD)
                .toList();

        Random random = new Random();
        int homeClubGoals = random.nextInt(0, 6);
        int awayClubGoals = random.nextInt(0, 6);

        generateGoal(competition, random, homeClubGoals, homeClubPlayers, season);
        generateGoal(competition, random, awayClubGoals, awayClubPlayers, season);

        if (homeClubGoals > awayClubGoals) {
            competition.setHomeTeamPoint(3);
            competition.setAwayTeamPoint(0);
        } else if (homeClubGoals == awayClubGoals) {
            competition.setHomeTeamPoint(1);
            competition.setAwayTeamPoint(1);
        } else {
            competition.setHomeTeamPoint(0);
            competition.setAwayTeamPoint(3);
        }

        competitionService.saveOrUpdate(competition);
    }

    private void generateGoal(Competition competition, Random random, int goals, List<Player> players, Integer season) {
        for (int i = 0; i < goals; i++) {
            Goal goal = new Goal();
            goal.setSeason(season);
            goal.setMatch(competition);

            int indexOfPlayerScoredGoal = random.nextInt(6);
            goal.setPlayer(players.get(indexOfPlayerScoredGoal));

            goal.setClub(players.get(indexOfPlayerScoredGoal).getClub());

            goalService.saveOrUpdate(goal);
        }
    }

    public void playLeagueGames(Integer season) {
        makeCompetition(1, 2, season);
        makeCompetition(1, 3, season);
        makeCompetition(1, 4, season);

        makeCompetition(2, 1, season);
        makeCompetition(2, 3, season);
        makeCompetition(2, 4, season);

        makeCompetition(3, 1, season);
        makeCompetition(3, 2, season);
        makeCompetition(3, 4, season);

        makeCompetition(4, 1, season);
        makeCompetition(4, 2, season);
        makeCompetition(4, 3, season);
    }
}

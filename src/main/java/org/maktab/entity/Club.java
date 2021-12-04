package org.maktab.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Club implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private City city;

    @OneToOne(cascade = CascadeType.ALL)
    private Stadium stadium;

    @OneToOne(mappedBy = "club", cascade = CascadeType.ALL)
    private Coach coach;

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
    private Set<Player> players;

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
    private Set<Goal> goals;

    @OneToMany(mappedBy = "homeClub", cascade = CascadeType.ALL)
    private Set<Match> homeMatches;

    @OneToMany(mappedBy = "awayClub", cascade = CascadeType.ALL)
    private Set<Match> awayMatches;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public Set<Goal> getGoals() {
        return goals;
    }

    public void setGoals(Set<Goal> goals) {
        this.goals = goals;
    }

    public Set<Match> getHomeMatches() {
        return homeMatches;
    }

    public void setHomeMatches(Set<Match> homeMatches) {
        this.homeMatches = homeMatches;
    }

    public Set<Match> getAwayMatches() {
        return awayMatches;
    }

    public void setAwayMatches(Set<Match> awayMatches) {
        this.awayMatches = awayMatches;
    }
}

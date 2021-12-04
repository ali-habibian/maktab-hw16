package org.maktab.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Competition implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Club homeClub;

    @ManyToOne(cascade = CascadeType.ALL)
    private Club awayClub;

    private Integer homeTeamPoint;
    private Integer awayTeamPoint;
    private Integer season;

    @OneToMany(mappedBy = "competition", cascade = CascadeType.ALL)
    private Set<Goal> goals;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Club getHomeClub() {
        return homeClub;
    }

    public void setHomeClub(Club homeClub) {
        this.homeClub = homeClub;
    }

    public Club getAwayClub() {
        return awayClub;
    }

    public void setAwayClub(Club awayClub) {
        this.awayClub = awayClub;
    }

    public Integer getHomeTeamPoint() {
        return homeTeamPoint;
    }

    public void setHomeTeamPoint(Integer homeTeamPoint) {
        this.homeTeamPoint = homeTeamPoint;
    }

    public Integer getAwayTeamPoint() {
        return awayTeamPoint;
    }

    public void setAwayTeamPoint(Integer awayTeamPoint) {
        this.awayTeamPoint = awayTeamPoint;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Set<Goal> getGoals() {
        return goals;
    }

    public void setGoals(Set<Goal> goals) {
        this.goals = goals;
    }
}

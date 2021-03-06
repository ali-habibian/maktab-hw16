package org.maktab.entity;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.util.Set;

@Entity
public class Player implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private PlayerRole role;
    private Double salary;

    @ManyToOne(cascade = CascadeType.ALL)
    private Club club;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private Set<Goal> goals;

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

    public PlayerRole getRole() {
        return role;
    }

    public void setRole(PlayerRole role) {
        this.role = role;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Set<Goal> getGoals() {
        return goals;
    }

    public void setGoals(Set<Goal> goals) {
        this.goals = goals;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", salary=" + DecimalFormat.getInstance().format(salary) +
                ", club=" + club.getName() +
                '}';
    }
}

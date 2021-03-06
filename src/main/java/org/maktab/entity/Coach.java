package org.maktab.entity;

import javax.persistence.*;
import java.text.DecimalFormat;

@Entity
public class Coach implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double salary;

    @OneToOne(cascade = CascadeType.ALL)
    private Club club;

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

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat();

        return "Coach{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + format.format(salary) +
                ", club=" + club.getName() +
                '}';
    }
}

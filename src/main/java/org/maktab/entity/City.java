package org.maktab.entity;

import org.maktab.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class City implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private Set<Stadium> stadiums;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private Set<Club> clubs;

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

    public Set<Stadium> getStadiums() {
        return stadiums;
    }

    public void setStadiums(Set<Stadium> stadiums) {
        this.stadiums = stadiums;
    }

    public Set<Club> getClubs() {
        return clubs;
    }

    public void setClubs(Set<Club> clubs) {
        this.clubs = clubs;
    }
}

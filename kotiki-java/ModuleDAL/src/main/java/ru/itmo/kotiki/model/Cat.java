package ru.itmo.kotiki.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cats")
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "birth_date")
    private Date birthDate;
    private Species species;
    private Color color;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private CatOwner owner;
    @OneToMany(targetEntity = Cat.class)
    private List<Cat> catFriends;

    public Cat() {
    }

    public Cat(String name, Date birthDate, Species species, Color color) {
        this.name = name;
        this.birthDate = birthDate;
        this.species = species;
        this.color = color;
        catFriends = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public CatOwner getOwner() {
        return owner;
    }

    public void setOwner(CatOwner owner) {
        this.owner = owner;
    }

    public List<Cat> getCatFriends() {
        return catFriends;
    }

    public void setCatFriends(List<Cat> catFriends) {
        this.catFriends = catFriends;
    }
}

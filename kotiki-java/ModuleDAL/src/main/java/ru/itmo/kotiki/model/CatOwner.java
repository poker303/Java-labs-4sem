package ru.itmo.kotiki.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owners")
public class CatOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "birth_date")
    private Date birthDate;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Cat> cats;

    public CatOwner() {
    }

    public CatOwner(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        cats = new ArrayList<>();
    }

    public void addCat(Cat cat) {
        if (!cats.contains(cat)) {
            cat.setOwner(this);
            cats.add(cat);
        }
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

    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }
}


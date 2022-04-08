package ru.itmo.kotiki.webModel;

import ru.itmo.kotiki.model.Color;
import ru.itmo.kotiki.model.Species;
import java.sql.Date;


public class CatWeb {
    private String name;
    private Date birthDate;
    private Species species;
    private Color color;

    public CatWeb(String name, Date birthDate, Species species, Color color) {

        this.name = name;
        this.birthDate = birthDate;
        this.species = species;
        this.color = color;
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
}

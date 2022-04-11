package ru.itmo.kotiki.DTO;

import ru.itmo.kotiki.model.Color;
import ru.itmo.kotiki.model.Species;

import java.sql.Date;


public final class CatDto {
    private final String name;
    private final Date birthDate;
    private final Species species;
    private final Color color;

    public CatDto(String name, Date birthDate, Species species, Color color) {
        this.name = name;
        this.birthDate = birthDate;
        this.species = species;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Species getSpecies() {
        return species;
    }

    public Color getColor() {
        return color;
    }

}

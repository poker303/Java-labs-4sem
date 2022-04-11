package ru.itmo.kotiki.DTO;

import java.sql.Date;


public final class CatOwnerDto {
    private final String name;
    private final Date birthDate;

    public CatOwnerDto(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }
}

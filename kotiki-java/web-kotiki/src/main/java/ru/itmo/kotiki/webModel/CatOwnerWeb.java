package ru.itmo.kotiki.webModel;

import java.sql.Date;


public class CatOwnerWeb {

    private String name;
    private Date birthDate;

    public CatOwnerWeb() {
    }

    public CatOwnerWeb(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
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
}

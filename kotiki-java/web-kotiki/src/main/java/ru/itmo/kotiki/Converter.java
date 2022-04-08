package ru.itmo.kotiki;

import ru.itmo.kotiki.model.Cat;
import ru.itmo.kotiki.model.CatOwner;
import ru.itmo.kotiki.webModel.CatOwnerWeb;
import ru.itmo.kotiki.webModel.CatWeb;

public class Converter {
    public Converter(){}

    public Cat convertCat(CatWeb catWeb){
        return new Cat(catWeb.getName(), catWeb.getBirthDate(), catWeb.getSpecies(), catWeb.getColor());
    }

    public CatOwner convertCatOwner(CatOwnerWeb catOwnerWeb){
        return new CatOwner(catOwnerWeb.getName(), catOwnerWeb.getBirthDate());
    }
}

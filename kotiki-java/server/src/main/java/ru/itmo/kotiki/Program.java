package ru.itmo.kotiki;

import ru.itmo.kotiki.model.Cat;
import ru.itmo.kotiki.model.CatOwner;
import ru.itmo.kotiki.model.Color;
import ru.itmo.kotiki.model.Species;
import ru.itmo.kotiki.service.CatOwnerServiceImpl;
import ru.itmo.kotiki.service.CatServiceImpl;

import java.sql.Date;


public class Program {
    public static void main(String[] args) {

        CatServiceImpl catServiceImpl = new CatServiceImpl();
        CatOwnerServiceImpl catOwnerServiceImpl = new CatOwnerServiceImpl();

        var catOwner1 = new CatOwner("Masha", new Date(2000000000));
        catOwnerServiceImpl.saveCatOwner(catOwner1);

        Cat cat1 = new Cat("Slava", new Date(1000000000), Species.EGYPT, Color.BLACK);
        Cat cat2 = new Cat("Ykraine", new Date(10000000), Species.RUSSIAN, Color.BLUE);

        catOwner1.addCat(cat1);
        catOwner1.addCat(cat2);

        catOwnerServiceImpl.updateCatOwner(catOwner1);

        var catOwner2 = new CatOwner("Vladimir", Date.valueOf("2002-05-17"));
        catOwnerServiceImpl.saveCatOwner(catOwner2);

        Cat cat3 = new Cat("Barsik", Date.valueOf("2010-10-02"), Species.RUSSIAN, Color.GREEN);
        Cat cat4 = new Cat("Kisa", Date.valueOf("2011-08-19"), Species.ITALIAN, Color.RED);

        catOwner2.addCat(cat3);
        catOwner2.addCat(cat4);

        catOwnerServiceImpl.updateCatOwner(catOwner2);

        catServiceImpl.deleteCat(cat1);
        Cat cat5 = new Cat("Leon", new Date(60000000), Species.SLAVA, Color.YELLOW);
        catServiceImpl.saveCat(cat5);
    }
}

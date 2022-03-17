package ru.itmo.kotiki;

import ru.itmo.kotiki.model.Cat;
import ru.itmo.kotiki.model.CatOwner;
import ru.itmo.kotiki.model.Color;
import ru.itmo.kotiki.model.Species;
import ru.itmo.kotiki.service.CatOwnerService;
import ru.itmo.kotiki.service.CatService;

import java.sql.Date;


public class Program {
    public static void main(String[] args) {

        CatService catService = new CatService();
        CatOwnerService catOwnerService = new CatOwnerService();

        var catOwner1 = new CatOwner("Masha", new Date(2000000000));
        catOwnerService.saveCatOwner(catOwner1);

        Cat cat1 = new Cat("Slava", new Date(1000000000), Species.egypt, Color.black);
        Cat cat2 = new Cat("Ykraine", new Date(10000000), Species.russian, Color.blue);

        catOwner1.addCat(cat1);
        catOwner1.addCat(cat2);

        catOwnerService.updateCatOwner(catOwner1);

        var catOwner2 = new CatOwner("Vladimir", new Date(1000000000));
        catOwnerService.saveCatOwner(catOwner2);

        Cat cat3 = new Cat("Barsik", new Date(40000000), Species.russian, Color.green);
        Cat cat4 = new Cat("Kisa", new Date(50000000), Species.italian, Color.red);

        catOwner2.addCat(cat3);
        catOwner2.addCat(cat4);

        catOwnerService.updateCatOwner(catOwner2);

        catService.deleteCat(cat1);
        Cat cat5 = new Cat("Leon", new Date(60000000), Species.slava, Color.yellow);
        catService.saveCat(cat5);
    }
}

package ru.itmo.kotiki.interfaces;

import ru.itmo.kotiki.model.Cat;

import java.util.List;

public interface CatInterface {
    Cat findCat(int id);

    void saveCat(Cat cat);

    void deleteCat(Cat cat);

    void updateCat(Cat cat);

    List<Cat> findAllCats();
}

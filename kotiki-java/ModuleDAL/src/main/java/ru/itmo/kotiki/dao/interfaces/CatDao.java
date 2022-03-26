package ru.itmo.kotiki.dao.interfaces;

import ru.itmo.kotiki.model.Cat;

import java.util.List;

public interface CatDao {
    Cat findById(int id);

    void save(Cat cat);

    void update(Cat cat);

    void delete(Cat cat);

    List<Cat> findAllCats();
}

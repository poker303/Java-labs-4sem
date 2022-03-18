package ru.itmo.kotiki.service;

import ru.itmo.kotiki.dao.implementations.CatDaoImplement;
import ru.itmo.kotiki.dao.interfaces.CatDao;
import ru.itmo.kotiki.model.Cat;

import java.util.List;

public class CatService {

    private final CatDao catDao = new CatDaoImplement();

    public Cat findCat(int id) {
        return catDao.findById(id);
    }

    public void saveCat(Cat cat) {
        catDao.save(cat);
    }

    public void deleteCat(Cat cat) {
        catDao.delete(cat);
    }

    public void updateCat(Cat cat) {
        catDao.update(cat);
    }

    public List<Cat> findAllCats() {
        return catDao.findAllCats();
    }

}

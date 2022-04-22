package ru.itmo.kotiki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.kotiki.dao.CatDao;
import ru.itmo.kotiki.interfaces.CatService;
import ru.itmo.kotiki.model.Cat;

import java.util.List;

@Service
public class CatServiceImpl implements CatService {

    @Autowired
    private CatDao catDao;

    public Cat findCat(int id) {
        return catDao.getById(id);
    }

    public void saveCat(Cat cat) {
        catDao.save(cat);
    }

    public void deleteCat(Cat cat) {
        catDao.delete(cat);
    }

    public void updateCat(Cat cat) {
        catDao.save(cat);
    }

    public List<Cat> findAllCats() {
        return catDao.findAll();
    }

}

package ru.itmo.kotiki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.kotiki.dao.interfaces.CatOwnerDao;
import ru.itmo.kotiki.model.CatOwner;

import java.util.List;

@Service
public class CatOwnerService {

    @Autowired
    private CatOwnerDao catOwnerDao;

    public CatOwner findCatOwner(int id) {
        return catOwnerDao.getById(id);
    }

    public void saveCatOwner(CatOwner catOwner) {
        catOwnerDao.save(catOwner);
    }

    public void deleteCatOwner(CatOwner catOwner) {
        catOwnerDao.delete(catOwner);
    }

    public void updateCatOwner(CatOwner catOwner) {
        catOwnerDao.save(catOwner);
    }

    public List<CatOwner> findAllOwners() {
        return catOwnerDao.findAll();
    }

}

package ru.itmo.kotiki.service;

import ru.itmo.kotiki.DAO.implementations.CatOwnerDaoImplement;
import ru.itmo.kotiki.DAO.interfaces.CatOwnerDao;
import ru.itmo.kotiki.model.Cat;
import ru.itmo.kotiki.model.CatOwner;

import java.util.List;

public class CatOwnerService {

    private final CatOwnerDao catOwnerDao = new CatOwnerDaoImplement();

    public CatOwner findCatOwner(int id) {
        return catOwnerDao.findById(id);
    }

    public void saveCatOwner(CatOwner catOwner) {
        catOwnerDao.save(catOwner);
    }

    public void deleteCatOwner(CatOwner catOwner) {
        catOwnerDao.delete(catOwner);
    }

    public void updateCatOwner(CatOwner catOwner) {
        catOwnerDao.update(catOwner);
    }

    public Cat findCatById(int id) {
        return catOwnerDao.findCatById(id);
    }

    public List<CatOwner> findAllOwners() {
        return catOwnerDao.findAllCatsOwners();
    }

}

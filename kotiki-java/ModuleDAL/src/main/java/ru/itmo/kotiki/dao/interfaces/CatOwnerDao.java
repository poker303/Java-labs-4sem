package ru.itmo.kotiki.dao.interfaces;

import ru.itmo.kotiki.model.Cat;
import ru.itmo.kotiki.model.CatOwner;

import java.util.List;

public interface CatOwnerDao {
    CatOwner findById(int id);

    void save(CatOwner catOwner);

    void update(CatOwner catOwner);

    void delete(CatOwner catOwner);

    Cat findCatById(int id);

    List<CatOwner> findAllCatsOwners();
}

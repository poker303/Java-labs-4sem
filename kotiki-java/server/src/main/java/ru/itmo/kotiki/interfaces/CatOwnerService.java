package ru.itmo.kotiki.interfaces;

import ru.itmo.kotiki.model.CatOwner;

import java.util.List;

public interface CatOwnerService {
    CatOwner findCatOwner(int id);

    void saveCatOwner(CatOwner catOwner);

    void deleteCatOwner(CatOwner catOwner);

    List<CatOwner> findAllOwners();
}

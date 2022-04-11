package ru.itmo.kotiki.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.kotiki.model.CatOwner;

@Repository
public interface CatOwnerDao extends JpaRepository<CatOwner, Integer> {
}

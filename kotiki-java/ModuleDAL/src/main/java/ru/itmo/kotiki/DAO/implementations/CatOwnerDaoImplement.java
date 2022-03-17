package ru.itmo.kotiki.DAO.implementations;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.itmo.kotiki.DAO.interfaces.CatOwnerDao;
import ru.itmo.kotiki.model.Cat;
import ru.itmo.kotiki.model.CatOwner;
import ru.itmo.kotiki.util.HibernateSessionFactoryUtil;

import java.util.List;

public class CatOwnerDaoImplement implements CatOwnerDao {

    public CatOwner findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        var catOwner = session.get(CatOwner.class, id);
        session.close();
        return catOwner;
    }

    public void save(CatOwner catOwner) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction bT = session.beginTransaction();
        session.save(catOwner);
        bT.commit();
        session.close();
    }

    public void update(CatOwner catOwner) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction bT = session.beginTransaction();
        session.update(catOwner);
        bT.commit();
        session.close();
    }

    public void delete(CatOwner catOwner) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction bT = session.beginTransaction();
        session.delete(catOwner);
        bT.commit();
        session.close();
    }

    public Cat findCatById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        var cat = session.get(Cat.class, id);
        session.close();
        return cat;
    }

    public List<CatOwner> findAllCatsOwners() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<CatOwner> owners = (List<CatOwner>) session.createQuery("From CatOwner").list();
        session.close();
        return owners;
    }
}

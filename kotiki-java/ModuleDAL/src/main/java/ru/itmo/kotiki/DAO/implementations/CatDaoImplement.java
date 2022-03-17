package ru.itmo.kotiki.DAO.implementations;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.itmo.kotiki.DAO.interfaces.CatDao;
import ru.itmo.kotiki.model.Cat;
import ru.itmo.kotiki.util.HibernateSessionFactoryUtil;

import java.util.List;

public class CatDaoImplement implements CatDao {

    public Cat findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        var cat = session.get(Cat.class, id);
        session.close();
        return cat;
    }

    public void save(Cat cat) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction bT = session.beginTransaction();
        session.save(cat);
        bT.commit();
        session.close();
    }

    public void update(Cat cat) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction bT = session.beginTransaction();
        session.update(cat);
        bT.commit();
        session.close();
    }

    public void delete(Cat cat) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction bT = session.beginTransaction();
        session.delete(cat);
        bT.commit();
        session.close();
    }

    public List<Cat> findAllCats() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Cat> cats = (List<Cat>) session.createQuery("From Cat").list();
        session.close();
        return cats;
    }
}

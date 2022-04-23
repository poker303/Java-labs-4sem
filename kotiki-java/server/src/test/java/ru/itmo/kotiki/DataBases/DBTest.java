package ru.itmo.kotiki.DataBases;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;
import ru.itmo.kotiki.model.Cat;
import ru.itmo.kotiki.model.CatOwner;
import ru.itmo.kotiki.model.Color;
import ru.itmo.kotiki.model.Species;
import ru.itmo.kotiki.service.CatOwnerServiceImpl;
import ru.itmo.kotiki.service.CatServiceImpl;

import java.sql.Date;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class DBTest {
    private Session session;
    private CatOwnerServiceImpl catOwnerServiceImpl;
    private CatServiceImpl catServiceImpl;

    @Before
    public void setup() {
        session = mock(Session.class);
        catOwnerServiceImpl = mock(CatOwnerServiceImpl.class);
        catServiceImpl = mock(CatServiceImpl.class);
    }

    @Test
    public void findByIdTest() {

        var catOwner = new CatOwner("Masha", new Date(2000000000));
        Cat cat = new Cat("Barsik", Date.valueOf("2010-10-02"), Species.RUSSIAN, Color.GREEN);
        catOwner.addCat(cat);

        when(catOwnerServiceImpl.findCatOwner(1)).thenReturn(catOwner);
        when(catServiceImpl.findCat(1)).thenReturn(cat);

        assertEquals("Masha", catOwnerServiceImpl.findCatOwner(1).getName());
        assertEquals("Barsik", catServiceImpl.findCat(1).getName());

    }

    @Test
    public void findAllTest() {

        var catOwner = new CatOwner("Masha", Date.valueOf("1990-07-19"));
        Cat cat1 = new Cat("Barsik", Date.valueOf("2010-10-02"), Species.RUSSIAN, Color.GREEN);
        Cat cat2 = new Cat("Kisa", Date.valueOf("2011-08-19"), Species.ITALIAN, Color.RED);

        catOwner.addCat(cat1);
        catOwner.addCat(cat2);

        when(catOwnerServiceImpl.findCatOwner(1)).thenReturn(catOwner);
        when(catServiceImpl.findCat(1)).thenReturn(cat1);
        when(catServiceImpl.findCat(2)).thenReturn(cat2);

        assertEquals("Masha", catOwnerServiceImpl.findCatOwner(1).getName());
        assertEquals("Barsik", catServiceImpl.findCat(1).getName());
        assertEquals("Kisa", catServiceImpl.findCat(2).getName());

        var testOwners = new ArrayList<CatOwner>();
        testOwners.add(catOwner);

        var testCats = new ArrayList<Cat>();
        testCats.add(cat1);
        testCats.add(cat2);

        when(catOwnerServiceImpl.findAllOwners()).thenReturn(testOwners);
        when(catServiceImpl.findAllCats()).thenReturn(testCats);

        assertEquals(1, testOwners.size());
        assertEquals(2, testCats.size());
    }

}

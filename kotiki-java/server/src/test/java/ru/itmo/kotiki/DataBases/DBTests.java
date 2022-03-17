package ru.itmo.kotiki.DataBases;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;
import ru.itmo.kotiki.model.Cat;
import ru.itmo.kotiki.model.CatOwner;
import ru.itmo.kotiki.model.Color;
import ru.itmo.kotiki.model.Species;
import ru.itmo.kotiki.service.CatOwnerService;
import ru.itmo.kotiki.service.CatService;

import java.sql.Date;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class DBTests {
    private Session session;
    private CatOwnerService catOwnerService;
    private CatService catService;

    @Before
    public void setup() {
        session = mock(Session.class);
        catOwnerService = mock(CatOwnerService.class);
        catService = mock(CatService.class);
    }

    @Test
    public void findByIdTest() {

        var catOwner = new CatOwner("Masha", new Date(2000000000));
        Cat cat = new Cat("Barsik", new Date(40000000), Species.russian, Color.green);
        catOwner.addCat(cat);

        when(catOwnerService.findCatOwner(1)).thenReturn(catOwner);
        when(catService.findCat(1)).thenReturn(cat);

        assertEquals("Masha", catOwnerService.findCatOwner(1).getName());
        assertEquals("Barsik", catService.findCat(1).getName());

    }

    @Test
    public void findCatByIdTest() {

        var catOwner = new CatOwner("Masha", new Date(2000000000));
        Cat cat = new Cat("Barsik", new Date(40000000), Species.russian, Color.green);
        catOwner.addCat(cat);

        when(catOwnerService.findCatById(1)).thenReturn(cat);

        assertEquals("Barsik", catOwnerService.findCatById(1).getName());
        assertEquals("Masha", catOwnerService.findCatById(1).getOwner().getName());
    }

    @Test
    public void findAllTest() {

        var catOwner = new CatOwner("Masha", new Date(2000000000));
        Cat cat1 = new Cat("Barsik", new Date(40000000), Species.russian, Color.green);
        Cat cat2 = new Cat("Kisa", new Date(50000000), Species.italian, Color.red);

        catOwner.addCat(cat1);
        catOwner.addCat(cat2);

        when(catOwnerService.findCatOwner(1)).thenReturn(catOwner);
        when(catService.findCat(1)).thenReturn(cat1);
        when(catService.findCat(2)).thenReturn(cat2);

        assertEquals("Masha", catOwnerService.findCatOwner(1).getName());
        assertEquals("Barsik", catService.findCat(1).getName());
        assertEquals("Kisa", catService.findCat(2).getName());

        var testOwners = new ArrayList<CatOwner>();
        testOwners.add(catOwner);

        var testCats = new ArrayList<Cat>();
        testCats.add(cat1);
        testCats.add(cat2);

        when(catOwnerService.findAllOwners()).thenReturn(testOwners);
        when(catService.findAllCats()).thenReturn(testCats);

        assertEquals(1, testOwners.size());
        assertEquals(2, testCats.size());
    }

}

package ru.itmo.kotiki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.kotiki.Converter;
import ru.itmo.kotiki.DTO.CatDto;
import ru.itmo.kotiki.model.Cat;
import ru.itmo.kotiki.model.Color;
import ru.itmo.kotiki.service.CatServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/cats")
public class CatController {

    @Autowired
    private final Converter converter = new Converter();
    @Autowired
    private CatServiceImpl catService;

    @GetMapping("/get/{id}")
    public CatDto getCatById(@PathVariable int id) {
        Cat cat = catService.findCat(id);
        return converter.convertToDtoCat(cat);
    }

    @GetMapping("/all")
    public List<CatDto> getCats() {
        List<Cat> cats = catService.findAllCats();
        List<CatDto> dtoCats = new ArrayList<>();

        for (Cat cat : cats) {
            dtoCats.add(converter.convertToDtoCat(cat));
        }
        return dtoCats;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCat(@RequestBody CatDto catDto) {
        Cat cat = converter.convertToCat(catDto);
        catService.saveCat(cat);
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @PutMapping("/update/{id}")
    public void updateCat(@PathVariable int id, String name, Color color) {
        Cat cat = catService.findCat(id);

        if (!Objects.equals(cat, new Cat())) {
            cat.setName(name);
            cat.setColor(color);
            catService.saveCat(cat);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCat(@PathVariable int id) {
        catService.deleteCat(catService.findCat(id));
    }
}


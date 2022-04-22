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

@RestController
@RequestMapping("/cats")
public class CatController {

    @Autowired
    private final Converter converter = new Converter();
    @Autowired
    private CatServiceImpl catServiceImpl;

    @GetMapping("/{id}")
    public CatDto getCatById(@PathVariable int id) {
        return converter.convertToDtoCat(catServiceImpl.findCat(id));
    }

    @GetMapping("/all")
    public List<CatDto> getCats() {
        List<CatDto> catsDto = new ArrayList<>();
        for (Cat cat : catServiceImpl.findAllCats()) {
            catsDto.add(converter.convertToDtoCat(cat));
        }
        return catsDto;
    }

    @PostMapping("/addCat")
    public ResponseEntity<?> addCat(@RequestBody CatDto catDto) {
        Cat cat = converter.convertToCat(catDto);
        catServiceImpl.saveCat(cat);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public void updateCat(@PathVariable int id, String name, Color color) {
        Cat cat = catServiceImpl.findCat(id);
        cat.setName(name);
        cat.setColor(color);
        catServiceImpl.saveCat(cat);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCat(@PathVariable int id) {
        catServiceImpl.deleteCat(catServiceImpl.findCat(id));
    }
}
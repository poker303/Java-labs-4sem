package ru.itmo.kotiki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.itmo.kotiki.Converter;
import ru.itmo.kotiki.DTO.CatDto;
import ru.itmo.kotiki.interfaces.CatService;
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
    private CatService catService = new CatServiceImpl();

    @GetMapping("/get/{id}")
    public CatDto getCatById(@PathVariable int id) {
        Cat cat = catService.findCat(id);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();

        if (cat.getOwner() != null && Objects.equals(cat.getOwner().getName(), username) || username.equals("admin")) {
            return converter.convertToDtoCat(cat);
        }

        return new CatDto();
    }

    @GetMapping("/all")
    public List<CatDto> getCats() {
        List<CatDto> catsDto = new ArrayList<>();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        for (Cat cat : catService.findAllCats()) {
            if (username.equals("admin") || cat.getOwner() != null && Objects.equals(cat.getOwner().getName(), username)) {
                catsDto.add(converter.convertToDtoCat(cat));
            }
        }
        return catsDto;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCat(@RequestBody CatDto catDto) {
        Cat cat = converter.convertToCat(catDto);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();

        if (username.equals("admin")) {
            catService.saveCat(cat);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @PutMapping("/update/{id}")
    public void updateCat(@PathVariable int id, String name, Color color) {
        Cat cat = catService.findCat(id);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();

        if (cat.getOwner() != null && Objects.equals(cat.getOwner().getName(), username) || username.equals("admin")) {
            cat.setName(name);
            cat.setColor(color);
            catService.saveCat(cat);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCat(@PathVariable int id) {
        Cat cat = catService.findCat(id);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        if (username.equals("admin")) {
            catService.deleteCat(cat);
        }
    }
}

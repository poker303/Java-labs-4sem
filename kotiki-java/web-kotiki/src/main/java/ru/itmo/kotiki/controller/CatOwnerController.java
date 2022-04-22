package ru.itmo.kotiki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.kotiki.Converter;
import ru.itmo.kotiki.DTO.CatOwnerDto;
import ru.itmo.kotiki.model.CatOwner;
import ru.itmo.kotiki.service.CatOwnerServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/owners")
public class CatOwnerController {

    @Autowired
    private final Converter converter = new Converter();
    @Autowired
    private CatOwnerServiceImpl catOwnerServiceImpl;

    @GetMapping("/{id}")
    public CatOwnerDto getCatOwnerById(@PathVariable int id) {
        return converter.convertToDtoCatOwner(catOwnerServiceImpl.findCatOwner(id));
    }

    @GetMapping("/all")
    public List<CatOwnerDto> getOwners() {
        List<CatOwnerDto> ownersDto = new ArrayList<>();
        for (CatOwner catOwner : catOwnerServiceImpl.findAllOwners()) {
            ownersDto.add(converter.convertToDtoCatOwner(catOwner));
        }
        return ownersDto;
    }

    @PostMapping("/addOwner")
    public ResponseEntity<?> addOwner(@RequestBody CatOwnerDto catOwnerDto) {
        CatOwner catOwner = converter.convertToCatOwner(catOwnerDto);
        catOwnerServiceImpl.saveCatOwner(catOwner);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public void updateOwner(@PathVariable int id, String name) {
        CatOwner catOwner = catOwnerServiceImpl.findCatOwner(id);
        catOwner.setName(name);
        catOwnerServiceImpl.saveCatOwner(catOwner);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOwner(@PathVariable int id) {
        catOwnerServiceImpl.deleteCatOwner(catOwnerServiceImpl.findCatOwner(id));
    }
}

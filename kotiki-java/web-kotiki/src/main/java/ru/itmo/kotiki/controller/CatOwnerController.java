package ru.itmo.kotiki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.kotiki.Converter;
import ru.itmo.kotiki.model.CatOwner;
import ru.itmo.kotiki.service.CatOwnerService;
import ru.itmo.kotiki.webModel.CatOwnerWeb;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class CatOwnerController {

    @Autowired
    private CatOwnerService catOwnerService;
    private final Converter converter = new Converter();

    @GetMapping("/{id}")
    public ResponseEntity<CatOwner> getCatOwnerById(@PathVariable int id) {
        return new ResponseEntity<>(catOwnerService.findCatOwner(id), HttpStatus.OK);
    }

    @PostMapping("/save/owner")
    public ResponseEntity<?> saveCatOwner(@RequestBody CatOwnerWeb catOwnerWeb)
    {
        catOwnerService.saveCatOwner(converter.convertCatOwner(catOwnerWeb));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/owner")
    public ResponseEntity<?> deleteCatOwner(@RequestBody CatOwnerWeb catOwnerWeb) {
        catOwnerService.deleteCatOwner(converter.convertCatOwner(catOwnerWeb));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/owner")
    public ResponseEntity<?> updateCatOwner(@RequestBody CatOwnerWeb catOwnerWeb) {
        catOwnerService.updateCatOwner(converter.convertCatOwner(catOwnerWeb));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<List<CatOwner>> findAllOwners() {
        return new ResponseEntity<>(catOwnerService.findAllOwners(), HttpStatus.OK);
    }
}

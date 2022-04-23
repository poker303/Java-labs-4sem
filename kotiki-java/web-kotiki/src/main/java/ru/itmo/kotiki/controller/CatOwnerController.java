package ru.itmo.kotiki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.kotiki.Converter;
import ru.itmo.kotiki.DTO.CatOwnerDto;
import ru.itmo.kotiki.interfaces.CatOwnerService;
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
    private CatOwnerService catOwnerService = new CatOwnerServiceImpl();

    @GetMapping("/{id}")
    public CatOwnerDto getCatOwnerById(@PathVariable int id) {
        return converter.convertToDtoCatOwner(catOwnerService.findCatOwner(id));
    }

    @GetMapping("/all")
    public List<CatOwnerDto> getOwners() {
        List<CatOwnerDto> ownersDto = new ArrayList<>();
        for (CatOwner catOwner : catOwnerService.findAllOwners()) {
            ownersDto.add(converter.convertToDtoCatOwner(catOwner));
        }
        return ownersDto;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addOwner(@RequestBody CatOwnerDto catOwnerDto) {
        CatOwner catOwner = converter.convertToCatOwner(catOwnerDto);
        catOwnerService.saveCatOwner(catOwner);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public void updateOwner(@PathVariable int id, String name) {
        CatOwner catOwner = catOwnerService.findCatOwner(id);
        catOwner.setName(name);
        catOwnerService.saveCatOwner(catOwner);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOwner(@PathVariable int id) {
        catOwnerService.deleteCatOwner(catOwnerService.findCatOwner(id));
    }
}

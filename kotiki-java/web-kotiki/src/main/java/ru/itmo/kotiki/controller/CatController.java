package ru.itmo.kotiki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.kotiki.Converter;
import ru.itmo.kotiki.model.Cat;
import ru.itmo.kotiki.service.CatService;
import ru.itmo.kotiki.webModel.CatWeb;

import java.util.List;

@RestController
@RequestMapping("/cats")
public class CatController {

        @Autowired
        private CatService catService;
        private final Converter converter = new Converter();

        @GetMapping("/{id}")
        public ResponseEntity<Cat> getCatById(@PathVariable int id) {
            return new ResponseEntity<>(catService.findCat(id), HttpStatus.OK);
        }

        @PostMapping("/save/cat")
        public ResponseEntity<?> saveCat(@RequestBody CatWeb catWeb)
        {
            catService.saveCat(converter.convertCat(catWeb));
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @DeleteMapping("/delete/cat")
        public ResponseEntity<?> deleteCat(@RequestBody CatWeb catWeb) {
            catService.deleteCat(converter.convertCat(catWeb));
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @PutMapping("/update/cat")
        public ResponseEntity<?> updateCat(@RequestBody CatWeb catWeb) {
            catService.updateCat(converter.convertCat(catWeb));
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @GetMapping("all")
        public ResponseEntity<List<Cat>> findAllCats() {
            return new ResponseEntity<>(catService.findAllCats(), HttpStatus.OK);
        }
}

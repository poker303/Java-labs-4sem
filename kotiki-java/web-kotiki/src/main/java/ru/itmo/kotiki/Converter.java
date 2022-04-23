package ru.itmo.kotiki;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itmo.kotiki.DTO.CatDto;
import ru.itmo.kotiki.DTO.CatOwnerDto;
import ru.itmo.kotiki.model.Cat;
import ru.itmo.kotiki.model.CatOwner;

@Component
public class Converter {

    @Autowired
    public Converter() {
    }

    public Cat convertToCat(CatDto catDto) {
        return new Cat(catDto.getName(), catDto.getBirthDate(), catDto.getSpecies(), catDto.getColor());
    }

    public CatOwner convertToCatOwner(CatOwnerDto catOwnerDto) {
        return new CatOwner(catOwnerDto.getName(), catOwnerDto.getBirthDate());
    }

    public CatDto convertToDtoCat(Cat cat) {
        return new CatDto(cat.getName(), cat.getBirthDate(), cat.getSpecies(), cat.getColor());
    }

    public CatOwnerDto convertToDtoCatOwner(CatOwner catOwner) {
        return new CatOwnerDto(catOwner.getName(), catOwner.getBirthDate());
    }
}

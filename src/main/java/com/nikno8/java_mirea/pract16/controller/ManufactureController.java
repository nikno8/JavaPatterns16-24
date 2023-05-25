package com.nikno8.java_mirea.pract16.controller;

import com.nikno8.java_mirea.pract16.entity.Manufacture;
import com.nikno8.java_mirea.pract16.entity.Phone;
import com.nikno8.java_mirea.pract16.repository.ManufactureRepository;
import com.nikno8.java_mirea.pract16.service.PhoneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManufactureController {
    private final ManufactureRepository repository;
    @Autowired
    PhoneServiceImpl repository1;

    public ManufactureController(ManufactureRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/manufacture/{manuId}")
    public Manufacture getManufacture(@PathVariable("manuId") Long id) {
        return repository.findById(id).get();
    }

    @GetMapping("/phone/pract17")
    public List<Phone> getPhones(){
        return repository1.getFilterPhone();
    }
}

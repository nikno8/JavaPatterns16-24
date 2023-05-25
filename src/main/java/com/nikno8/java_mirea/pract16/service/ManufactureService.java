package com.nikno8.java_mirea.pract16.service;

import com.nikno8.java_mirea.pract16.entity.Manufacture;
import com.nikno8.java_mirea.pract16.repository.ManufactureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
public class ManufactureService {
    @Autowired
    ManufactureRepository repository;

    public void setRepository(ManufactureRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Manufacture getManu(Long id){
        log.info("get Manufacture with id= {}",id);
        return repository.findById(id).get();
    }
}

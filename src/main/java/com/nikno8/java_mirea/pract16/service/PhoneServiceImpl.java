package com.nikno8.java_mirea.pract16.service;

import com.nikno8.java_mirea.pract16.entity.Phone;
import com.nikno8.java_mirea.pract16.repository.PhoneRepository;
import com.nikno8.java_mirea.pract16.entity.Manufacture;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class PhoneServiceImpl implements PhoneService{
    @Autowired
    PhoneRepository repository;
    @Autowired
    EntityManagerFactory entityManagerFactory;
    @Override
    @Transactional(readOnly = true)
    public Manufacture getManufactureByPhone(Long phoneId) {
        return repository.findById(phoneId).get().getManufacture();
    }
    @Transactional(readOnly = true)
    public List<Phone> getFilterPhone(){
        log.info("get Filter phones");
        EntityManager manager = entityManagerFactory.createEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder(); // билдер запроса
        CriteriaQuery<Phone> phoneCriteriaQuery = builder.createQuery(Phone.class); // сам запрос
        Root<Phone> root = phoneCriteriaQuery.from(Phone.class); // сущность запроса
        phoneCriteriaQuery.select(root).where(builder.notEqual(root.get("manufacture"),1));
        TypedQuery<Phone> query = manager.createQuery(phoneCriteriaQuery);
        return query.getResultList();
    }
    @Transactional
    public void setPhone(Phone phone){
        repository.save(phone);
    }
}

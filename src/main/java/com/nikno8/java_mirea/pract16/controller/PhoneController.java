package com.nikno8.java_mirea.pract16.controller;

import com.nikno8.java_mirea.pract16.entity.Phone;
import com.nikno8.java_mirea.pract16.repository.PhoneRepository;
import com.nikno8.java_mirea.pract16.service.PhoneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PhoneController {
    @Autowired
    PhoneServiceImpl repository;

    @Autowired
    PhoneRepository rep;

    @GetMapping("/phone/{phoneId}/manufacture")
    public String getPhonesMethod(@PathVariable("phoneId") Long id , Model model){
        model.addAttribute("manu", repository.getManufactureByPhone(id));

        return "manufacture";
    }
    @GetMapping("/phone/{phoneId}")
    @ResponseBody
    public Phone getPhoneMethod(@PathVariable("phoneId") Long id){

        return rep.findById(id).get();
    }
    @PostMapping("/phone")
    @ResponseBody
    public Phone setPhoneMethod(@RequestBody Phone phone){
        repository.setPhone(phone);
        return phone;
    }


}

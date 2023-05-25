package com.nikno8.java_mirea.pract16.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "manufacture_16")
@Getter
@Setter
@NoArgsConstructor
public class Manufacture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;
    @OneToMany(mappedBy = "manufacture")
    private List<Phone> phones;

}

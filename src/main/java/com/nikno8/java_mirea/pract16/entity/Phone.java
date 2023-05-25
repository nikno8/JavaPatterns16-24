package com.nikno8.java_mirea.pract16.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "phone_16")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "creation_year")
    private String creationYear;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Manufacture manufacture;
}

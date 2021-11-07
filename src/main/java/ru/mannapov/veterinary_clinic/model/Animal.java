package ru.mannapov.veterinary_clinic.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
}

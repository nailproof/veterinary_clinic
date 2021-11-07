package ru.mannapov.veterinary_clinic.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Vaccination")
public class Vaccination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double price;
}

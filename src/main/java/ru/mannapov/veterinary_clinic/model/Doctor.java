package ru.mannapov.veterinary_clinic.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
}

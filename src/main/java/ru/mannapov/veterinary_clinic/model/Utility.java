package ru.mannapov.veterinary_clinic.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Utility")
public class Utility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "animals_id")
    private int animal_id;
    @Column(name = "owners_id")
    private int owner_id;
    @Column(name = "doctors_id")
    private int doctor_id;
    @Column(name = "vaccinations_id")
    private int vaccination_id;
    private String date;
}

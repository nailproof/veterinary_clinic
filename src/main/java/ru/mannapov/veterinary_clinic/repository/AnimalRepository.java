package ru.mannapov.veterinary_clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mannapov.veterinary_clinic.model.Animal;


public interface AnimalRepository extends JpaRepository<Animal, Long> {
}

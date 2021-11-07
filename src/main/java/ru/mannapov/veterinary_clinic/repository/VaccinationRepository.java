package ru.mannapov.veterinary_clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mannapov.veterinary_clinic.model.Vaccination;

public interface VaccinationRepository extends JpaRepository<Vaccination, Long> {
}

package ru.mannapov.veterinary_clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mannapov.veterinary_clinic.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}

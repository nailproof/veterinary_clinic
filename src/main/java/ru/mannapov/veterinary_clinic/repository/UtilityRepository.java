package ru.mannapov.veterinary_clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mannapov.veterinary_clinic.model.Utility;

public interface UtilityRepository extends JpaRepository<Utility, Long> {
}

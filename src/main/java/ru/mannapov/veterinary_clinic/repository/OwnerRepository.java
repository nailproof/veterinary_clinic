package ru.mannapov.veterinary_clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mannapov.veterinary_clinic.model.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}

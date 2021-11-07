package ru.mannapov.veterinary_clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mannapov.veterinary_clinic.model.Vaccination;
import ru.mannapov.veterinary_clinic.repository.VaccinationRepository;

import java.util.List;

@Service
public class VaccinationService {
    private final VaccinationRepository vaccinationRepository;

    @Autowired
    public VaccinationService(VaccinationRepository vaccinationRepository) {
        this.vaccinationRepository = vaccinationRepository;
    }

    public Vaccination findById(Long id) {
        return vaccinationRepository.getById(id);
    }

    public List<Vaccination> findAll() {
        return vaccinationRepository.findAll();
    }

    public Vaccination saveVaccination(Vaccination vaccination) {
        return vaccinationRepository.save(vaccination);
    }

    public void deleteById(Long id) {
        vaccinationRepository.deleteById(id);
    }
}


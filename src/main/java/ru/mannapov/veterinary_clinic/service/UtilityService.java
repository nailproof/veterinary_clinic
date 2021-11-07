package ru.mannapov.veterinary_clinic.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mannapov.veterinary_clinic.model.Utility;
import ru.mannapov.veterinary_clinic.repository.UtilityRepository;

import java.util.List;

@Service
public class UtilityService {

    private final UtilityRepository utilityRepository;

    @Autowired
    public UtilityService(UtilityRepository utilityRepository) {
        this.utilityRepository = utilityRepository;
    }

    public Utility findById(Long id) {
        return utilityRepository.getById(id);
    }

    public List<Utility> findAll() {
        return utilityRepository.findAll();
    }

    public Utility saveUtility(Utility utility) {
        return utilityRepository.save(utility);
    }

    public void deleteById(Long id) {
        utilityRepository.deleteById(id);
    }
}


package ru.mannapov.veterinary_clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mannapov.veterinary_clinic.model.Doctor;
import ru.mannapov.veterinary_clinic.repository.DoctorRepository;

import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor findById(Long id){
        return doctorRepository.getById(id);
    }

    public List<Doctor> findAll(){
        return doctorRepository.findAll();
    }

    public Doctor saveDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public void deleteById(Long id){
        doctorRepository.deleteById(id);
    }
}


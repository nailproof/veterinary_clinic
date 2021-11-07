package ru.mannapov.veterinary_clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mannapov.veterinary_clinic.model.Animal;
import ru.mannapov.veterinary_clinic.repository.AnimalRepository;

import java.util.List;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal findById(Long id){
        return animalRepository.getById(id);
    }

    public List<Animal> findAll(){
        return animalRepository.findAll();
    }

    public Animal saveAnimal(Animal animal){
        return animalRepository.save(animal);
    }

    public void deleteById(Long id){
        animalRepository.deleteById(id);
    }
}


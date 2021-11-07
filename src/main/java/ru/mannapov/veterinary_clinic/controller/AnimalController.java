package ru.mannapov.veterinary_clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mannapov.veterinary_clinic.model.Animal;
import ru.mannapov.veterinary_clinic.service.AnimalService;

import java.util.List;

@Controller
@RequestMapping("/animals")
public class AnimalController {
    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/list")
    public String findAll(Model model) {
        List<Animal> animals = animalService.findAll();
        model.addAttribute("animals", animals);
        return "/animal-list";
    }

    @GetMapping("/create")
    public String createAnimalForm(Animal animal) {
        return "animal-create";
    }

    @PostMapping("/create")
    public String animalCreate(Animal animal) {
        animalService.saveAnimal(animal);
        return "redirect:/animals/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteAnimal(@PathVariable("id") Long id) {
        animalService.deleteById(id);
        return "redirect:/animals/list";
    }

    @GetMapping("/update/{id}")
    public String animalUpdateForm(@PathVariable("id") Long id, Model model) {
        Animal animal = animalService.findById(id);
        model.addAttribute("animal", animal);
        return "animal-update";
    }

    @PostMapping("/update")
    public String animalUpdate(Animal animal) {
        animalService.saveAnimal(animal);
        return "redirect:/animals/list";
    }
}

package ru.mannapov.veterinary_clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.mannapov.veterinary_clinic.model.*;
import ru.mannapov.veterinary_clinic.service.*;

import java.util.List;

@Controller
public class MainController {
    private final UtilityService utilityService;
    private final AnimalService animalService;
    private final OwnerService ownerService;
    private final DoctorService doctorService;
    private final VaccinationService vaccinationService;

    @Autowired
    public MainController(UtilityService utilityService, AnimalService animalService, OwnerService ownerService,
                          DoctorService doctorService, VaccinationService vaccinationService) {
        this.utilityService = utilityService;
        this.animalService = animalService;
        this.ownerService = ownerService;
        this.doctorService = doctorService;
        this.vaccinationService = vaccinationService;

    }

    @GetMapping("/main")
    public String showAll(Model model, Model model1, Model model2, Model model3, Model model4) {
        List<Animal> animals = animalService.findAll();
        model.addAttribute("animals", animals);
        List<Owner> owners = ownerService.findAll();
        model1.addAttribute("owners", owners);
        List<Doctor> doctors = doctorService.findAll();
        model2.addAttribute("doctors", doctors);
        List<Utility> utilities = utilityService.findAll();
        model3.addAttribute("utilities", utilities);
        List<Vaccination> vaccinations = vaccinationService.findAll();
        model4.addAttribute("vaccinations", vaccinations);
        return ("main");
    }
}

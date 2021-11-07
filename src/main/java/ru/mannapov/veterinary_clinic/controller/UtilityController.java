package ru.mannapov.veterinary_clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mannapov.veterinary_clinic.model.Utility;
import ru.mannapov.veterinary_clinic.service.UtilityService;
import ru.mannapov.veterinary_clinic.model.Animal;
import ru.mannapov.veterinary_clinic.service.AnimalService;
import ru.mannapov.veterinary_clinic.model.Doctor;
import ru.mannapov.veterinary_clinic.model.Owner;
import ru.mannapov.veterinary_clinic.model.Vaccination;
import ru.mannapov.veterinary_clinic.service.OwnerService;
import ru.mannapov.veterinary_clinic.service.DoctorService;
import ru.mannapov.veterinary_clinic.service.VaccinationService;

import java.util.List;

@Controller
@RequestMapping("/utilities")
public class UtilityController {
    private final UtilityService utilityService;
    private final AnimalService animalService;
    private final OwnerService ownerService;
    private final DoctorService doctorService;
    private final VaccinationService vaccinationService;

    @Autowired
    public UtilityController(UtilityService utilityService, AnimalService animalService, OwnerService ownerService,
                             DoctorService doctorService, VaccinationService vaccinationService) {
        this.utilityService = utilityService;
        this.animalService = animalService;
        this.ownerService = ownerService;
        this.doctorService = doctorService;
        this.vaccinationService = vaccinationService;

    }

    @GetMapping("/list")
    public String findAll(Model model) {
        List<Utility> utilities = utilityService.findAll();
        model.addAttribute("utilities", utilities);
        return "utility-list";
    }

    @GetMapping("/create")
    public String utilityCreateForm(Utility utility, Model model, Model model1, Model model2, Model model3) {
        List<Animal> animals = animalService.findAll();
        model.addAttribute("animals", animals);
        List<Owner> owners = ownerService.findAll();
        model1.addAttribute("owners", owners);
        List<Doctor> doctors = doctorService.findAll();
        model2.addAttribute("doctors", doctors);
        List<Vaccination> vaccinations = vaccinationService.findAll();
        model3.addAttribute("vaccinations", vaccinations);
        return "utility-create";
    }

    @PostMapping("/create")
    public String utilityCreate(Utility utility) {
        utilityService.saveUtility(utility);
        return "redirect:/utilities/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteUtility(@PathVariable("id") Long id) {
        utilityService.deleteById( id);
        return "redirect:/utilities/list";
    }

}

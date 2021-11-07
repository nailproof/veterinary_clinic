package ru.mannapov.veterinary_clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mannapov.veterinary_clinic.model.Vaccination;
import ru.mannapov.veterinary_clinic.service.VaccinationService;

import java.util.List;

@Controller
@RequestMapping("/vaccinations")
public class VaccinationController {
    private final VaccinationService vaccinationService;

    @Autowired
    public VaccinationController(VaccinationService vaccinationService) {
        this.vaccinationService = vaccinationService;
    }

    @GetMapping("/list")
    public String findAll(Model model) {
        List<Vaccination> vaccinations = vaccinationService.findAll();
        model.addAttribute("vaccinations", vaccinations);
        return "vaccination-list";
    }

    @GetMapping("/create")
    public String createVaccinationForm(Vaccination vaccination) {
        return "vaccination-create";
    }

    @PostMapping("/create")
    public String createVaccination(Vaccination vaccination) {
        vaccinationService.saveVaccination(vaccination);
        return "redirect:/vaccinations/list";
    }

    @GetMapping("/delete/{id}")
    public String vaccinationDelete(@PathVariable("id") Long id) {
        vaccinationService.deleteById(id);
        return "redirect:/vaccinations/list";
    }

    @GetMapping("/update/{id}")
    public String updateVaccinationForm(@PathVariable("id") Long id, Model model) {
        Vaccination vaccination = vaccinationService.findById(id);
        model.addAttribute("vaccination", vaccination);
        return "vaccination-update";
    }

    @PostMapping("/update")
    public String vaccinationUpdate(Vaccination vaccination) {
        vaccinationService.saveVaccination(vaccination);
        return "redirect:/vaccinations/list";
    }
}

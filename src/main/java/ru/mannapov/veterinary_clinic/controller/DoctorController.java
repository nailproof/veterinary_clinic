package ru.mannapov.veterinary_clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mannapov.veterinary_clinic.model.Doctor;
import ru.mannapov.veterinary_clinic.service.DoctorService;

import java.util.List;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/list")
    public String findAll(Model model) {
        List<Doctor> doctors = doctorService.findAll();
        model.addAttribute("doctors", doctors);
        return "/doctor-list";
    }

    @GetMapping("/create")
    public String createDoctorForm(Doctor doctor) {
        return "doctor-create";
    }

    @PostMapping("/create")
    public String createDoctor(Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "redirect:/doctors/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable("id") Long id) {
        doctorService.deleteById(id);
        return "redirect:/doctors/list";
    }

    @GetMapping("/update/{id}")
    public String doctorUpdateForm(@PathVariable("id") Long id, Model model) {
        Doctor doctor = doctorService.findById(id);
        model.addAttribute("doctor", doctor);
        return "doctor-update";
    }

    @PostMapping("/update")
    public String updateDoctor(Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "redirect:/doctors/list";
    }
}

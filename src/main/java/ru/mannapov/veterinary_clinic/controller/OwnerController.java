package ru.mannapov.veterinary_clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mannapov.veterinary_clinic.model.Owner;
import ru.mannapov.veterinary_clinic.service.OwnerService;

import java.util.List;

@Controller
@RequestMapping("/owners")
public class OwnerController {
    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/list")
    public String findAll(Model model) {
        List<Owner> owners = ownerService.findAll();
        model.addAttribute("owners", owners);
        return "owner-list";
    }

    @GetMapping("/create")
    public String createOwnerForm(Owner owner) {
        return "owner-create";
    }

    @PostMapping("/create")
    public String createOwner(Owner owner) {
        ownerService.saveOwner(owner);
        return "redirect:/owners/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteOwner(@PathVariable("id") Long id) {
        ownerService.deleteById(id);
        return "redirect:/owners/list";
    }

    @GetMapping("/update/{id}")
    public String updateOwnerForm(@PathVariable("id") Long id, Model model) {
        Owner owner = ownerService.findById(id);
        model.addAttribute("owner", owner);
        return "owner-update";
    }

    @PostMapping("/update")
    public String ownerUpdate(Owner owner) {
        ownerService.saveOwner(owner);
        return "redirect:/owners/list";
    }
}

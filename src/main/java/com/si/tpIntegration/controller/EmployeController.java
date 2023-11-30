package com.si.tpIntegration.controller;

import com.si.tpIntegration.entite.Employe;
import com.si.tpIntegration.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeController {
    @Autowired
    private EmployeService employeService;

    @GetMapping("/employes")
    public List<Employe> getAllEmployees() {
        return employeService.getAllEmployees();
    }

    @GetMapping("/employes/{id}")
    public Employe getOneEmployee(@PathVariable int id) {
        return employeService.getOneEmployee(id);
    }

    @PostMapping("/employes")
    public Employe saveEmploye(@RequestBody Employe employe){
        return employeService.saveEmploye(employe);
    }

    @DeleteMapping("/employes/{id}")
    public void deleteEmploye(@PathVariable int id){
        employeService.deleteEmploye(id);
    }

    @PutMapping("/employes/{id}")
    public Employe saveEmploye(@PathVariable int id,@RequestBody Employe employe){
        employe.setId(id);
        return employeService.saveEmploye(employe);
    }

    @GetMapping("/employes/sexe/{sexe}")
    public List<Employe> getAllEmployeBySex(@PathVariable String sexe){
        return employeService.getAllEmployeBySex(sexe);
    }

    @GetMapping("/employes/age/{id}")
    public String getEmployeAge(@PathVariable int id){
        return employeService.getEmployeAge(id);
    }

}

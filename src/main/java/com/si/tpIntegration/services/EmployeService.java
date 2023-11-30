package com.si.tpIntegration.services;

import com.si.tpIntegration.entite.Employe;
import com.si.tpIntegration.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

@Service
public class EmployeService implements IEmployeService{
    @Autowired
    private EmployeRepository employeeRepository;

    @Override
    public List<Employe> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employe getOneEmployee(int id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employe saveEmploye(Employe employee) {
        String matricule = genMat(employee.getNom(), employee.getPrenom());
        employee.setMatricule(matricule);
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmploye(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employe> getAllEmployeBySex(String sex) {
        List<Employe> AllEmploye = employeeRepository.findAll();
        return AllEmploye.stream().filter(employe -> employe.getSexe().equalsIgnoreCase(sex)).toList();

    }

    @Override
    public String getEmployeAge(int id) {
        LocalDate currentDate = LocalDate.now();
        int employeAge = Period.between(employeeRepository.findById(id).get().getDate_naissance(), currentDate).getYears();
        return "Cet employé à "+ employeAge+ " ans";
    }


    public static String genMat(String nom, String prenom) {
        int length = 4;
        Random random = new Random();
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(caracteres.length());
            char randomChar = caracteres.charAt(randomIndex);
            sb.append(randomChar);
        }

        String mat = sb.toString() + nom.substring(0, 2).toUpperCase() + prenom.substring(0, 2).toUpperCase();
        return mat;
    }
}

package com.si.tpIntegration.services;

import com.si.tpIntegration.entite.Employe;
import com.si.tpIntegration.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmploye(int id) {
        employeeRepository.deleteById(id);
    }
}

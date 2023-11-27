package com.si.tpIntegration.services;

import com.si.tpIntegration.entite.Employe;

import java.util.List;

public interface IEmployeService {

    public List<Employe> getAllEmployees();
    public Employe saveEmploye(Employe employee);
    public Employe getOneEmployee(int id);
    public void deleteEmploye(int id);
}

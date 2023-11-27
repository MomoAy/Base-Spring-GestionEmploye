package com.si.tpIntegration.repository;

import com.si.tpIntegration.entite.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
/*import org.springframework.data.rest.core.annotation.RepositoryRestResource;*/

//@RepositoryRestResource
public interface EmployeRepository extends JpaRepository<Employe, Integer> {

    
}

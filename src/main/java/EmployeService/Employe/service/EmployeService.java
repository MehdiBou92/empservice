package EmployeService.Employe.service;

import EmployeService.Employe.entities.Employe;

import java.util.List;
import java.util.Optional;

public interface EmployeService {

    Employe addEmploye (Employe employe);

    Optional<Employe> findEmployeById (Long id);
    List<Employe> findAllEmployees ();
}

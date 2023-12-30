package EmployeService.Employe.service.Impl;

import EmployeService.Employe.entities.Employe;
import EmployeService.Employe.repository.EmployeRepository;
import EmployeService.Employe.service.EmployeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeServiceImpl implements EmployeService {
    private final EmployeRepository employeRepository;

    public EmployeServiceImpl(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    public Employe addEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    public Optional<Employe> findEmployeById(Long id) {
        return employeRepository.findById(id);
    }

    public List<Employe> findAllEmployees() {
        return employeRepository.findAll();
    }
}

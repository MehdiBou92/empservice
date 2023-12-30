package EmployeService.Employe.controller;

import EmployeService.Employe.entities.Employe;
import EmployeService.Employe.service.EmployeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employe")
public class EmployeController {

    private final EmployeService employeService;

    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @PostMapping("/add")
    public ResponseEntity<Employe> addEmploye (@RequestBody Employe employe){

        Employe savedEmploye = employeService.addEmploye(employe);
        return ResponseEntity.ok(savedEmploye);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employe>> findEmployeById (@PathVariable Long id){
        Optional<Employe> optionalEmploye = employeService.findEmployeById(id);
        return ResponseEntity.ok(optionalEmploye);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employe>> findAllEmployees () {
        return ResponseEntity.ok(employeService.findAllEmployees());
    }
}

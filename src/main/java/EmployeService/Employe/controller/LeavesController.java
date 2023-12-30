package EmployeService.Employe.controller;

import EmployeService.Employe.entities.Employe;
import EmployeService.Employe.entities.Leave;
import EmployeService.Employe.service.LeaveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/leave")
public class LeavesController {
    public final LeaveService leaveService ;
    public LeavesController(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<Employe> addLeave (@PathVariable Long id, @RequestBody Leave leave){
        Employe employeWithLeave = leaveService.addLeave(id,leave);
        return ResponseEntity.ok(employeWithLeave);
    }
}

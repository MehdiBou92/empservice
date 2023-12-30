package EmployeService.Employe.repository;

import EmployeService.Employe.entities.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<Leave,Long> {
}

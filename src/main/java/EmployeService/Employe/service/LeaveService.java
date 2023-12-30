package EmployeService.Employe.service;

import EmployeService.Employe.entities.Employe;
import EmployeService.Employe.entities.Leave;

public interface LeaveService {

    Employe addLeave (Long id , Leave leave);
}

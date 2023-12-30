package EmployeService.Employe.service.Impl;

import EmployeService.Employe.entities.Employe;
import EmployeService.Employe.entities.Leave;
import EmployeService.Employe.repository.EmployeRepository;
import EmployeService.Employe.repository.LeaveRepository;
import EmployeService.Employe.service.LeaveService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {

    private final LeaveRepository leaveRepository;
    private final EmployeRepository employeRepository;

    public LeaveServiceImpl(LeaveRepository leaveRepository, EmployeRepository employeRepository) {
        this.leaveRepository = leaveRepository;
        this.employeRepository = employeRepository;
    }

    @Transactional
    public Employe addLeave(Long id, Leave leave) {

        Employe employe = employeRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Employe Not Found"));

        // Calculate requestedLeave :
        float requestedLeave = leave.getMaternityLeave()
                + leave.getSickLeave()
                + leave.getVacationLeave()
                + leave.getUnjustifiedLeave();

        // Find if the employee has ennough leave credit :
        if(employe.getSolde() >  requestedLeave){
            // Update the creditLeave :
            employe.setSolde(employe.getSolde() - requestedLeave);

            // Save Leave :
            leaveRepository.save(leave);

            // Add Leave to Employe :
            employe.getLeaves().add(leave);

            // Save Employe :
            employeRepository.save(employe);
        } else {
            throw new IllegalArgumentException("Employe does not have ennough credit Leave ");
        }
        return employe;
    }
    //todo : Seniority


    public void updateCreditLeave (){
        // Retreive all employees :
        List<Employe> employees = employeRepository.findAll();

        float addtionalLeave = 1.5f;

        for(Employe employe : employees){
            employe.setSolde(employe.getSolde() + addtionalLeave);
        }
    }
}

package EmployeService.Employe.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employe")
@Data
@Builder
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate brithDate;
    private LocalDate hiringDate;
    private float solde;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Leave> leaves;


}

package ega.appli.ega.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.List;
@Entity
@NoArgsConstructor
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCli;
    @Column(length = 30)
    private String nom;
    @Column(length = 30)
    private String prenom;
    private LocalDate dateNaissance;
    @Column(length = 1)
    private String sex;
    private String email;
    private String tel;
    private String nationalité;
    @OneToMany(targetEntity = Compte.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_cli_compte", referencedColumnName = "idCli")

    private List<Compte> comptes;
}

package ega.appli.ega.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "comptes")
public class Compte {


    @Column(length = 30)
    @Id
    private String numCompte;
    @Column(length = 30)
    private String typeCompte;
    private LocalDate dateCreation;
    private Double solde=0.0;


}

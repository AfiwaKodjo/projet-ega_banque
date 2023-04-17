package ega.appli.ega.services;

import java.util.List;

import ega.appli.ega.entities.Compte;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface CompteService {
    Compte creer(Integer id, Compte compte);

    List<Compte> lire();
    Compte modifier(Integer id, Compte compte);
    String suprimer(String numCpt);
    Compte versement(String numCpt, Double montant);
    Compte retrait(String numCpt, Double montant);
    Compte virement(String numCptDebit, String numCptCredit, Double montant);

}

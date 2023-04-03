package ega.appli.ega.services;

import java.util.List;
import ega.appli.ega.entities.Compte;
public interface CompteService {
    Compte creer(Integer id, Compte compte);
    List<Compte> lire();
    String suprimer(String numCpt);
    Compte versement(String numCpt, Double montant);
    Compte retrait(String numCpt, Double montant);
    Compte virement(String numCptDebit, String numCptCredit, Double montant);

}

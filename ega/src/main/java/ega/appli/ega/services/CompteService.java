package ega.appli.ega.services;

import java.util.List;

import ega.appli.ega.entities.Compte;

public interface CompteService {
    Compte creer(Compte compte);

    List<Compte> lire();
    Compte modifier(String numeroCompte, Compte compte);
    String suprimer(String numCpt);
    Compte versement(String numCpt, Double montant);
    Compte retrait(String numCpt, Double montant);
    Compte virement(String numCptDebit, String numCptCredit, Double montant);

}

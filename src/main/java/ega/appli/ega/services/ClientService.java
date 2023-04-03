package ega.appli.ega.services;
import ega.appli.ega.entities.Client;
import ega.appli.ega.entities.Compte;
import java.util.List;

public interface ClientService {
    Client creer(Client client);
    List<Client> lire();
    Client lireClient(Integer id);
    Client addCompte(Integer id, Compte compte);
    Client modifier(Integer id, Client client);
    String suprimer(Integer id);

}

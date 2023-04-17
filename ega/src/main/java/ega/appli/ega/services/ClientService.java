package ega.appli.ega.services;
import ega.appli.ega.entities.Client;


import java.util.List;

public interface ClientService {
    Client creer(Client client);
    List<Client> lire();
    Client lireClient(Integer id);
    Client modifier(Integer id, Client client);
    String suprimer(Integer id);

}

package ega.appli.ega.services;
import ega.appli.ega.entities.Client;
import ega.appli.ega.entities.Compte;
import ega.appli.ega.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ClientServiceImp implements ClientService{
    private final ClientRepository clientRepository;
    @Override
    public Client creer(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> lire() {
        return clientRepository.findAll();
    }

    @Override
    public Client lireClient(Integer id) {
        return clientRepository.findById(id).orElseThrow(()-> new RuntimeException("Client non trouvé"));
    }

    @Override
    public Client addCompte(Integer id, Compte compte) {
        return null;
    }

    @Override
    public Client modifier(Integer id, Client client) {
        return clientRepository.findById(id).map(
                p->{
                    p.setEmail(client.getEmail());
                    p.setNom(client.getNom());
                    p.setPrenom(client.getPrenom());
                    p.setTel(client.getTel());
                    return clientRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Client non trouvé !"));
    }

    @Override
    public String suprimer(Integer id) {
        if(clientRepository.existsById(id)){
            clientRepository.deleteById(id);
            return "client suprimé";
        }else {return "Client non trouvé !";}

    }

}

package ega.appli.ega.services;
import ega.appli.ega.entities.Client;
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
        client.getComptes().forEach((x)->{
            x.setNumCompte(CompteServiceImp.NumeroCompte(x));
        });
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
    public Client modifier(Integer id, Client client) {
        return clientRepository.findById(id).map(
                p->{
                    p.setEmail(client.getEmail());
                    p.setNom(client.getNom());
                    p.setDateNaissance(client.getDateNaissance());
                    p.setPrenom(client.getPrenom());
                    p.setTel(client.getTel());
                    p.setNationalité(client.getNationalité());
                    p.setSex(client.getSex());
                    return clientRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Client non trouvé !"));
    }

    @Override
    public String suprimer(Integer id) {
        System.out.println(clientRepository.existsById(id));
        if(clientRepository.existsById(id)){
            clientRepository.deleteById(id);
            return "client supprimé";
        }else {return "Client non trouvé !";}

    }

}

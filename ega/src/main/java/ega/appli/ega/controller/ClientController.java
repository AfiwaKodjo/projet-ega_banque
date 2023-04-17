package ega.appli.ega.controller;

import ega.appli.ega.entities.Client;
import ega.appli.ega.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;


    @PostMapping("/creer")
    public Client create(@RequestBody Client client){
        return clientService.creer(client);
    }

    @GetMapping("/lire")
    public List<Client> read(){
        return clientService.lire();
    }
    @GetMapping("/lire/{id}")
    public Client readCli(@PathVariable Integer id){
        return clientService.lireClient(id);
    }
    @PutMapping("/modifier/{id}")
    public Client update(@PathVariable Integer id, @RequestBody Client client){
        return clientService.modifier(id, client);
    }

    @DeleteMapping("/supprimer/{id}")
    public String delete(@PathVariable Integer id){
        return clientService.suprimer(id);
    }
}

package ega.appli.ega.controller;

import ega.appli.ega.entities.Compte;
import ega.appli.ega.services.CompteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/compte")
@AllArgsConstructor
public class CompteController {
    private final CompteService compteService;
    @PostMapping("/creer_compte")
    public Compte create(@RequestBody Compte compte){
        return compteService.creer(compte.getId(), compte);
    }

    @GetMapping("/lire")
    public List<Compte> read(){
        return compteService.lire();
    }

    @DeleteMapping("/supprimer/{numCompte}")
    public String delete(@PathVariable String numCompte){
        return compteService.suprimer(numCompte);
    }

    /*@PatchMapping("/versement/{numCompte}")
    public Compte versement(@RequestBody String numeroCompte, @RequestBody Double montant){
        return compteService.versement(numeroCompte, montant);
    }*/

    @PostMapping("/versement/{numCompte}")
    public Compte versement(@PathVariable String numeroCompte, @RequestBody Double montant){
        return compteService.versement(numeroCompte, montant);
    }

    @PatchMapping("/retrait/{numCompte}")
    public Compte retrait(@RequestBody String numeroCompte, @RequestBody Double montant){
        return compteService.retrait(numeroCompte, montant);
    }

    @PatchMapping("/virement/{numCompte}")
    public Compte virement(@RequestBody String numeroCompteDebit, @RequestBody Double montant, @RequestBody String numeroCompteCredit){
        return compteService.virement(numeroCompteDebit, numeroCompteCredit, montant);
    }

    @PutMapping("/modifierCompte/{id}")
    public Compte update(@PathVariable Integer id, @RequestBody Compte compte){
        return compteService.modifier(id, compte);
    }

}

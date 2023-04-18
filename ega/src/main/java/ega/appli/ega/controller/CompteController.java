package ega.appli.ega.controller;

import ega.appli.ega.allRecords.CompteOperation;
import ega.appli.ega.allRecords.CompteVirement;
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
    @PostMapping("/creer")
    public Compte create(@RequestBody Compte compte){
        return compteService.creer(compte);
    }

    @GetMapping("/lire")
    public List<Compte> read(){
        return compteService.lire();
    }

    @DeleteMapping("/supprimer/{numCompte}")
    public String delete(@PathVariable String numCompte){
        return compteService.suprimer(numCompte);
    }



    @PostMapping("/versement")
    public Compte versement(@RequestBody CompteOperation compteOperation){
        return compteService.versement(compteOperation.NumeroCompte(), compteOperation.Montant());
    }

    @PostMapping("/retrait")
    public Compte retrait(@RequestBody CompteOperation compteOperation){
        return compteService.retrait(compteOperation.NumeroCompte(), compteOperation.Montant());
    }

    @PostMapping("/virement")
    public Compte virement(@RequestBody CompteVirement VirementOperation){
        return compteService.virement(VirementOperation.NumCompteCrediter(),
                VirementOperation.NumCompteRecepteur(), VirementOperation.Montant());
    }

    @PutMapping("/modifierCompte/{numeroCompte}")
    public Compte update(@PathVariable String numeroCompte, @RequestBody Compte compte){
        return compteService.modifier(numeroCompte, compte);
    }

}

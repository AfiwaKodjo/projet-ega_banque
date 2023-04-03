package ega.appli.ega.services;

import ega.appli.ega.entities.Compte;
import ega.appli.ega.repositories.CompteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;


@Service
@AllArgsConstructor
public class CompteServiceImp implements CompteService{
    private final CompteRepository compteRepository;
    public static final String ALPHANUM = "AZERTYUIOPQSDFGHJKLMWXCVBN123456789";
    public static String NumeroCompte(Compte compte){
        Random random = new Random();
        StringBuilder builder = new StringBuilder();

        for(int i=0; i<5; i++){
            builder.append(ALPHANUM.charAt(random.nextInt(ALPHANUM.length())));
        }
        builder.append(compte.getDateCreation().getYear());
        return builder.toString();
    }
    @Override
    public Compte creer(Integer id, Compte compte) {
        compte.setNumCompte(NumeroCompte(compte));
        return compteRepository.save(compte);
    }

    @Override
    public List<Compte> lire() {
        return compteRepository.findAll();
    }

    @Override
    public String suprimer(String numCpt) {
        if(compteRepository.existsById(numCpt)){
            compteRepository.deleteById(numCpt);
            return "compte suprimé";
        }else {return "compte non trouvé !";}
    }

    @Override
    public Compte versement(String numCpt, Double montant) {
        return compteRepository.findById(numCpt).map(
                p->{
                    p.setSolde(p.getSolde()+montant);
                    return compteRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Compte non trouvé !"));

    }

    @Override
    public Compte retrait(String numCpt, Double montant) {
        return compteRepository.findById(numCpt).map(
                p->{
                    p.setSolde(p.getSolde()-montant);
                    return compteRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Compte non trouvé !"));
    }

    @Override
    public Compte virement(String numCptDebit, String numCptCredit, Double montant) {
        retrait(numCptDebit, montant);
        versement(numCptCredit, montant);
        return null;
    }
}

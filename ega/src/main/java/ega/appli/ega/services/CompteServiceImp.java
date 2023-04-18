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
    public static final String ALPHANUM = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
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
    public Compte creer(Compte compte) {
        compte.setNumCompte(NumeroCompte(compte));
        return compteRepository.save(compte);
    }

    @Override
    public List<Compte> lire() {
        return compteRepository.findAll();
    }
    @Override
    public Compte modifier(String numeroCompte, Compte compte) {
        return compteRepository.findById(String.valueOf(numeroCompte)).map(
                p->{
                    p.setTypeCompte(compte.getTypeCompte());
                    p.setDateCreation(compte.getDateCreation());
                    p.setSolde(compte.getSolde());

                    return compteRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Client non trouvé !"));
    }

    @Override
    public String suprimer(String numCpt) {
        if(compteRepository.existsById(numCpt)){
            compteRepository.deleteById(numCpt);
            return "compte supprimé";
        }else {return "compte non trouvé !";}
    }


    @Override
    public Compte versement(String numCpt, Double montant) {
        var compte = compteRepository.findById(numCpt);
        if (compte.isPresent()) {
            var cpt = compte.get();
            cpt.setSolde(cpt.getSolde()+montant);
            return compteRepository.save(cpt);


        }
        throw new RuntimeException("Compte non trouvé !");


    }

    @Override
    public Compte retrait(String numCpt, Double montant) {
        var compte = compteRepository.findById(numCpt);
        if (compte.isPresent()) {
            var cpt = compte.get();
            if(cpt.getSolde() < montant)
                throw new RuntimeException("Solde du compte insuffisant pour effectuer le retrait !");
            cpt.setSolde(cpt.getSolde() - montant);
            return compteRepository.save(cpt);
        }
        throw new RuntimeException("Compte non trouvé !");


    }

    @Override
    public Compte virement(String numCptDebit, String numCptCredit, Double montant) {
        retrait(numCptDebit, montant);
        return versement(numCptCredit, montant);
    }
}

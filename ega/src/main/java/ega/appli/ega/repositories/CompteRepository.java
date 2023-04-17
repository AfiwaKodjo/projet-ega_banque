package ega.appli.ega.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ega.appli.ega.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String> {
}

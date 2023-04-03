package ega.appli.ega.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ega.appli.ega.entities.Client;



public interface ClientRepository extends JpaRepository<Client, Integer> {
}

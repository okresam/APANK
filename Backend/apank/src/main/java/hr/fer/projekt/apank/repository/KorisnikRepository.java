package hr.fer.projekt.apank.repository;

import hr.fer.projekt.apank.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

    Optional<Korisnik> findByEmail(String email);

    Boolean existsByEmail(String email);
}

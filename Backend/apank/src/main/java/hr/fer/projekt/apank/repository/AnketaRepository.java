package hr.fer.projekt.apank.repository;

import hr.fer.projekt.apank.model.Anketa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnketaRepository extends JpaRepository<Anketa, Long> {

    List<Anketa> findByAutor_IdKorisnika(Long id);
}

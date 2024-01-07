package hr.fer.projekt.apank.repository;

import hr.fer.projekt.apank.model.Odgovor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OdgovorRepository extends JpaRepository<Odgovor, Long> {
}

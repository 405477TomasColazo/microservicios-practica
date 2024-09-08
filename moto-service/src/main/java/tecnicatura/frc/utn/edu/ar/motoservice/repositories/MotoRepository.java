package tecnicatura.frc.utn.edu.ar.motoservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tecnicatura.frc.utn.edu.ar.motoservice.entities.Moto;

import java.util.List;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long> {
    List<Moto> findByUsuarioId(Long id);
}

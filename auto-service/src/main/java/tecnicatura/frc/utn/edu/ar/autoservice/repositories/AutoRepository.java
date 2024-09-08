package tecnicatura.frc.utn.edu.ar.autoservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tecnicatura.frc.utn.edu.ar.autoservice.entities.Auto;

import java.util.List;
@Repository
public interface AutoRepository extends JpaRepository<Auto, Long> {
    List<Auto> findByUsuarioId(Long id);
}

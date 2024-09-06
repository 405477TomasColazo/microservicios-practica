package tecnicatura.frc.utn.edu.ar.usuario_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tecnicatura.frc.utn.edu.ar.usuario_service.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
